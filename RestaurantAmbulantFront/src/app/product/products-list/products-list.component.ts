import { Component, OnInit, Injectable } from '@angular/core';
import { Product } from 'src/app/models/product';
import { GlobalConfig } from 'src/app/models/global-config';
import { ProductService } from '../product.service';
import { Day } from 'src/app/models/day.enum';
import { MealService } from 'src/app/meal/meal.service';
import { Meal } from 'src/app/models/meal';
import { NgbDateParserFormatter, NgbDateStruct, NgbDatepickerI18n, NgbCalendar } from '@ng-bootstrap/ng-bootstrap';
import { Basket } from 'src/app/models/basket';
import { CommandLine } from 'src/app/models/command-line';
import { OrderService } from 'src/app/order/order.service';
import { LogInComponent } from 'src/app/user/log-in/log-in.component';

const I18N_VALUES = {
  'fr': {
    weekdays: ['Lu', 'Ma', 'Me', 'Je', 'Ve', 'Sa', 'Di'],
    months: ['Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Juin', 'Juil', 'Aou', 'Sep', 'Oct', 'Nov', 'Déc'],
  }
};

@Injectable()
export class I18n {
  language = 'fr';
}

@Injectable()
export class CustomDatepickerI18n extends NgbDatepickerI18n {

  constructor(private _i18n: I18n) {
    super();
  }

  getWeekdayShortName(weekday: number): string {
    return I18N_VALUES[this._i18n.language].weekdays[weekday - 1];
  }
  getMonthShortName(month: number): string {
    return I18N_VALUES[this._i18n.language].months[month - 1];
  }
  getMonthFullName(month: number): string {
    return this.getMonthShortName(month);
  }

  getDayAriaLabel(date: NgbDateStruct): string {
    return `${date.day}-${date.month}-${date.year}`;
  }
}

@Injectable()
export class CustomDateParserFormatter extends NgbDateParserFormatter {

  readonly DELIMITER = '/';

  parse(value: string): NgbDateStruct | null {
    if (value) {
      let date = value.split(this.DELIMITER);
      return {
        day : parseInt(date[0], 10),
        month : parseInt(date[1], 10),
        year : parseInt(date[2], 10)
      };
    }
    return null;
  }

  format(date: NgbDateStruct | null): string {
    return date ? date.day + this.DELIMITER + (date.month<10?"0":"") + date.month + this.DELIMITER + date.year : '';
  }
}

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css'],
  providers: [
    {provide: NgbDateParserFormatter, useClass: CustomDateParserFormatter},
    I18n,
    {provide: NgbDatepickerI18n, useClass: CustomDatepickerI18n}
  ]
})
export class ProductsListComponent implements OnInit {

  products : Product[] = []
  meals : Meal[] = []
  mealsDisplay : Map<number, boolean> = new Map()
  days : string[] = Object.keys(Day)
  daysNames : string[] = ["MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"]
  daysDisplay : Map<string, boolean> = new Map()
  Days = Day
  basket = Basket
  deliveryTimes : string[] = []
  displayAvailableOnly : boolean = false
  commandSent : boolean = false

  endPoint : string = GlobalConfig.serverUrl

  isDisplayed(product : Product) : boolean {
    let hasMeal : boolean = false
    product.meals.forEach(meal => {if (this.mealsDisplay.get(meal.mealId)) hasMeal = true})
    let hasDay : boolean = false
    product.days.forEach(day => {if (this.daysDisplay.get(day)) hasDay = true})
    return hasMeal && hasDay
  }

  isAvailable(product : Product) : boolean {
    let isAvailable : boolean = true
    if (Basket.deliveryDay != undefined)  {
      isAvailable = product.days.toString().includes(Object.values(this.days)[this._ngbCalendar.getWeekday(Basket.deliveryDay)-1])
    }
    if (Basket.meal != undefined) {
      isAvailable = isAvailable && product.meals.map(meal => meal.mealId).includes(Basket.meal.mealId)
    }
    return isAvailable
  }

  toggleMealDisplay(mealId : number) {
    this.mealsDisplay.set(mealId, !this.mealsDisplay.get(mealId))
  }

  toggleDayDisplay(day : string) {
    this.daysDisplay.set(day, !this.daysDisplay.get(day))
  }

  toggleAvailableDisplay() {
    this.displayAvailableOnly = !this.displayAvailableOnly
    this.updateAvailabilities()
  }

  updateAvailabilities() {
    if (Basket.meal != undefined) {
      this.meals.forEach(meal => {this.mealsDisplay.set(meal.mealId, !this.displayAvailableOnly || meal == Basket.meal)})
    }
    if (Basket.deliveryDay != undefined) {
      this.daysNames.forEach((day, index) => {this.daysDisplay.set(day, !this.displayAvailableOnly || 
        index == this._ngbCalendar.getWeekday(Basket.deliveryDay)-1)})
    }
  }

  get today() {
    return this._ngbCalendar.getToday()!;
  }

  get finalDay() {
    return this._ngbCalendar.getNext(this._ngbCalendar.getToday(), "d", 13)
  }

  commandIsSent() : boolean {
    return this.commandSent
  }

  onMealChanged() {
    this.updateAvailabilities()
    this.deliveryTimes = []
    if (Basket.meal == undefined) {
      return this.deliveryTimes
    }
    let beginHour : string[] = Basket.meal.beginHour.toString().split(":")
    let beginHours : number = +beginHour[0]
    let beginMinutes : number = +beginHour[1]
    let endHour : string[] = Basket.meal.endHour.toString().split(":")
    let endHours : number = +endHour[0]
    let endMinutes : number = +endHour[1]
    for (let hours : number = beginHours; hours <= endHours; hours++) {
      for (let minutes : number = (hours==beginHours)?beginMinutes:0; minutes <= ((hours==endHours)?endMinutes:45); minutes+=15) {
        this.deliveryTimes.push(hours + "h" + (minutes==0?"00":minutes))
      }
    }
    return this.deliveryTimes
  }
  
  constructor(
    private _productService : ProductService,
    private _mealService : MealService,
    private _ngbCalendar: NgbCalendar,
    private _orderService: OrderService
  ) { }

  ngOnInit(): void {
    if (!LogInComponent.isConnected()) {
      Basket.delete()
    }
    this.days.forEach(day => this.daysDisplay.set(day, true))
    this._mealService.getMeals().subscribe((response) => {
      this.meals = response
      this.meals.forEach(meal => this.mealsDisplay.set(meal.mealId, true))
    })
    this._productService.getProducts().subscribe((response) => {
      this.products = response
    })
  }

  hasBasket() {
    return Basket.hasBasket
  }

  createBasket(product : Product) {
    this._orderService.createBasket(product)
  }

  addBasket(product : Product) {
    Basket.add(product)
  }

  riseQuantity(commandLine : CommandLine, toAdd : number) {
    Basket.riseQuantity(commandLine, toAdd)
  }

  deleteLine(commandLine : CommandLine) {
    Basket.deleteLine(commandLine)
  }

  basketIsValid() : boolean {
    if (Basket.deliveryDay == undefined || Basket.deliveryHour == undefined || Basket.commandLines.length == 0) {
      return false
    }
    let isValid : boolean = true
    Basket.commandLines.forEach(commandLine => {if (!this.isAvailable(commandLine.product)) isValid = false})
    return isValid
  }

  validateBasket() {
    //Ici nous devrions enregistrer le panier en back, mais nous n'avons pas eu le temps de le coder :/
    this.deleteBasket()
    this.commandSent = true
    setTimeout(() => {
      this.commandSent = false
    }, 4000);
  }

  deleteBasket() {
    Basket.delete()
  }
}

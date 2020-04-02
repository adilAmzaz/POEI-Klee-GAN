import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Product } from 'src/app/models/product';
import { ProductService } from '../product.service';
import { Meal } from 'src/app/models/meal';
import { Day } from 'src/app/models/day.enum';
import { Basket } from 'src/app/models/basket';
import { MealService } from 'src/app/meal/meal.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  constructor(private _productService: ProductService,
              private _mealService: MealService,
              private _router: Router) { }

  ngOnInit(): void {
    this.days.forEach(day => this.daysDisplay.set(day, true))
    this._mealService.getMeals().subscribe((response) => {
      this.meals = response
      this.meals.forEach(meal => this.mealsDisplay.set(meal.mealId, true))
    })
  }

  productForm = new FormGroup(
    {
      label: new FormControl(null, [Validators.required]),
      image: new FormControl(),
      composition: new FormControl(),
      price: new FormControl(null, [Validators.required]),
      stock: new FormControl(0)
    }
  )
  attempted: boolean = false;
  meals : Meal[] = []
  mealsDisplay : Map<number, boolean> = new Map()
  days : string[] = Object.keys(Day)
  daysNames : string[] = ["MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"]
  daysDisplay : Map<string, boolean> = new Map()
  Days = Day

  addProduct(): void
  {
    this.attempted = true;
    if (!this.productForm.invalid)
    {
      let user: Product;
      //console.log("Product:", this.generateProduct());
      this._productService.addProduct(this.generateProduct()).subscribe(
        (data) =>
          {
            if (data != null)
            {
              this._router.navigate(['log-in']);
            }
            else
            {
              console.log("Sign up failed: ", data);
            }
            //console.log("Complete (AddCompany): ", data);
          }
      );
    }
  }

  generateProduct(): Product
  {
    let prod: Product = new Product();
    prod.productId = 0;
    prod.count = 0;
    prod.label = this.productForm.controls['label'].value;
    prod.imageRelativePath = this.productForm.controls['image'].value;
    prod.composition = this.productForm.controls['composition'].value;
    prod.price = this.productForm.controls['price'].value;
    prod.stock = this.productForm.controls['stock'].value;
    prod.meals = [];
    this.mealsDisplay.forEach((value: boolean, key: number) => 
    {
      if (this.mealsDisplay.get(key))
        prod.meals.push(this.meals.find((meal) => meal.mealId == key));
    })
    prod.days = [];
    this.daysDisplay.forEach((value: boolean, key: string) => 
    {
      if (this.daysDisplay.get(key))
        prod.days.push(Day[key]);
    })
    return prod;
  }

  getErrorMessage(form: string): string
  {
    const control = this.productForm.controls[form];
    if ((control.touched || this.attempted))
    {

      //const mailError = control.getError('validatorMail', [form]);
      //if (mailError != null)
      if (control.hasError('pattern'))
      {
        return "Invalid Format";
      }
      if (control.hasError('required'))
        return "This field is required";
    }
    return "";
    
  }

  toggleMealDisplay(mealId : number) {
    //console.log(mealId);
    this.mealsDisplay.set(mealId, !this.mealsDisplay.get(mealId))
  }

  toggleDayDisplay(day : string) {
    //console.log(this.days.indexOf(day))
    this.daysDisplay.set(day, !this.daysDisplay.get(day))
  }

}

import { Component, OnInit } from '@angular/core';
import { Meal } from '../models/meal';
import { MealService } from '../meal/meal.service';
import { UserHttpService } from '../user/user-http.service';
import { User, Individual } from '../models/user';
import { LogInComponent } from '../user/log-in/log-in.component';

@Component({
  selector: 'app-modify-hours-of-meals',
  templateUrl: './modify-hours-of-meals.component.html',
  styleUrls: ['./modify-hours-of-meals.component.css']
})
export class ModifyHoursOfMealsComponent implements OnInit {

  meals : Meal[];
  meal : Meal;
  count : number = 0;
  isAdminVar : boolean = false;
  user : Individual;

  constructor(private _mealService : MealService,
              private _userService : UserHttpService) { }

  ngOnInit(): void {
    this._mealService.getMeals().subscribe(response =>{
      this.meals = response;
    }
    )
    this.meal = this.meals[0]
    setTimeout(function() {
      console.log('Teskljkljkljkljkljklt');
       }, 2000);
  }

  submit()
  {
    this._mealService.addMeal(this.meal).subscribe(
      data =>{
        console.log("add company Result:",data)
      }
    )
  }
  suivant()
  {
    if(this.count<4){
      this.count ++
      this.meal = this.meals[this.count]
    }
      else{
        this.count = 0
        this.meal = this.meals[this.count]

      }
  }



}

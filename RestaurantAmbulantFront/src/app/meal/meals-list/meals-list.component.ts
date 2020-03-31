import { Component, OnInit } from '@angular/core';
import { Meal } from 'src/app/models/meal';
import { MealService } from '../meal.service';

@Component({
  selector: 'app-meals-list',
  templateUrl: './meals-list.component.html',
  styleUrls: ['./meals-list.component.css']
})
export class MealsListComponent implements OnInit {

  meals : Meal[] = []

  constructor(
    private _mealService : MealService
  ) { }

  ngOnInit(): void {
    this._mealService.getMeals().subscribe((response) => {
      this.meals = response
    })
  }

}

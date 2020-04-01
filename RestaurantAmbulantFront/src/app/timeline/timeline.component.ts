import { Component, OnInit } from '@angular/core';
import { MealService } from '../meal/meal.service';
import { Meal } from '../models/meal';
import { GlobalConfig } from '../models/global-config';


@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {


  endPoint : string = GlobalConfig.serverUrl
  meals : Meal[] 
  constructor(private _mealService: MealService) { }
  length : number =0;
  ngOnInit(): void {
    this._mealService.getMeals().subscribe((response) => {
      this.meals = response;
    })
  }


}

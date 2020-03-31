import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Meal } from '../models/meal';
import { Observable } from 'rxjs';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class MealService {

  constructor(
    private _http : HttpClient,
    private _router : Router
  ) { }

  getMeals() : Observable<Meal[]> {
    return this._http.get<Meal[]>(GlobalConfig.serverUrl + "getmeals")
  }
}

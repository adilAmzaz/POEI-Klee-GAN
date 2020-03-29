import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Actuality } from '../models/actuality';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class ActualityService {

  constructor(
    private _http : HttpClient,
    private _router : Router
  ) { }

  getCount() : Observable<number> {
    return this._http.get<number>(GlobalConfig.actualityEndPoint + "count")
  }

  getIds() : Observable<number[]> {
    return this._http.get<number[]>(GlobalConfig.actualityEndPoint + "ids")
  }

  getActualities() : Observable<Actuality[]> {
    return this._http.get<Actuality[]>(GlobalConfig.actualityEndPoint + "all")
  }

  getActualitiesBetween(first: number, last: number) : Observable<Actuality[]> {
    return this._http.get<Actuality[]>(GlobalConfig.actualityEndPoint + first + "/" + last)
  }

  getById(id: number) : Observable<Actuality> {
    return this._http.get<Actuality>(GlobalConfig.actualityEndPoint + id)
  }
}

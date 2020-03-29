import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../models/user';
import { Observable } from 'rxjs';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class UserHttpService {

  constructor(private _http: HttpClient)
  { }
  
  getUsers() : Observable<User[]> {
    return this._http.get<User[]>(GlobalConfig.getUsersEndPoint);
  } 

}

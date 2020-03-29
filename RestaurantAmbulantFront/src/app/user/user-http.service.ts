import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User, Company, Individual } from '../models/user';
import { Observable } from 'rxjs';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class UserHttpService {

  constructor(private _http: HttpClient)
  { }
  
  getUsers(): Observable<User[]> {
    return this._http.get<User[]>(GlobalConfig.getUsersEndPoint);
  }

  addCompany(company: Company): any
  {
    console.log(GlobalConfig.serverUrl + "addCompany");
    return this._http.post(GlobalConfig.serverUrl + "addCompany", 
      {
        "email": company.email,
        "password": company.password,
        "phone": company.phone,
        "address": company.address,
        "zipcode": company.zipcode,
        "city": company.city,
        "name": company.name
      },
      this.httpOptions);
  }
  addIndividual(user: Individual): any
  {
    console.log(GlobalConfig.serverUrl + "addIndividual");
    return this._http.post(GlobalConfig.serverUrl + "addIndividual", 
      {
        "email": user.email,
        "password": user.password,
        "phone": user.phone,
        "address": user.address,
        "zipcode": user.zipcode,
        "city": user.city,
        "firstName": user.firstName,
        "lastName": user.lastName,
        "birthDate": user.birthDate.toString(),
        "female": user.female,
        "adminRights": user.adminRights
      },
      this.httpOptions);
  }

  addUser(user: User): any
  {
    return this._http.post<User>(GlobalConfig.serverUrl + "addUser",
      user, this.httpOptions);
  }
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

}

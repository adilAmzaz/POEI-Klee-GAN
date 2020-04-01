import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User, Company, Individual } from '../models/user';
import { Observable } from 'rxjs';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class UserHttpService {

  constructor(private _http: HttpClient)
  { }
  
  getUsers(): Observable<User[]>
  {
    return this._http.get<User[]>(GlobalConfig.getUsersEndPoint);
  }

  getUserById(id: number): Observable<User>
  {
    return this._http.get<User>(GlobalConfig.serverUrl+"getuser-id/"+id);
  }
  getUserByEMail(email: string): Observable<User>
  {
    return this._http.get<User>(GlobalConfig.serverUrl+"getuser/"+email);
  }

  addCompany(company: Company): Observable<Company>
  {
    return this._http.post<Company>(GlobalConfig.serverUrl + "addCompany", company);
  }
  addIndividual(individual: Individual): Observable<Individual>
  {
    return this._http.post<Individual>(GlobalConfig.serverUrl + "addIndividual", individual);
  }

  // addUser(user: User)
  // {
  //   return this._http.post<User>(GlobalConfig.serverUrl + "addUser",
  //     user);
  // }

  updateCompany(company: Company)
  {
    return this._http.put<Company>(GlobalConfig.serverUrl + "modifycompany/" + company.userId, company);
  }
  updateIndividual(individual: Individual)
  {
    return this._http.put<Company>(GlobalConfig.serverUrl + "modifyindividual/" + individual.userId, individual);
  }

}

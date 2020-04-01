import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Command } from '../models/command';
import { GlobalConfig } from '../models/global-config';
import { LogInComponent } from '../user/log-in/log-in.component';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  constructor(
    private _http: HttpClient,
    private _router: Router
  ) { }

  createBasket() {
    if (LogInComponent.isConnected()) {
      this._router.navigate(['/products'])
    }
    else {
      this._router.navigate(['/products'])
      //this._router.navigate(['/log-in'])
    }
  }
  
  getCommands() : Observable<Command[]> {
    return this._http.get<Command[]>(GlobalConfig.getCommandsEndPoint);
  } 

  getCommandById(id:string) : Observable<Command> {
    return this._http.get<Command>(GlobalConfig.getCommandByIdEndPoint+id);
  } 

  getCommandByEmail(email:string) : Observable<Command[]> {
    return this._http.get<Command[]>(GlobalConfig.getCommandByEmailEndPoint+email);
  } 
}

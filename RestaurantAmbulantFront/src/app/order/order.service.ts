import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommandLine } from '../models/command-line';
import { Command } from '../models/command';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


  constructor(private _http: HttpClient)
  { }
  
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

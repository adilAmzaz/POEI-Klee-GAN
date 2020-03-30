import { Component, OnInit } from '@angular/core';
import { Command } from 'src/app/models/command';
import {  Directive, EventEmitter, Input, Output, QueryList, ViewChildren } from '@angular/core';

//import 'rxjs/add/operator/map';
//import {Response} from '@angular/common/http';
import { Observable } from 'rxjs';
import { OrderHistoryHttpServiceService } from '../order-history-http-service.service';
@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  emailUser : string = "company3";
  idCommand : string = "";
  command : Command;
  listCommands : Command[]=[];
  listCommandsByEmail : Command[]=[];

  constructor(private _ohhs: OrderHistoryHttpServiceService) { }

  ngOnInit(): void {
    this._ohhs.getCommands().subscribe(
      (commands) =>
      {
        this.listCommands = commands;
        console.log("liste",this.listCommands);
      }
    )
    //this.listCommandsByEmail = this.getCommandByEmail();
      console.log("recuByMailFinal",this.listCommandsByEmail );
     this.getCommandByEmail();
  }

  getCommandByUserId()
  {
    console.log("ijsdlfjsdlfj")
    this._ohhs.getCommandById(this.idCommand).subscribe(
      (commandRecu) =>
      {
        this.command = commandRecu;
        console.log("commandReçu",this.command);
      }
    )
  }

  getCommandByEmail()
  {
    var commandRecuF : Command[]=[];
    console.log("ijsdlfjsdlfj");
    this._ohhs.getCommandByEmail(this.emailUser).subscribe(
      (commandRecu) =>
      {
        this.listCommandsByEmail = commandRecu;
        
      }
    );
    console.log("commandReçuByMail",commandRecuF);
    return commandRecuF;
  }
  //listCommandsByEmail : Command[]=this.getCommandByEmail();
  
}

import { Component, OnInit } from '@angular/core';
import { Command } from 'src/app/models/command';
import { OrderService } from '../order.service';

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

  constructor(private _orderService: OrderService) { }

  ngOnInit(): void {
    this._orderService.getCommands().subscribe(
      (commands) =>
      {
        this.listCommands = commands;
      }
    )
    //this.listCommandsByEmail = this.getCommandByEmail();
     this.getCommandByEmail();
  }

  getCommandByUserId()
  {
    this._orderService.getCommandById(this.idCommand).subscribe(
      (commandRecu) =>
      {
        this.command = commandRecu;
      }
    )
  }

  getCommandByEmail()
  {
    var commandRecuF : Command[]=[];
    this._orderService.getCommandByEmail(this.emailUser).subscribe(
      (commandRecu) =>
      {
        this.listCommandsByEmail = commandRecu;
        
      }
    );
    return commandRecuF;
  }
  //listCommandsByEmail : Command[]=this.getCommandByEmail();
  
}

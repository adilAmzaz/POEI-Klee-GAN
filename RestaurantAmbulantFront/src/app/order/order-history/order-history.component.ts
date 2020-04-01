import { Component, OnInit } from '@angular/core';
import { Command } from 'src/app/models/command';
import { OrderService } from '../order.service';
import { LogInComponent } from 'src/app/user/log-in/log-in.component';
import { User, Individual } from 'src/app/models/user';

@Component({
  selector: 'app-order-history',
  templateUrl: './order-history.component.html',
  styleUrls: ['./order-history.component.css']
})
export class OrderHistoryComponent implements OnInit {

  emailUser : string = LogInComponent.getConnectedUser().email;
  idCommand : string = "";
  command : Command;
  listCommands : Command[]=[];
  listCommandsByEmail : Command[]=[];

  constructor(private _orderService: OrderService) { }

  user : User;
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
        console.log("hgjkhjkhjkhjkhjkh",this.listCommandsByEmail)
        
      }
    );
    return commandRecuF;
  }
  //listCommandsByEmail : Command[]=this.getCommandByEmail();
  isAdmin(): boolean
  {
    if (LogInComponent.getConnectedUser()!= null)
      {
        if ('adminRights' in LogInComponent.getConnectedUser()){
          this.user = LogInComponent.getConnectedUser();
          if((<Individual>this.user).adminRights== true)
            return true;
        }
        
          
      }
    else{
      return false;
    }
      
      
  }
}

import { Component, OnInit } from '@angular/core';
import { LogInComponent } from 'src/app/user/log-in/log-in.component';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/order/order.service';
import { Basket } from 'src/app/models/basket';
import { User, Individual } from 'src/app/models/user';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  user : User;
  constructor(
    private _router: Router,
    private _orderService: OrderService
  ) { }

  ngOnInit(): void {
  }

  displayAdminTools: boolean = false;

  isConnected(): boolean
  {
    console.log("admin",this.isAdmin)
    return LogInComponent.isConnected();
  }
  isAdmin(): boolean
  {
    return LogInComponent.isAdmin();
  }
  disconnect()
  {
    LogInComponent.disconnect();
    this._router.navigate(['home']);
  }

  toggleAdminTools()
  {
    this.displayAdminTools = !this.displayAdminTools;
  }

  hasBasket() {
    return Basket.hasBasket
  }

  createBasket() {
    this._orderService.createBasket(null)
  }

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

  routeMealTimeChange()
  {
    this._router.navigate(['ModifierHeuresRepas']);

  }
  routeAddProduct()
  {
    this._router.navigate(['products/add/']);

  }
}

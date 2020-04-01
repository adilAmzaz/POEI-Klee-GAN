import { Component, OnInit } from '@angular/core';
import { LogInComponent } from 'src/app/user/log-in/log-in.component';
import { Router } from '@angular/router';
import { OrderService } from 'src/app/order/order.service';
import { Basket } from 'src/app/models/basket';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(
    private _router: Router,
    private _orderService: OrderService
  ) { }

  ngOnInit(): void {
  }

  isConnected(): boolean
  {
    return LogInComponent.isConnected();
  }
  disconnect()
  {
    LogInComponent.disconnect();
    this._router.navigate(['home']);
  }

  hasBasket() {
    return Basket.hasBasket
  }

  createBasket() {
    Basket.create()
    this._orderService.createBasket()
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { GlobalConfig } from 'src/app/models/global-config';
import { Product } from 'src/app/models/product';
import { ProductService } from '../product.service';
import { OrderService } from 'src/app/order/order.service';
@Component({
  selector: 'app-products-slider',
  templateUrl: './products-slider.component.html',
  styleUrls: ['./products-slider.component.css']
})
export class ProductsSliderComponent implements OnInit {

  @Input() width : string
  @Input() height : string

  products : Product[] = []

  endPoint : string = GlobalConfig.serverUrl

  onSlideClicked(value: any){
    this._orderService.addToBasket(this.products.filter(product => product.productId == value.activeId)[0])
  }

  constructor(
    private _productService : ProductService,
    private _orderService : OrderService
  ) { }

  ngOnInit(): void {
    this._productService.getProductsBetween(0,3).subscribe((response) => {
      this.products = response
    })
  }

}

import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/models/product';
import { GlobalConfig } from 'src/app/models/global-config';
import { ProductService } from '../product.service';
import { Day } from 'src/app/models/day.enum';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products : Product[] = []
  days = Day

  endPoint : string = GlobalConfig.serverUrl
  
  constructor(
    private _productService : ProductService
  ) { }

  ngOnInit(): void {
    this._productService.getProducts().subscribe((response) => {
      this.products = response
    })
  }

}

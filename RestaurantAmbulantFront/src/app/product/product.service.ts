import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { GlobalConfig } from '../models/global-config';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
    private _http : HttpClient,
    private _router : Router
  ) { }

  getProducts() : Observable<Product[]> {
    return this._http.get<Product[]>(GlobalConfig.productEndPoint + "all")
  }

  addProduct(product: Product): Observable<Product>
  {
    return this._http.post<Product>(GlobalConfig.serverUrl+"addproduct/", product);
  }

  getProductsBetween(first: number, last: number) : Observable<Product[]> {
    return this._http.get<Product[]>(GlobalConfig.productEndPoint + first + "/" + last)
  }
}

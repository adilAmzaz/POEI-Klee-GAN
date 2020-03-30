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
}

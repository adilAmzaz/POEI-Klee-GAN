import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Product } from '../models/product';
import { GlobalConfig } from '../models/global-config';
import { Day } from '../models/day.enum';

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
    let formattedDays: string[] = []
    product.days.forEach(value =>
      {
        formattedDays.push(this.convertDay(value));
      })
    //return this._http.post<Product>(GlobalConfig.serverUrl+"addproduct/", product);
    return this._http.post<Product>(GlobalConfig.serverUrl+"addproduct/", {
      "productId" : product.productId,
      "label" : product.label,
      "imageRelativePath" : product.imageRelativePath,
      "composition" : product.composition,
      "price" : product.price,
      "effectivePrice" : product.effectivePrice,
      "stock" : product.stock,
      "count" : product.count,
      "meals" : product.meals,
      "days" : formattedDays
    }
    )
  }

  convertDay(day: Day)
  {
    if (day == Day.MONDAY)
      return "MONDAY";
    if (day == Day.TUESDAY)
      return "TUESDAY";
    if (day == Day.WEDNESDAY)
      return "WEDNESDAY";
    if (day == Day.THURSDAY)
      return "THURSDAY";
    if (day == Day.FRIDAY)
      return "FRIDAY";
    if (day == Day.SATURDAY)
      return "SATURDAY";
    if (day == Day.SUNDAY)
      return "SUNDAY";
  }
}

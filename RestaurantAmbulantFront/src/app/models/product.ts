import { Meal } from './meal'
import { Day } from './day.enum'

export class Product {
    productId : number
    label : string
    imageRelativePath : string
    composition : string
    price : number
    effectivePrice : number
    stock : number
    count : number
    meals : Meal[]
    days : Day[]
}

import { CommandLine } from './command-line';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { NgbTime } from '@ng-bootstrap/ng-bootstrap/timepicker/ngb-time';
import { Meal } from './meal';

export class Basket {
    public static hasBasket: boolean
    public static deliveryDay: NgbDate
    public static meal: Meal
    public static deliveryHour : string
    public static commandLines : CommandLine[]

    public static create() {
        Basket.hasBasket = true
        Basket.commandLines = []
    }

    public static delete() {
        Basket.hasBasket = false
        Basket.deliveryDay = undefined
        Basket.meal = undefined
        Basket.deliveryHour = undefined
        Basket.commandLines = undefined
    }
}

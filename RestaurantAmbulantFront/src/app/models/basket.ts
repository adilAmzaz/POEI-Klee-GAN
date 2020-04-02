import { CommandLine } from './command-line';
import { NgbDate } from '@ng-bootstrap/ng-bootstrap';
import { Meal } from './meal';
import { Product } from './product';

export class Basket {
    public static hasBasket: boolean
    public static deliveryDay: NgbDate
    public static meal: Meal
    public static deliveryHour : string
    public static commandLines : CommandLine[]
    public static effectivePrice : number

    public static create(product : Product) {
        Basket.hasBasket = true
        Basket.commandLines = []
        Basket.effectivePrice = 0
        if (product != null) {
            Basket.add(product)
        }
    }

    public static delete() {
        Basket.hasBasket = false
        Basket.deliveryDay = undefined
        Basket.meal = undefined
        Basket.deliveryHour = undefined
        Basket.commandLines = undefined
        Basket.effectivePrice = undefined
    }

    public static add(product : Product) {
        if (!this.hasBasket) {
            Basket.create(product)
            return
        }
        let alreadyInBasket : boolean = false
        Basket.commandLines.forEach(commandLine => {
            if (commandLine.product == product) {
                Basket.effectivePrice += commandLine.riseQuantity(1)
                alreadyInBasket = true
            }
        })
        if (!alreadyInBasket) {
            Basket.commandLines.push(new CommandLine(product, 1))
            Basket.effectivePrice += product.price
        }
    }

    public static riseQuantity(commandLine : CommandLine, toAdd : number) {
        if (commandLine.quantity + toAdd <= 0) {
            Basket.deleteLine(commandLine)
        }
        else {
            Basket.effectivePrice += commandLine.riseQuantity(toAdd)
        }
    }

    public static deleteLine(commandLine : CommandLine) {
        let index : number = Basket.commandLines.indexOf(commandLine)
        if (index != -1) {
            Basket.commandLines.splice(index, 1)
            Basket.effectivePrice -= commandLine.effectivePrice
        }
    }
}

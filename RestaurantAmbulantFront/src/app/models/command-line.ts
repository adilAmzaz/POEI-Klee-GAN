import { Product } from './product';

export class CommandLine {
    commandLineId: number;
    product: Product;
    quantity: number;
    effectivePrice: number;

    constructor(product: Product, quantity: number) {
        this.product = product
        this.quantity = quantity
        this.effectivePrice = quantity*product.price
    }

    riseQuantity(toAdd : number) : number {
        this.quantity += toAdd
        this.effectivePrice = this.quantity*this.product.price
        return toAdd*this.product.price
    }
}

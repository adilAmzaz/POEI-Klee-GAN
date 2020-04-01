import { User } from './user';
import { CommandLine } from './command-line';

export class Command {
    commandId: number;
    user: User;
    orderDate: Date;
    deliveryDate: Date;
    delivered: boolean;
    deliveredDate: Date;
    homeDelivery: boolean;
    address: string;
    zipecode: string;
    city: string;
    commandLines : CommandLine[] = [];
}

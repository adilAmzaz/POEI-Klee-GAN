export class User
{
    id: number;
    email: string;
    password: string;
    phone: string;
    address: string;
    zipcode: string;
    city: string;
}

export class Company extends User
{
    name: string;
}

export class Individual extends User
{
    lastName: string;
    firstName: string;
    female: boolean;
    birthDate: Date;
    adminRights: boolean;
}
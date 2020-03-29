export class User
{
    userId: number;
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

    // convertToBackUser(): BackUser
    // {
    //     let backUser: BackUser = new BackUser();
    //     backUser.userId = this.userId;
    //     backUser.email = this.email;
    //     backUser.password = this.password;
    //     backUser.phone = this.phone;
    //     backUser.address = this.address;
    //     backUser.zipcode = this.zipcode;
    //     backUser.city = this.city;
    //     backUser.name = this.name;
    //     return backUser;
    // }
}

export class Individual extends User
{
    lastName: string;
    firstName: string;
    female: boolean;
    birthDate: Date;
    adminRights: boolean;

    // convertToBackUser(): BackUser
    // {
    //     let backUser: BackUser = new BackUser();
    //     backUser.userId = this.userId;
    //     backUser.email = this.email;
    //     backUser.password = this.password;
    //     backUser.phone = this.phone;
    //     backUser.address = this.address;
    //     backUser.zipcode = this.zipcode;
    //     backUser.city = this.city;
    //     backUser.firstName = this.firstName;
    //     backUser.lastName = this.lastName;
    //     backUser.female = this.female;
    //     backUser.birthDate = this.birthDate;
    //     backUser.adminRights = this.adminRights;
    //     return backUser;
    // }
}

// export class BackUser
// {
//     userId: number;
//     email: string;
//     password: string;
//     phone?: string;
//     zipcode?: string;
//     city?: string;
//     name?: string;
//     address?: string;
//     lastName?: string;
//     firstName?: string;
//     female?: boolean;
//     adminRights?: boolean;
//     birthDate?: Date;

//     convertToUser(): User
//     {
//         if (this.female == undefined)
//         {
//             let user: Company = new Company();
//             user.userId = this.userId;
//             user.email = this.email;
//             user.password = this.password;
//             user.phone = this.phone;
//             user.address = this.address;
//             user.zipcode = this.zipcode;
//             user.city = this.city;
//             user.name = this.name;
//             return user;
//         }
//         else
//         {
//             let user: Individual = new Individual();
//             user.userId = this.userId;
//             user.email = this.email;
//             user.password = this.password;
//             user.phone = this.phone;
//             user.address = this.address;
//             user.zipcode = this.zipcode;
//             user.city = this.city;
//             user.firstName = this.firstName;
//             user.lastName = this.lastName;
//             user.female = this.female;
//             user.birthDate = this.birthDate;
//             user.adminRights = this.adminRights;
//             return user;
//         }
//     }
// }
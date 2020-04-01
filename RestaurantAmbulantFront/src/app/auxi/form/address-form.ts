
import { FormGroup, FormControl, Validators } from"@angular/forms"; 

export class AddressForm extends FormGroup
{
    constructor(address: String, zipCode: String, city: String)
    {
        super(
            {
                address: new FormControl(address),
                zipCode: new FormControl(zipCode),
                city: new FormControl(city)
            });
    }
}

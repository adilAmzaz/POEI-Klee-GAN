
import { FormGroup, FormControl, Validators } from"@angular/forms"; 

export class AddressForm extends FormGroup
{
    constructor()
    {
        super(
            {
                address: new FormControl(""),
                zipCode: new FormControl(""),
                city: new FormControl("")
            });
    }
}

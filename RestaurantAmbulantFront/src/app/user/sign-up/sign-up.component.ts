import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, ValidatorFn } from"@angular/forms"; 
import { AddressForm } from 'src/app/auxi/form/address-form';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor()
  {
    this.userForm.controls['isCompany'].valueChanges.subscribe(
      (state: boolean) =>
      {
        if (state)
        {
          this.userForm.controls['companyName'].enable();
          this.userForm.controls['firstName'].disable();
          this.userForm.controls['lastName'].disable();
          this.userForm.controls['birthDate'].disable();
          this.userForm.controls['isFemale'].disable();
        }
        else
        {
          this.userForm.controls['companyName'].disable();
          this.userForm.controls['firstName'].enable();
          this.userForm.controls['lastName'].enable();
          this.userForm.controls['birthDate'].enable();
          this.userForm.controls['isFemale'].enable();
        }
      });
    this.userForm.controls['isCompany'].setValue(false);
    this.userForm.controls['isFemale'].setValue(true);
    this.userForm.controls['birthDate'].setValue(Date.now());
    
    //this.userForm.valueChanges.subscribe()
  }
  ngOnInit(): void {
  }
  
  userForm = new FormGroup(
    {
      email: new FormControl(null, [Validators.required,
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      password: new FormControl(null, [Validators.required]),
      isCompany: new FormControl(null),
      companyName: new FormControl(""),
      firstName: new FormControl(""),
      lastName: new FormControl(""),
      addressForm: new AddressForm(),
      telephone: new FormControl(""),
      birthDate: new FormControl(null),
      isFemale: new FormControl(null, [Validators.required])
      
    }
  )
  _signInAttempted: boolean = false;

  signIn(): void
  {
    this._signInAttempted = true;
    if (!this.userForm.invalid)
      console.log("Sign-in called.");
  }

  isCompany(): boolean
  {
    return this.userForm.controls['isCompany'].value;
  }

  getErrorMessage(form: string): string
  {
    const control = this.userForm.controls[form];
    if ((control.touched || this._signInAttempted))
    {

      //const mailError = control.getError('validatorMail', [form]);
      //if (mailError != null)
      if (control.hasError('pattern'))
      {
        return "Invalid Format";
      }
      if (control.hasError('required'))
        return "This field is required";
    }
    return "";
    
  }
  // checkFormGroup(formGroup: FormGroup, errorCode: string): boolean
  // {
  //   let hasError: boolean = true;
  //   Object.keys(formGroup.controls).forEach(
  //     (key) =>
  //     {
  //       console.log(key, ': ', !formGroup.controls[key].hasError(errorCode))
  //       hasError = hasError || !formGroup.controls[key].hasError(errorCode);
  //     }
  //   );
  //   return hasError;
  // }
}


// export const validatorMail: ValidatorFn = (control) =>
// {
//   if (control == null || control.value == null)
//     return null;
//   let mailRegex = new RegExp("^([a-zA-Z0-9])+([a-zA-Z0-9._%+-])+@([a-zA-Z0-9_.-])+\.(([a-zA-Z]){2,6})$");
//   if (mailRegex.test(control.value))// || !(<string>control.value).includes("@"))
//   {
//     console.log("mail error");
//     return {
//       'validatorMail': {
//         reason: "Invalid e-mail format.",
//         value: control.value
//       }
//     }
//   }
//   return null;
// }

import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from"@angular/forms"; 
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
    
    //this.userForm.valueChanges.subscribe()
  }
  ngOnInit(): void {
  }
  
  userForm = new FormGroup(
    {
      email: new FormControl(null, [Validators.required]),
      password: new FormControl(null, [Validators.required]),
      isCompany: new FormControl(null, [Validators.required]),
      companyName: new FormControl(),
      firstName: new FormControl(),
      lastName: new FormControl(),
      addressForm: new AddressForm(),
      telephone: new FormControl(),
      birthDate: new FormControl(),
      isFemale: new FormControl(true, [Validators.required])
      
    }
  )
  _signInAttempted: boolean = false;

  signIn(): void
  {
    this._signInAttempted = true;
    if (this.userForm.valid)
      console.log("Sign-in called.")
  }

  isCompany(): boolean
  {
    return this.userForm.controls['isCompany'].value;
  }

  getErrorMessage(form: string): string
  {
    const control = this.userForm.controls[form];
    if ((control.touched || this._signInAttempted) && control.hasError('required'))
    {
      return "This field is required";
    }
    
  }
}

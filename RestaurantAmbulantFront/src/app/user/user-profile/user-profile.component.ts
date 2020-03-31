import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators } from"@angular/forms"; 
import { AddressForm } from 'src/app/auxi/form/address-form';
import { UserHttpService } from '../user-http.service';
import { User, Company, Individual } from 'src/app/models/user';
import { ActivatedRoute, Params, ParamMap } from '@angular/router';
import { LogInComponent } from '../log-in/log-in.component';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(
    private _userHttpService: UserHttpService,
    private _activatedRoute: ActivatedRoute)
  {
    // this._activatedRoute.paramMap.subscribe(
    //   (params) => {this.queryParams = params;}
    // )
    // this._userHttpService.getUserById(
    //   Number.parseInt(sessionStorage.getItem("userId")))
    //     .subscribe((response) => {this.user = response;} );
    this.user = LogInComponent.getConnectedUser();
  }

  ngOnInit(): void
  {
    // if (this.user != undefined && this.user != null)
    //   this._userHttpService.getUserById(
    //     Number.parseInt(this.queryParams.get("user")))
    //       .subscribe((response) => {this.user = response;} );
    // if (this.user != undefined && this.user != null)
    //console.log(this.user);
    
    this.idForm.controls['email'].setValue(this.user.email);
    this.infoForm.controls['phone'].setValue(this.user.phone);
    (<FormGroup>this.infoForm.controls['addressForm'])
      .controls['address'].setValue(this.user.address);
    (<FormGroup>this.infoForm.controls['addressForm'])
      .controls['zipCode'].setValue(this.user.zipcode);
    (<FormGroup>this.infoForm.controls['addressForm'])
      .controls['city'].setValue(this.user.city);
    if (this.isCompany())
    {
      let company = <Company>this.user;

      this.infoForm.controls['companyName'].enable();
      this.infoForm.controls['firstName'].disable();
      this.infoForm.controls['lastName'].disable();
      this.infoForm.controls['birthDate'].disable();
      this.infoForm.controls['isFemale'].disable();
      this.infoForm.controls['adminRights'].disable();

      this.infoForm.controls['companyName'].setValue(company.name);
    }
    else
    {
      let individual = <Individual>this.user;

      this.infoForm.controls['companyName'].disable();
      this.infoForm.controls['firstName'].enable();
      this.infoForm.controls['lastName'].enable();
      this.infoForm.controls['birthDate'].enable();
      this.infoForm.controls['isFemale'].enable();
      
      this.infoForm.controls['isFemale'].setValue(individual.female);
      this.infoForm.controls['firstName'].setValue(individual.firstName);
      this.infoForm.controls['lastName'].setValue(individual.lastName);
      this.infoForm.controls['birthDate'].setValue(
        new Date(individual.birthDate).toISOString().substring(0, 10));
      this.infoForm.controls['adminRights'].setValue(individual.adminRights);
      if (individual.adminRights)
        this.infoForm.controls['adminRights'].enable();
      else
        this.infoForm.controls['adminRights'].disable();
      
    }
  }

  @Input() user: User;
  queryParams: ParamMap;
  idForm: FormGroup = new FormGroup(
    {
      email: new FormControl(null, [Validators.required,
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      newPassword: new FormControl(null),
      password: new FormControl(null, [Validators.required])
    }
  )
  infoForm: FormGroup = new FormGroup(
    {
      companyName: new FormControl(),
      firstName: new FormControl(),
      lastName: new FormControl(),
      addressForm: new AddressForm(null, null, null),
      phone: new FormControl(),
      birthDate: new FormControl(),
      isFemale: new FormControl(null, [Validators.required]),
      adminRights: new FormControl()
    }
  )
  idValidationAttempted: boolean = false;
  infoValidationAttempted: boolean = false;

  updateIdentifiers()
  {
    this.idValidationAttempted = true;
    if (!this.idForm.invalid)
    {
      this._userHttpService.getUserByEMail(this.idForm.controls['email'].value)
        .subscribe((response) => { this.user = response });
      if (this.user != null)
      {
        if (this.user.password == this.idForm.controls['password'].value)
        {
          this.user.email = this.idForm.controls['email'].value;
          let pw = this.idForm.controls['newPassword'].value;
          if (pw != null && pw != "")
            this.user.password = pw;
          if (this.isCompany())
          {
            this._userHttpService.updateCompany(<Company>this.user)
              .subscribe((response) =>
              {
                sessionStorage.setItem("user", JSON.stringify(this.user));
                this.user = response;
              });
          }
          else
          {
            this._userHttpService.updateIndividual(<Individual>this.user)
              .subscribe((response) =>
              {
                sessionStorage.setItem("user", JSON.stringify(this.user));
                this.user = response;
              });
          }
          console.log("Updated user Identifiers.");
        }
        else
          console.log("Wrong password.");
      }
      
    }
  }
  updateInfo()
  {
    this.infoValidationAttempted = true;
    if (!this.infoForm.invalid)
    {
      if (this.isCompany())
      {
        this.user.phone = this.infoForm.controls['phone'].value;
        this.user.address = (<FormGroup>this.infoForm.controls['addressForm']).controls['address'].value;
        this.user.zipcode = (<FormGroup>this.infoForm.controls['addressForm']).controls['zipCode'].value;
        this.user.city = (<FormGroup>this.infoForm.controls['addressForm']).controls['city'].value;
        (<Company>this.user).name = this.infoForm.controls['companyName'].value;
      }
      else
      {
        this.user.phone = this.infoForm.controls['phone'].value;
        this.user.address = (<FormGroup>this.infoForm.controls['addressForm']).controls['address'].value;
        this.user.zipcode = (<FormGroup>this.infoForm.controls['addressForm']).controls['zipCode'].value;
        this.user.city = (<FormGroup>this.infoForm.controls['addressForm']).controls['city'].value;
        (<Individual>this.user).firstName = this.infoForm.controls['firstName'].value;
        (<Individual>this.user).lastName = this.infoForm.controls['lastName'].value;
        (<Individual>this.user).female = this.infoForm.controls['isFemale'].value;
        (<Individual>this.user).birthDate = <Date>this.infoForm.controls['birthDate'].value;
      }
      sessionStorage.setItem("user", JSON.stringify(this.user));
      if (this.isCompany())
      {
        this._userHttpService.updateCompany(<Company>this.user)
          .subscribe((response) =>
          {
            sessionStorage.setItem("user", JSON.stringify(this.user));
            this.user = response;
          });
      }
      else
      {
        this._userHttpService.updateIndividual(<Individual>this.user)
          .subscribe((response) =>
          {
            sessionStorage.setItem("user", JSON.stringify(this.user));
            this.user = response;
          });
      }
      console.log("Updated user info.");
    }
  }

  getIdErrorMessage(form: string): string
  {
    return this.getErrorMessage(form, this.idForm, this.idValidationAttempted);
  }
  getInfoErrorMessage(form: string): string
  {
    return this.getErrorMessage(form, this.infoForm, this.infoValidationAttempted);
  }

  getErrorMessage(form: string, formGroup: FormGroup, validationAttempted: boolean): string
  {
    let control = formGroup.controls[form];
    if ((control.touched || validationAttempted))
    {
      if (control.hasError('pattern'))
      {
        return "Invalid Format";
      }
      if (control.hasError('required'))
        return "This field is required";
    }
    return "";
    
  }

  isCompany(): boolean
  {
    return !('female' in this.user);
  }
  hasAdminRights(): boolean
  {
    return (!this.isCompany() && (<Individual>this.user).adminRights);
  }
}

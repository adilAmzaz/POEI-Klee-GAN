import { Component, OnInit } from '@angular/core';
import { UserHttpService } from '../user-http.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from 'src/app/models/user';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-in',
  templateUrl: './log-in.component.html',
  styleUrls: ['./log-in.component.css']
})
export class LogInComponent implements OnInit {

  constructor(private _userHttpService: UserHttpService,
              private _router: Router)
  {

  }

  ngOnInit(): void {
  }

  loginForm = new FormGroup(
    {
      email: new FormControl("", [Validators.required,
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      password: new FormControl("", [Validators.required])
    }
  )
  loginAttempted: boolean = false;
  isLoggedIn = false;
  user: User;

  login(): void
  {
    this.loginAttempted = true;
    if (!this.loginForm.invalid)
    {
      this._userHttpService.getUserByEMail(this.loginForm.controls['email'].value)
        .toPromise().then((response) =>
          {
            this.user = response;
            if (this.user != null)
            {
              if (this.user.password == this.loginForm.controls['password'].value)
              {
                sessionStorage.setItem("user", JSON.stringify(this.user));
                this.isLoggedIn = true;
                this._router.navigate(['home']);
              }
            }
          }
        )
      
    }
  }

  getErrorMessage(form: string): string
  {
    const control = this.loginForm.controls[form];
    if ((control.touched || this.loginAttempted))
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

  static isConnected(): boolean
  {
    if (sessionStorage.getItem("user") != null)
      return true;
    else
      return false;
  }
  static disconnect()
  {
    sessionStorage.removeItem("user");
  }
  static getConnectedUser(): User
  {
    return <User>JSON.parse(sessionStorage.getItem("user"))
  }

}

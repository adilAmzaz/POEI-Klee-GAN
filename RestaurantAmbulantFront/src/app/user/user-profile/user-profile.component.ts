import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormControl, Validators } from"@angular/forms"; 
import { AddressForm } from 'src/app/auxi/form/address-form';
import { UserHttpService } from '../user-http.service';
import { User, Company, Individual } from 'src/app/models/user';
import { ActivatedRoute, Params, ParamMap } from '@angular/router';

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
    this._activatedRoute.paramMap.subscribe(
      (params) => {this.queryParams = params;}
    )
    this._userHttpService.getUserById(
      Number.parseInt(this.queryParams.get("user")))
      .subscribe((response) => {this.user = response;} );
    this.indentifiers = new FormGroup(
      {
        email: new FormControl()

      }
    )
  }

  ngOnInit(): void {
  }

  @Input() user: User;
  queryParams: ParamMap;
  indentifiers: FormGroup;
}

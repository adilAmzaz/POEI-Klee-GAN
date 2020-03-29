import { Component, OnInit } from '@angular/core';
import { UserHttpService } from '../user-http.service';
import { User } from 'src/app/models/user';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  constructor(private _userService: UserHttpService)
  { }

  ngOnInit(): void {
    this._userService.getUsers().subscribe(
      (users) =>
      {
        this.userList = users;
      }
    )
  }

  userList: User[] = [];

}

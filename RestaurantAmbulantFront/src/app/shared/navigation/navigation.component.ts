import { Component, OnInit } from '@angular/core';
import { LogInComponent } from 'src/app/user/log-in/log-in.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  constructor(private _router: Router) { }
  ngOnInit(): void {
  }

  isConnected(): boolean
  {
    return LogInComponent.isConnected();
  }
  disconnect()
  {
    LogInComponent.disconnect();
    this._router.navigate(['home']);
  }

}

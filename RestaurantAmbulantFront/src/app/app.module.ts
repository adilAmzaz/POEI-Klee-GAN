import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NavigationComponent } from './shared/navigation/navigation.component';
import { HomeComponent } from './shared/home/home.component';
import { LoginComponent } from './user/login/login.component';
import { SignupComponent } from './user/signup/signup.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { LogInComponent } from './user/log-in/log-in.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavigationComponent,
    HomeComponent,
    LoginComponent,
    SignupComponent,
    SignUpComponent,
    LogInComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

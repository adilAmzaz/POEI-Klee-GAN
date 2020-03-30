import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { NavigationComponent } from './shared/navigation/navigation.component';
import { HomeComponent } from './shared/home/home.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { LogInComponent } from './user/log-in/log-in.component';
import { UserListComponent } from './user/user-list/user-list.component';

import { ActualitiesListComponent } from './actuality/actualities-list/actualities-list.component';
import { ActualityComponent } from './actuality/actuality/actuality.component';
import { ActualityEditComponent } from './actuality/actuality-edit/actuality-edit.component';
import { ActualitiesManagementComponent } from './actuality/actualities-management/actualities-management.component';
import { ActualitiesSliderComponent } from './actuality/actualities-slider/actualities-slider.component';
import { ProductsListComponent } from './product/products-list/products-list.component';

@NgModule({
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    NavigationComponent,
    HomeComponent,
    SignUpComponent,
    LogInComponent,
    UserListComponent,
    LogInComponent,
    SignUpComponent,
    ActualitiesListComponent,
    ActualityComponent,
    ActualityEditComponent,
    ActualitiesManagementComponent,
    ActualitiesSliderComponent,
    ProductsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

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
import { OrderHistoryComponent } from './order/order-history/order-history.component';
import { FormsModule } from '@angular/forms';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { ProductsListComponent } from './product/products-list/products-list.component';

import { registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
import { MealsManagementComponent } from './meal/meals-management/meals-management.component';
import { MealsListComponent } from './meal/meals-list/meals-list.component';
import {TimelineComponent} from 'src/app/timeline/timeline.component';
import { ModifyHoursOfMealsComponent } from './modify-hours-of-meals/modify-hours-of-meals.component';
import { AddProductComponent } from './product/add-product/add-product.component';
import { ProductsSliderComponent } from './product/products-slider/products-slider.component';
registerLocaleData(localeFr, 'fr');

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
    OrderHistoryComponent,
    UserProfileComponent,
    ProductsListComponent,
    MealsManagementComponent,
    MealsListComponent,
    TimelineComponent,
    ModifyHoursOfMealsComponent,
    AddProductComponent,
    ProductsSliderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

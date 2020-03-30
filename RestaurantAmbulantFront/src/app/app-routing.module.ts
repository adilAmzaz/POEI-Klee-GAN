import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './shared/home/home.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { LogInComponent } from './user/log-in/log-in.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';
import { ActualitiesListComponent } from './actuality/actualities-list/actualities-list.component';
import { ActualityComponent } from './actuality/actuality/actuality.component';
import { UserProfileComponent } from './user/user-profile/user-profile.component';
import { ProductsListComponent } from './product/products-list/products-list.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'log-in', component: LogInComponent},
  {path: 'sign-up', component : SignUpComponent},
  {path: 'profile', component : UserProfileComponent},
  {path: 'actualities', component : ActualitiesListComponent},
  {path: 'actualities/actuality/:id', component : ActualityComponent},
  {path: 'products', component : ProductsListComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

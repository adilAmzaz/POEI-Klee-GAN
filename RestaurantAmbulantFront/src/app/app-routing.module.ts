import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './shared/home/home.component';
import { PageNotFoundComponent } from './shared/page-not-found/page-not-found.component';
import { LogInComponent } from './user/log-in/log-in.component';
import { SignUpComponent } from './user/sign-up/sign-up.component';


const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'log-in', component: LogInComponent},
  {path: 'sign-up', component : SignUpComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

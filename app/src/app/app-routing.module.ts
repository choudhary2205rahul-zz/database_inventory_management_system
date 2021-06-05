import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {ErrorComponent} from "./components/error/error.component";
import {ListInventoryComponent} from "./components/list-inventory/list-inventory.component";
import {LogoutComponent} from "./components/logout/logout.component";

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'home/:name', component: HomeComponent},
  {path: 'list-inventory', component: ListInventoryComponent},
  {path: '**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

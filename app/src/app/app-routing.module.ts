import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {LoginComponent} from "./components/login/login.component";
import {ErrorComponent} from "./components/error/error.component";
import {ListInventoryComponent} from "./components/list-inventory/list-inventory.component";
import {LogoutComponent} from "./components/logout/logout.component";
import {RouteGuardService} from "./service/authentication/route-guard.service";
import {InventoryComponent} from "./components/inventory/inventory.component";
import {RegisterComponent} from "./components/register/register.component";

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home/:name', component: HomeComponent, canActivate: [RouteGuardService]},
  {path: 'register', component: RegisterComponent},
  {path: 'list-inventory', component: ListInventoryComponent, canActivate: [RouteGuardService]},
  {path: 'inventory/:id', component: InventoryComponent, canActivate: [RouteGuardService]},
  {path: 'logout', component: LogoutComponent},
  {path: '**', component: ErrorComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}

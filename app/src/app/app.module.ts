import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/login/login.component';
import {FormsModule} from "@angular/forms";
import {HomeComponent} from './components/home/home.component';
import {ErrorComponent} from './components/error/error.component';
import {ListInventoryComponent} from './components/list-inventory/list-inventory.component';
import {HeaderComponent} from './components/header/header.component';
import {FooterComponent} from './components/footer/footer.component';
import {LogoutComponent} from './components/logout/logout.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import { InventoryComponent } from './components/inventory/inventory.component';
import {HttpInterceptorService} from "./service/authentication/http-interceptor.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    ErrorComponent,
    ListInventoryComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    InventoryComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorService, multi: true}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

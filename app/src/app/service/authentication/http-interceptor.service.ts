import { Injectable } from '@angular/core';
import {HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {AuthenticationService} from "./authentication.service";

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor(private authenticationService: AuthenticationService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
   let authenticatedToken = this.authenticationService.getAuthenticatedToken();
   let authenticatedUser = this.authenticationService.getAuthenticatedUser();

   if (authenticatedToken && authenticatedUser) {
     req = req.clone({
       setHeaders: {
         Authorization: authenticatedToken
       }
     });
   }
    return next.handle(req);
  }
}

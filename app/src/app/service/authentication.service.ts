import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username: any,password: any) {
    if (username === 'rahul' && password === 'dummy') {
      sessionStorage.setItem('authenticated-user', username);
      return true;
    } else {
      return false;
    }
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticated-user');
    return !(user === null);
  }

  logout() {
    sessionStorage.removeItem('authenticated-user');
  }
}

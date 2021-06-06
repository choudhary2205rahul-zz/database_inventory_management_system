import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {map} from "rxjs/operators";
import {API_URL} from "../../app.constant";
import jwt_decode from 'jwt-decode';

export const TOKEN = 'token';
export const AUTHENTICATED_USER = 'authenticated-user';
export const ROLE = 'role';

export class Authentication {
  constructor(public authenticated: string) {}
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticate(username: any,password: any) {

    return this.httpClient.post<any>(`${API_URL}/authenticate`,{username, password}).pipe(
        map(data => {
          sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
          console.log(this.getDecodedAccessToken(data.token));
          let decodedAccessToken = this.getDecodedAccessToken(data.token);
          sessionStorage.setItem(AUTHENTICATED_USER, decodedAccessToken.sub);
          sessionStorage.setItem(ROLE, decodedAccessToken.roles[0].authority);
          return data;
        })
      );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken() {
    if (this.getAuthenticatedUser()) {
      return sessionStorage.getItem(TOKEN);
    }

  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return !(user === null);
  }

  logout() {
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
    sessionStorage.removeItem(ROLE);
  }

  getUsername(): string {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    if (user) { return user };
    return '';
  }

  getDecodedAccessToken(token: string): any {
    try{
      return jwt_decode(token);
    }
    catch(Error){
      return null;
    }
  }
}

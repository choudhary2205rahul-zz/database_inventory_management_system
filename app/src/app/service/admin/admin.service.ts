import { Injectable } from '@angular/core';
import {ROLE} from "../authentication/authentication.service";

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor() { }

  isAdmin() {
    let item = sessionStorage.getItem(ROLE);
    return item != null && item == 'ROLE_ADMIN';
  }
}

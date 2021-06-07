import {Injectable} from '@angular/core';
import {API_URL} from "../../../app.constant";
import {User} from "../../../model/user";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }

  getAllUsers() {
    return this.httpClient.get<User[]>(`${API_URL}/users`);
  }
}

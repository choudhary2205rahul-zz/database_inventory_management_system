import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {API_URL} from "../../../app.constant";

export class Message {
  constructor(public message: string){}
}

@Injectable({
  providedIn: 'root'
})
export class HomeApiService {

  constructor(private httpClient: HttpClient) { }

  getHomeMessageApi(name: string) {
    return this.httpClient.get<Message>(`${API_URL}/home/${name}`,);
  }


}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

export class Message {
  constructor(public message: string){}
}

@Injectable({
  providedIn: 'root'
})
export class HomeApiService {

  constructor(private httpClient: HttpClient) { }

  getHomeMessageApi(name: string) {
    return this.httpClient.get<Message>(`http://localhost:8080/inventory-management/home/${name}`);
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Inventory} from "../../model/inventory";

@Injectable({
  providedIn: 'root'
})
export class InventoryApiService {

  constructor(private httpClient: HttpClient) { }

  getAllInventory() {
    return this.httpClient.get<Inventory[]>(`http://localhost:8080/inventory-management/inventory`);
  }
}

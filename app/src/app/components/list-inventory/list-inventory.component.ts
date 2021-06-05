import {Component, OnInit} from '@angular/core';
import {Inventory} from "../../model/inventory";
import {InventoryApiService} from "../../service/data/inventory-api.service";

@Component({
  selector: 'app-list-inventory',
  templateUrl: './list-inventory.component.html',
  styleUrls: ['./list-inventory.component.css']
})
export class ListInventoryComponent implements OnInit {
  inventories: Inventory[] = [];
  message: string = '';

  constructor(private inventoryService: InventoryApiService) {
  }

  ngOnInit(): void {
    this.inventoryService.getAllInventory().subscribe(response => {
      this.inventories = response;
    }, error => {
        this.message = error.error.message;
      }

    )
  }

}

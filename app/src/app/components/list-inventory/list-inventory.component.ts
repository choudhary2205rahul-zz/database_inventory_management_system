import {Component, OnInit} from '@angular/core';
import {Inventory} from "../../model/inventory";

@Component({
  selector: 'app-list-inventory',
  templateUrl: './list-inventory.component.html',
  styleUrls: ['./list-inventory.component.css']
})
export class ListInventoryComponent implements OnInit {
  inventories = [
    new Inventory(1, 'Airtel Project', 'Oracle', 'airtel', 'air2120', 1521),
    new Inventory(2, 'Vodafone Project', 'MySQL', 'vodafone', 'voda3212', 3306)
  ]

  constructor() {
  }

  ngOnInit(): void {
  }

}

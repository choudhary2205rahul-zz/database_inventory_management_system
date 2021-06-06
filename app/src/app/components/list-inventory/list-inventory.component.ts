import {Component, OnInit} from '@angular/core';
import {Inventory} from "../../model/inventory";
import {InventoryApiService} from "../../service/data/inventory-api/inventory-api.service";
import {Router} from "@angular/router";
import {Project} from "../../model/project";
import {ROLE} from "../../service/authentication/authentication.service";
import {AdminService} from "../../service/admin/admin.service";

@Component({
  selector: 'app-list-inventory',
  templateUrl: './list-inventory.component.html',
  styleUrls: ['./list-inventory.component.css']
})
export class ListInventoryComponent implements OnInit {
  inventories: Project[] = [];
  message: string = '';
  checkConnectivity: boolean = false;
  projectName: string = '';

  constructor(private inventoryService: InventoryApiService, private router: Router, public adminService:AdminService) {
  }

  ngOnInit(): void {
    this.refreshInventory();
  }

  refreshInventory() {
    this.inventoryService.getAllInventory().subscribe(response => {
        this.inventories = response;
      }, error => {
        this.message = error.error.message;
      }
    )
  }

  handleDelete(projectId: number) {
    this.inventoryService.deleteInventory(projectId).subscribe(response => {

      // Show Delete Message
      this.message = `Delete of Connection ${projectId} is Successful!`;

      // Refresh Inventory List
      this.refreshInventory();

      }, error => {
        this.message = error.error.message;
      }
    )
  }

  handleUpdate(projectId: number) {
    this.router.navigate(['inventory', projectId])
  }

  handleTestConnectivity(project: Project) {
    this.inventoryService.testConnectivity(project).subscribe(response => {
        this.checkConnectivity = response;
        this.projectName = project.description;
    });
  }

  addNewConnection() {
    this.router.navigate(['inventory', -1])
  }

}

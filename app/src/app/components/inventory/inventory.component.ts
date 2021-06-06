import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {InventoryApiService} from "../../service/data/inventory-api/inventory-api.service";
import {Project} from "../../model/project";

@Component({
  selector: 'app-inventory',
  templateUrl: './inventory.component.html',
  styleUrls: ['./inventory.component.css']
})
export class InventoryComponent implements OnInit {

  id: number = 0;
  project: Project;
  newPassword: string = '';
  confirmPassword: string = '';

  constructor(private route: ActivatedRoute, private inventoryService: InventoryApiService, private router: Router) {
    this.project = {projectId: 0, description: '', inventory: {id: 0, hostname:'', password:'', username: '', dbName:'', port: '', dbType:''}}
  }

  ngOnInit(): void {
    this.id = +this.route.snapshot.params['id'];
    if (this.id !== -1) {
      this.fillForm();
    }
  }

  handleSaveOrUpdate(project: Project) {

    if (this.id === -1) {
      // Create
      project.inventory.password = this.newPassword;
      this.inventoryService.addNewConnection(project).subscribe(response => {
        this.router.navigate(['list-inventory']);
      })
    } else {
      // Update
      if (this.newPassword !== '' && this.confirmPassword != '' && this.newPassword === this.confirmPassword) project.inventory.password = this.newPassword;
      this.inventoryService.updateInventory(project).subscribe(response => {
        this.router.navigate(['list-inventory']);
      })
    }

  }

  private fillForm() {
    this.inventoryService.findInventoryById(this.id).subscribe(response => {
        this.project = response;
      }
    )
  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Project} from "../../../model/project";
import {API_URL} from "../../../app.constant";

@Injectable({
  providedIn: 'root'
})
export class InventoryApiService {

  constructor(private httpClient: HttpClient) { }

  getAllInventory() {
    return this.httpClient.get<Project[]>(`${API_URL}/projects`);
  }

  deleteInventory(projectId: number) {
    return this.httpClient.delete(`${API_URL}/projects/${projectId}`);
  }

  updateInventory(project:Project) {
    return this.httpClient.post<Project>(`${API_URL}/projects`,project);
  }

  findInventoryById(projectId: number) {
    return this.httpClient.get<Project>(`${API_URL}/projects/admin/${projectId}`);
  }

  testConnectivity(project: Project) {
    return this.httpClient.post<boolean>(`${API_URL}/projects/connectivity`, project);
  }

  addNewConnection(project: Project) {
    return this.httpClient.post<Project>(`${API_URL}/projects`,project);
  }
}

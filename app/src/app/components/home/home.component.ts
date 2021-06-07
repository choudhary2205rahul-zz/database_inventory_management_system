import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {HomeApiService} from "../../service/data/home-api/home-api.service";
import {AdminService} from "../../service/admin/admin.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  name = '';
  message = '';

  constructor(private route: ActivatedRoute, private homeService: HomeApiService, private router: Router, public adminService: AdminService) {
  }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
    this.handleHomeMessageApiCall();
  }

  handleHomeMessageApiCall() {
    this.homeService.getHomeMessageApi(this.name).subscribe(response => {
        this.message = response.message;
      }, error => {
      console.log(error);
      this.message = error.error.message;
      }
    );
  }

  navigateToUsers() {
    this.router.navigate(['list-users']);
  }

  navigateToDB() {
    this.router.navigate(['list-inventory']);
  }

  isAdmin() {

  }
}

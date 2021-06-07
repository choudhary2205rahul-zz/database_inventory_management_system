import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/data/users/user.service";
import {User} from "../../model/user";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[];
  message: string;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.refreshUsers();
  }

  private refreshUsers() {
    this.userService.getAllUsers().subscribe(response => {
        this.users = response;
      }, error => {
        this.message = error.error.message;
      }
    )
  }
}

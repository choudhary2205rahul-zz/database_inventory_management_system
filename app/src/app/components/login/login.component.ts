import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username = '';
  password = '';
  errorMessage = 'Invalid Credentials!'
  invalidLogin = false;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  handleLogin() {
    if (this.username === 'rahul' && this.password === 'dummy') {
      this.invalidLogin = false;

      // Route to Home Screen on Successful Login
      this.router.navigate(['/home', this.username]);
    } else {
      this.invalidLogin = true;
    }
  }
}

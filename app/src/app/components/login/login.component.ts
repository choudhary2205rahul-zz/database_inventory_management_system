import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../service/authentication/authentication.service";

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

  constructor(private router: Router,private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  handleLogin() {

    this.authService.authenticate(this.username, this.password).subscribe(response => {

      // Route to Home Screen on Successful Login
      this.router.navigate(['/home', this.username]);

      this.invalidLogin = false;
    }, error => {
      this.invalidLogin = true;
    })
  }
}

import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {AuthenticationService} from "../../service/authentication/authentication.service";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  username = '';
  password = '';

  constructor(private router: Router,private authService: AuthenticationService) { }

  ngOnInit(): void {
  }

  handleRegister() {
    this.authService.register(this.username, this.password).subscribe(response => {

      // Route to Home Screen on Successful Login
      this.router.navigate(['/login']);

    }, error => {
      console.log(error.error.message);
    })
  }
}

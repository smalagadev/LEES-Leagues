import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') !== null){
      this.router.navigate(['/home']);
    }
  }

  logged: boolean = JSON.parse(sessionStorage.getItem('logged'));// Delete when API is connected

  if(logged){
      this.router.navigate(['/home']);
  }

  // true = Login, false = Register
  loginToggle: boolean = true;

  toggleForm():void{
    this.loginToggle = !this.loginToggle;
  }
}

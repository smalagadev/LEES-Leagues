import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  currentUser: any;

  constructor(private router: Router) { }

  Register(){

  }

  ngOnInit() {
  }

  username : string;
  password : string;

  sendLogin() {
    this.currentUser.login(this.username, this.password).subscribe(
      (response: "") => {
        sessionStorage.setItem('currentUser', JSON.stringify(response));
        console.log(response);
        this.router.navigate(['/']);
      }
    )
  }
}

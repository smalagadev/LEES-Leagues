import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {MatDialog} from '@angular/material';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }

  username : string;
  password : string;

  login() : void{

  if(this.username == 'admin'&& this.password == 'password'){
    this.router.navigate(["user"]);
  }else{
    alert("credentials are invalid");
  }
}
}

import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material'

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }

  username : string;
  password : string;

  ngOnInit() {

  }
  login() : void{

  
  if(this.username == 'admin'&& this.password == 'password'){
    this.router.navigate(["user"]);
  }else{
    alert("credentials are invalid");
  }
}
}

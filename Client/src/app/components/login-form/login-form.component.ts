import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
<<<<<<< HEAD
=======
import { User } from './../../models/user';
>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a



@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
<<<<<<< HEAD
  currentUser: any;

  constructor(private router: Router) { }

  Register(){

  }
=======
  currentUser: User;
  username : string = '' ;
  password : string = '' ;


  constructor(private router: Router) { }

  // Register(){

  // }
>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a

  ngOnInit() {
  }

<<<<<<< HEAD
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
=======
  loginToggle: boolean = true;

  login(): void{
    this.router.navigate(['./home']);
    sessionStorage.setItem('logged', 'true');// Delete when API is connected
  }


  // sendLogin() {
  //   this.currentUser.login(this.username, this.password).subscribe(
  //     (response:User) => {
  //       sessionStorage.setItem('currentUser', JSON.stringify(response));
  //       console.log(response);
  //       this.router.navigate(['/home']);
  //     }
  //   )
  // }
>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a
}

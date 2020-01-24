import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './../../models/user';
import { UserService } from '../../services/user.service'


@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  currentUser: User;
  username : string = '' ;
  password : string = '' ;

  constructor(private router: Router, private us: UserService) { }

  ngOnInit() {
  }


  login(){
    this.us.login(this.username, this.password).subscribe(
      (response : User) =>{
        sessionStorage.setItem('currentUser', JSON.stringify(response));
        this.currentUser = JSON.parse(sessionStorage.getItem('currentUser'));
        this.router.navigate(['./home']);
    })
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
}

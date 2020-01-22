import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from './../../models/user';



@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  currentUser: User;
  username : string = '' ;
  password : string = '' ;

  constructor(private router: Router) { }

  ngOnInit() {
  }


  login(): void{
    // this.router.navigate(['./home']);
    // sessionStorage.setItem('logged', 'true');// Delete when API is connected

      // validate information
      // send login to backend
      //  if success full redirect back to home page
      //  save http response to sessionStorage as currentUser
      //  if incorrect information, let user know

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

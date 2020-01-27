import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
  username : string;
  password : string;
  confirmpass : string;
  firstname: string;
  lastname: string;
  email: string;


  constructor(private us: UserService, private router: Router) { }
  // register(){

  // }
  ngOnInit() {
  }

  newUser() {
    if(this.password != this.confirmpass){
      document.getElementById("warning").innerHTML = "Your passwords do not match, please try again.";
    } else {
      this.us.register(this.username, this.firstname, this.lastname, this.password, this.email).subscribe(
        (response: any) => {
          if(response){
            alert(`Your account has been created ${this.firstname}!`);
            this.router.navigate(['/home']);
          }
          else{
            alert("Your account was not created.");
          }
        }
      );

    }
  }

}

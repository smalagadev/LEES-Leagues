import { Component, OnInit } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';
import { EditTeamsComponent } from './../edit-teams/edit-teams.component';
import { Router } from '@angular/router';
<<<<<<< HEAD

=======
import { UserService } from '../../services/user.service';
import { User } from '../../models/user';
>>>>>>> master

@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.css']
})
export class SettingsComponent implements OnInit {
<<<<<<< HEAD
submit(){

}
  constructor(private router: Router) { }
=======
  password : string;
  firstname : string;
  lastname : string;
  email : string;
  user : User;
  constructor(private us : UserService, private router : Router) { }
>>>>>>> master

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
<<<<<<< HEAD
    }
=======
    } else{
      this.user = JSON.parse(sessionStorage.getItem('currentUser'));
    }
  }

  update(){
    console.log(this.user);
    if(this.password === undefined || this.password===""){
      this.password = this.user.password;
    }
    if(this.firstname === undefined || this.firstname===""){
      this.firstname = this.user.firstName
    }
    if(this.lastname === undefined || this.lastname===""){
      this.lastname = this.user.lastName;
    }
    if(this.email === undefined || this.email===""){
      this.email = this.user.email;
    }
    this.us.updateUser(this.user.userId, this.user.username, this.firstname, this.lastname, this.password, this.email).subscribe();
    this.router.navigate(['/home']);
>>>>>>> master
  }

}

import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {
<<<<<<< HEAD

  constructor() { }

  submit(){
    
  }
  ngOnInit() {
  }
  username : string;
  password : string;
  firstname: string;
  lastname: string;
  email: string;
  
}
=======
  username : string;
  password : string;
  confirmpass : string;
  firstname: string;
  lastname: string;
  email: string;
  us: any;
  router: any;
  
  constructor() { }
  // constructor(private us: UserService, private router: Router) { }
  // register(){

  // }
  ngOnInit() {
  }
  newUser() {
    if(this.password != this.confirmpass){
      document.getElementById("warning").innerHTML = "Your passwords do not match, please try again.";
    } else {
      this.us.newUser(this.username, this.password, this.firstname, this.lastname, this.email).subscribe();
      this.router.navigate(['/login']);
    }
  }
  
}

>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a

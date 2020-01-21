import { Component, OnInit } from '@angular/core';
<<<<<<< HEAD
=======
import { Router } from '@angular/router';
>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

<<<<<<< HEAD
  constructor() { }
=======
  constructor(private router: Router) { }
>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a

  ngOnInit() {
  }

<<<<<<< HEAD
=======
  
  logout(): void{
    this.router.navigate(['/']);
  }

>>>>>>> c413ca34c8dcd76413381f7f87189d9cb789259a
}

import { Component } from '@angular/core';
import { NavbarComponent } from './components/navbar/navbar.component';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'login-page';
  loginToggle: boolean = true;

  toggleForm():void{
    this.loginToggle = !this.loginToggle;
  }
}

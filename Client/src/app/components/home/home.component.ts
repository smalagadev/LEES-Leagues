import { Component, OnInit } from '@angular/core';
import { GameSchedulesComponent } from './../game-schedules/game-schedules.component';
import { NewsFeedComponent } from './../news-feed/news-feed.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
    }
  }

}

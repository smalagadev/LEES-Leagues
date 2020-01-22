import { Component, OnInit } from '@angular/core';
import { GameScheduleComponent } from './../game-schedules/game-schedules.component';
import { NewsFeedComponent } from './../news-feed/news-feed.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}

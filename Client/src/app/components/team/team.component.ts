import { Component, OnInit } from '@angular/core';
import { ArticlesService } from './../../services/articles.service';
import { TeamService } from './../../services/team.service';
import { TwitterService } from './../../services/twitter.service';
import { Article } from './../../models/article';
import { Tweet } from './../../models/tweet';


@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles = [];
  events = [];
  tweets: Tweet[] = [];
  team_api_id = 134882;
  team_name = 'miami heat';
  player = [];

  constructor(private as: ArticlesService, private te: TeamService, private tw: TwitterService) { }

  ngOnInit() {

    this.as.getByTopic('miami heat').subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.te.getTeamRecentGames(this.team_api_id).subscribe(
      (response: any) => {
      this.events = response.events;
    });
    this.te.getTeamUpcomingGames(this.team_api_id).subscribe(
      (response: any) => {
      this.events = response.events;
    });

    this.te.getTeamRoster(this.team_name).subscribe(
        (response: any) => {
        this.player = response.player;
        /*data => {
          this.player = data*/
          console.log(this.player);
        }
    );
    
    /*this.tw.getTweetsByTeam('anything').subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )*/
  }

  //panelOpenState = true;
}

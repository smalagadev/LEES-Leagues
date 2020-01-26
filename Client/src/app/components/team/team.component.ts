import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';
import { TeamService } from 'src/app/services/team.service';
import { TwitterService } from 'src/app/services/twitter.service';
import { Article } from './../../models/article';
import { Tweet } from './../../models/tweet';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles: Article[] = [];
  games: Object;
  tweets: Tweet[] = [];

  constructor(private as: ArticlesService, private tes: TeamService, private tws: TwitterService) { }

  ngOnInit() {
    this.as.getByTopic.subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.tes.getTeamRecentGames.subscribe(
      (response: any) => {
      this.games = response.games;
    });
    this.tes.getTeamUpcomingGames.subscribe(
      (response: any) => {
      this.games = response.games;
    });
    this.tws.getTweetsByTeam.subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )
  }

  panelOpenState = true;
}

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
  team: {
    name: string;
  }
  articles: Article[] = [];
  games: Object;
  tweets: Tweet[] = [];

  constructor(private as: ArticlesService, private tes: TeamService, private tws: TwitterService) { }

  ngOnInit() {
    this.as.getByTopic(this.team.name).subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.tes.getTeamRecentGames(this.team.name).subscribe(
      (response: any) => {
      this.games = response.games;
    });
    this.tes.getTeamUpcomingGames(this.team.name).subscribe(
      (response: any) => {
      this.games = response.games;
      console.log(this.games);
    });
    this.tws.getTweetsByTeam(this.team.name).subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )
  }

  panelOpenState = true;
}

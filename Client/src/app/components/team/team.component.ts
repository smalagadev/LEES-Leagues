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
  team_api_id: any;
  articles: Article[] = [];
  games: Object;
  tweets: Tweet[] = [];

  constructor(private as: ArticlesService, private te: TeamService, private tw: TwitterService) { }

  ngOnInit() {
    this.as.getByTopic(this.team_api_id).subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.te.getTeamRecentGames(this.team_api_id).subscribe(
      (response: any) => {
      this.games = response.games;
    });
    this.te.getTeamUpcomingGames(this.team_api_id).subscribe(
      (response: any) => {
      this.games = response.games;
      console.log(this.games);
    });
    this.tw.getTweetsByTeam(this.team_api_id).subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )
  }

  //panelOpenState = true;
}

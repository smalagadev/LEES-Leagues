import { Component, OnInit } from '@angular/core';
import { ArticlesService } from './../../services/articles.service';
import { TeamService } from './../../services/team.service';
import { TwitterService } from './../../services/twitter.service';
import { Article } from './../../models/article';
<<<<<<< HEAD
import { Tweet } from './../../models/tweet';

=======
import { Tweet } from '../../models/tweet';
>>>>>>> master
@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles: Article[] = [];
  games: Object;
  tweets: Tweet[] = [];
  team_api_id: Number;

  constructor(private as: ArticlesService, private te: TeamService, private tw: TwitterService) { }

  ngOnInit() {
<<<<<<< HEAD
    this.as.getByTopic('anything').subscribe(
=======
    /* this.as.getByTopic.subscribe(
>>>>>>> master
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
    this.tw.getTweetsByTeam('anything').subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    ) */
  }

  //panelOpenState = true;
}

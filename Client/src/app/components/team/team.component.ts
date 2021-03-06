import { Component, OnInit } from '@angular/core';
import { ArticlesService } from './../../services/articles.service';
import { TeamService } from './../../services/team.service';
import { TwitterService } from './../../services/twitter.service';
import { Article } from './../../models/article';
import { Tweet } from './../../models/tweet';
import { Router } from '@angular/router';


@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles = [];
  recentEvents = [];
  upcomingEvents = [];
  tweets: Tweet[] = [];
  teams = [];
  teamName: string = '';
  player = [];

  constructor(private as: ArticlesService, private te: TeamService, private tw: TwitterService, private router: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
    }

    /*this.tw.getTweetsByTeam('anything').subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )*/

    this.te.getAllTeams().subscribe(
      (response: any) =>{
          this.teams = response;
    });
  }

  showTeam(t){
    this.teamName = `${t.location} ${t.name}`;

    this.as.getByTopic(`${t.location} ${t.name}`).subscribe(
      (response: any) => {
      this.articles = response.articles;
    });

    this.te.getTeamRecentGames(t.teamId).subscribe(
      (response: any) => {
      this.recentEvents = response.results;
    });

    this.te.getTeamUpcomingGames(t.teamId).subscribe(
      (response: any) => {
      this.upcomingEvents = response.events;
    });

    this.te.getTeamRoster(`${t.location} ${t.name}`).subscribe(
        (response: any) => {
        this.player = response.player;
        }
    );
  }
  //panelOpenState = true;
}

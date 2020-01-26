import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';
import { TwitterService } from 'src/app/services/twitter.service';
import { Article } from './../../models/article';
<<<<<<< HEAD
import { Router } from '@angular/router';

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
  tweets: Tweet[] = [];

<<<<<<< HEAD
  constructor(private as: ArticlesService, private router: Router) { }

  ngOnInit() {

    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
    }

    // this.as.getByTopic().subscribe(
    //   (response: any) => {
    //   this.articles = response.articles;
    // });
=======
  constructor(private as: ArticlesService, private ts: TwitterService) { }

  ngOnInit() {
    /* this.as.getByTopic.subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.ts.getTweetsByTeam.subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    ) */
>>>>>>> master
  }

  panelOpenState = true;
}

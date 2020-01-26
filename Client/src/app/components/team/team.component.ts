import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';
import { TwitterService } from 'src/app/services/twitter.service';
import { Article } from './../../models/article';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles: Article[] = [];
  tweets: Tweet[] = [];

  constructor(private as: ArticlesService, private ts: TwitterService) { }

  ngOnInit() {
    this.as.getByTopic.subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
    this.ts.getTweetsByTeam.subscribe(
      (response: any) => {
        this.tweets = response.tweets;
      }
    )
  }

  panelOpenState = true;
}

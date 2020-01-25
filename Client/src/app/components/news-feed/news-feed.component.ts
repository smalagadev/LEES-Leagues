import { Component, OnInit } from '@angular/core';
import { ArticlesService } from './../../services/articles.service';
import { Article } from './../../models/article';

@Component({
  selector: 'app-news-feed',
  templateUrl: './news-feed.component.html',
  styleUrls: ['./news-feed.component.css']
})
export class NewsFeedComponent implements OnInit {
  articles: Article[] = [];

  constructor(private as: ArticlesService) { }

  ngOnInit() {
    this.as.getTopHeadlines().subscribe(
      (response: any) => {
        this.articles = response.articles;
      });
  }

  panelOpenState = true; // Necessary for ng-materials accordian components
}

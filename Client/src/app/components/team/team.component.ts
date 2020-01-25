import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';
import { Article } from './../../models/article';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles: Article[] = [];

  constructor(private as: ArticlesService) { }

  ngOnInit() {
    this.as.getByTopic.subscribe(
      (response: any) => {
      this.articles = response.articles;
    });
  }

  panelOpenState = true;
}

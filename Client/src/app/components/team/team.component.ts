import { Component, OnInit } from '@angular/core';
import { ArticlesService } from 'src/app/services/articles.service';
import { Article } from './../../models/article';
import { Router } from '@angular/router';

@Component({
  selector: 'app-team',
  templateUrl: './team.component.html',
  styleUrls: ['./team.component.css']
})
export class TeamComponent implements OnInit {
  articles: Article[] = [];

  constructor(private as: ArticlesService, private router: Router) { }

  ngOnInit() {

    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
    }

    // this.as.getByTopic().subscribe(
    //   (response: any) => {
    //   this.articles = response.articles;
    // });
  }

  panelOpenState = true;
}

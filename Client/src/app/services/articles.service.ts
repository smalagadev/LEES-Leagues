import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// This service utilizes the news-api
export class ArticlesService {

  constructor(private http: HttpClient) { }

  api_key= environment.news_api_key;

  getTopHeadlines(){// currently retrieves general sports news
    return this.http.get(`https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=${this.api_key}`);
  }

  getByTopic(topic: string){
    return this.http.get(`https://newsapi.org/v2/everything?q=${topic}&apiKey=${this.api_key}`);
  }
}

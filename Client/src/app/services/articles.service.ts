import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// This service utilizes the news-api
export class ArticlesService {

  constructor(private http: HttpClient) { }

  api_key="b68de02f312240cd9a3aed77b8476c18";

  viewAll(){// currently retrieves general sports news
    return this.http.get(`https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=${this.api_key}`);
  }
}

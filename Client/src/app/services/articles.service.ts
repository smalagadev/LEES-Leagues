import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
// This service utilizes the news-api
export class ArticlesService {

  constructor(private http: HttpClient) { }

  viewAll(){
    return this.http.get("https://newsapi.org/v2/top-headlines?country=us&category=sports&apiKey=b68de02f312240cd9a3aed77b8476c18");
  }
}

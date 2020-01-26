import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class TwitterService {

  constructor(private http: HttpClient) { }

  api_key= environment.twitter_api_key;

  getTweetsByLeague(league: string) {
    return this.http.get('https://api.twitter.com/1.1/search/tweets.json?q={league}');
  }

  getTweetsByTeam(team: string) {
    return this.http.get('https://api.twitter.com/1.1/search/tweets.json?q={team}');
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class TwitterService {

  constructor(private http: HttpClient) { }

  api_key= environment.twitter_api_key;

  getTweetsByLeague(league: string) {
    this.http.get('https://api.twitter.com/1.1/search/tweets.json?q={league}');
  }

  getTweetsByTeam(team: string) {
    this.http.get('https://api.twitter.com/1.1/search/tweets.json?q={team}');
  }
}

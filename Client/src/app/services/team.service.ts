import { Team } from './../models/team';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  baseUrl: string = "http://localhost:8080/LEES-Leagues";
  news_api_key: string = environment.news_api_key;

  constructor(private http: HttpClient) { }

  getTeamRecentGames(team_api_id: Number){
    return this.http.get(`https://www.thesportsdb.com/api/v1/json/1/eventslast.php?id=${team_api_id}`);
  }

  getTeamUpcomingGames(team_api_id: Number){
    return this.http.get(`https://www.thesportsdb.com/api/v1/json/1/eventsnext.php?id=${team_api_id}`);
  }

  getTeamNews(team_name: string){
    return this.http.get(`https://newsapi.org/v2/everything?q=${team_name}&apiKey=${this.news_api_key}`);
  }

  getTeamRoster(team_name: string){
    return this.http.get(`https://www.thesportsdb.com/api/v1/json/1/searchplayers.php?t=${team_name}`);
  }

  getByTeamName(teamName: string) : Observable<Team>{
      return this.http.get<Team>(this.baseUrl + '/team' + teamName);
  }
  getByTeamId(teamId : Number) : Observable<Team>{
    return this.http.get<Team>(this.baseUrl + '/teams/{team_id}' + teamId );
  }
  getByUserId(id : Number) : Observable<Team>{
    return this.http.get<Team>(this.baseUrl + '/teams/{user_id}' + id);
  }
  saveTeam() : Observable<boolean>{
    let body : any = {

    }
    return this.http.put<boolean>(this.baseUrl + '/teams', body);
  }


  // returns next games for the league
  // Include id as a parameter and plug parameter into url
  getGameSchedules(){
    return this.http.get(`https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4387`);
  }
}

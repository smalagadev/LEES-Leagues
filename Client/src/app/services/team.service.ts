import { Team } from './../models/team';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TeamService {
  baseUrl:string = "http://localhost:8080/LEES-Leagues";

  constructor(private http: HttpClient) { }

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

  }
  


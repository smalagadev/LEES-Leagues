import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GameSchedulesService {

  constructor(private http: HttpClient) { }

  // Gets the next 15 games for the league using a league id, nba=4387
  getLeagueSchedule(){
    return this.http.get('https://www.thesportsdb.com/api/v1/json/1/eventsnextleague.php?id=4387');
  }

}

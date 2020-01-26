import { Component, OnInit } from '@angular/core';
import { GameSchedulesService } from './../../services/game-schedules.service';

@Component({
  selector: 'app-game-schedules',
  templateUrl: './game-schedules.component.html',
  styleUrls: ['./game-schedules.component.css']
})
export class GameSchedulesComponent implements OnInit {
  gameSchedule: any[] = [];
  columnsToDisplay = ['date-time', 'eventName'];
  constructor(private gss: GameSchedulesService) { }

  ngOnInit() {
    this.gss.getLeagueSchedule().subscribe(
      (response: any) => {
        console.log(response);
        this.gameSchedule = response.events;
      }
    )
  }

}

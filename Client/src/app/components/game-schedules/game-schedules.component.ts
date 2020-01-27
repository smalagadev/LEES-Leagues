import { Component, OnInit } from '@angular/core';
import { GameSchedulesService } from './../../services/game-schedules.service';
import { PageEvent, MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-game-schedules',
  templateUrl: './game-schedules.component.html',
  styleUrls: ['./game-schedules.component.css']
})
export class GameSchedulesComponent implements OnInit {
  gameSchedule: any = [];
  columnsToDisplay = ['date-time', 'eventName'];
  dataSource = new MatTableDataSource<GameSchedulesService>(this.gameSchedule)

  public pageSize = 5;
  public currentPage = 0;
  public totalSize = 0;
  app: any;
  paginator = [];
  array: any = [];

  constructor(private gss: GameSchedulesService) { }

  ngOnInit() {
    this.getArray();

    // this.gss.getLeagueSchedule().subscribe(
    //   (response: any) => {
    //     console.log(response);
    //     this.gameSchedule = response.events;
    //   }
    // )
  }
  private getArray() {
    this.gss.getLeagueSchedule()
      .subscribe((response : any) => {
        this.gameSchedule = response.events;
        // this.dataSource = new MatTableDataSource<GameSchedulesService>(response);
        this.gameSchedule.paginator = this.paginator;
        this.array = this.gameSchedule;
        this.totalSize = this.array.length;
        this.iterator();
      });
  }
  public handlePage(e: any) {
    this.currentPage = e.pageIndex;
    this.pageSize = e.pageSize;
    this.iterator();
  }
  private iterator() {
    const end = (this.currentPage + 1) * this.pageSize;
    const start = this.currentPage * this.pageSize;
    const part = this.array.slice(start, end);
    this.gameSchedule = part;
  }
}

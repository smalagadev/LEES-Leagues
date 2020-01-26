import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-league-search',
  templateUrl: './league-search.component.html',
  styleUrls: ['./league-search.component.css']
})
export class LeagueSearchComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
  }

}

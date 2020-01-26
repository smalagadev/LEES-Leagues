
import { FormsModule } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import {HttpClientModule, HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';


@Component({
  selector: 'app-team-search',
  templateUrl: './team-search.component.html',
  styleUrls: ['./team-search.component.css']
})
export class TeamSearchComponent implements OnInit {

  // userName: string = " ";
  id: BigInteger;
  response: any;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit() {
    if(sessionStorage.getItem('currentUser') === null){
      this.router.navigate(['/']);
    }
  }
searchById(){
  // this.http.get('https://api.github.com/users/' + this.userName)
  this.http.get('https://www.balldontlie.io/api/v1/teams/' + this.id)
  .subscribe((response) => {
    this.response = response;
    console.log(this.response);
  })
  }
}

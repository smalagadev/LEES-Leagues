import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../models/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http : HttpClient) { }

  login(username : string, password : string) : Observable<User>{
    let body : any = {
      username : username,
      password : password
    };
    console.log(body);
    return this.http.post<User>('http://localhost:8080/LEES-Leagues/users/login', body);
  }

  logout(){
    return this.http.post<void>('http://localhost:8080/LEES-Leagues/users/logout', {});
  }

  register(username: string, firstName: string, lastName: string, password : string, email: string) : Observable<boolean>{
    let body : any = {
      username : username,
      firstName : firstName,
      lastName : lastName,
      password : password,
      email : email
    }
    return this.http.post<boolean>('http://localhost:8080/LEES-Leagues/users', body);
  }

  findByName(username : string) : Observable<User>{
    return this.http.get<User>('http://localhost:8080/LEES-Leagues/users/' + username);
  }

  findById(id : Number) : Observable<User>{
    return this.http.get<User>('http://localhost:8080/LEES-Leagues/users/' + id);
  }

  updateUser() : Observable<boolean>{
    let body : any = {

    }
    return this.http.put<boolean>('http://localhost:8080/LEES-Leagues/users', body);
  }

}

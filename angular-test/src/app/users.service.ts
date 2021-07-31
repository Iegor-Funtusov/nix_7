import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from "rxjs";
import {UserModel} from "./user.model";
import {map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private _http: HttpClient) { }

  getUsers(): Observable<UserModel[]> {
    const httpOptions = {
      headers: new HttpHeaders({})
    };
    return this._http.get('http://localhost:8080/api/users', httpOptions).pipe(
      map((res: any) => {
        return res.data;
      })
    );
  }

  createUser(user: UserModel): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({})
    };
    return this._http.post('http://localhost:8080/api/users', user, httpOptions).pipe(
      map((res: any) => {
        return res.data;
      })
    );
  }
}

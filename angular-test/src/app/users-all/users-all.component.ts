import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { UserModel } from '../user.model';

@Component({
  selector: 'app-users-all',
  templateUrl: './users-all.component.html',
  styleUrls: ['./users-all.component.css']
})
export class UsersAllComponent implements OnInit {

  users: UserModel[] | undefined;

  constructor(private _usersService: UsersService) { }

  ngOnInit(): void {
    this._usersService.getUsers().subscribe(value => {
      this.users = value;
    });
  }
}

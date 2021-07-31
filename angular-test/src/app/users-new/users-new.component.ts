import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {UsersService} from "../users.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-users-new',
  templateUrl: './users-new.component.html',
  styleUrls: ['./users-new.component.css']
})
export class UsersNewComponent implements OnInit {

  userForm = new FormGroup({
    name: new FormControl(''),
    age: new FormControl(''),
  });

  constructor(private _usersService: UsersService, private _router: Router) { }

  ngOnInit(): void {
  }

  onSubmit():void {
    console.log(this.userForm.value);
    this._usersService.createUser(this.userForm.value).subscribe(() => {
      this._router.navigateByUrl('users');
    });
  }
}

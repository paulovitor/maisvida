import {Component} from '@angular/core';
import {Login} from "../../model/login";
import {LoginService} from "../../service/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  login: Login = new Login();

  constructor(private loginService: LoginService,
              private router: Router) {
  }

  logIn(): void {
    let link = ['/medicos'];
    this.router.navigate(link);
  }
}

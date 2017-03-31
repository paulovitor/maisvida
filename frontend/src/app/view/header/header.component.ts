import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";

@Component({
  moduleId: module.id,
  selector: 'header',
  templateUrl: 'header.component.html'
})
export class HeaderComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit(): void {

  }

  logout() {
    // this.authService.logout();
    this.router.navigate(['/login']);
  }
}

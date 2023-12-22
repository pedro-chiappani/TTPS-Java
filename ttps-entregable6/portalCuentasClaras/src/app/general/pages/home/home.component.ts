import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../services/auth.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styles: [ `
    .container{
      margin: 20px;
    }
  `
  ]
})
export class HomeComponent implements OnInit {

  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
  
  }

  logout(){
    this.authService.logout();
    this.router.navigate(['/auth/login']);
  }

}

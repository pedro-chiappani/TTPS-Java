import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { AuthenticationService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CuentasClaras';
  currentToken:String = '';


  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {
    
  }
}


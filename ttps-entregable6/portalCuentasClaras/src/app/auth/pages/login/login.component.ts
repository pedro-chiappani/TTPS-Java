import { Component, OnInit } from '@angular/core';
import { UntypedFormBuilder, UntypedFormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthenticationService } from '../../../services/auth.service';
import { first } from 'rxjs/operators';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
    `
    .overlay {
      background-color: white; /* Fondo opaco */
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
    }

    .example-form {
      background-color: rgba(0, 0, 0, 0.1);
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .example-form .example-full-width{
      width:100%;
      margin-bottom:15px;
    }

    `
  ]
})
export class LoginComponent {
  username: string;
  password: string;
  errorMessage: string;

  constructor(
      private authenticationService: AuthenticationService,

  ) { }
    login(): void {
      this.authenticationService.login(this.username, this.password)
    }
}

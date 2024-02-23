import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../../services/auth.service';


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
      display: flex; /* Cambio importante */
      flex-direction: column; /* Cambio importante */
    }
    
    .example-form .example-full-width {
      width: 100%;
      margin-bottom: 15px;
    }
    
    /* Agregamos un contenedor para los botones */
    .buttons-container {
      display: flex;
      justify-content: space-between; /* Los botones se distribuyen horizontalmente */
    }

    `
  ]
})
export class LoginComponent {
  username: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private authService: AuthenticationService, private router: Router) { }

  login(): void {
    this.authService.login(this.username, this.password).subscribe(
      response => {
        // Maneja la respuesta del servidor en caso de éxito
        this.errorMessage = '';  // Reinicia el mensaje de error en caso de éxito
        this.router.navigate(['/general/grupo']);
      },
      error => {
        // Maneja el error y muestra un mensaje
        this.errorMessage = error.error;
      }
    );
  }

  onClick(){

  }


}

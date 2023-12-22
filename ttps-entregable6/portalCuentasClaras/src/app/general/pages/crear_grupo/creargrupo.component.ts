import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GruposService } from '../../../services/grupos.service';


@Component({
  selector: 'app-grupo',
  templateUrl: './creargrupo.component.html',
  styles: [
    `
    form {
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      height: 100vh;
      margin: 0 auto; /* Añade margen izquierdo y derecho automáticos para centrar el formulario */
      max-width: 400px; /* Ajusta el ancho máximo según tus necesidades */
    }

    mat-form-field {
      width: 100%;
      margin-bottom: 15px;
    }

    `
  ]
})
export class CrearGrupoComponent {

  nombreGrupo: string ='';
  categoria: string ='';
  errorMessage: string ='';


  constructor(private grupoService: GruposService, private router: Router) { }


  submitForm() {
  
    this.grupoService.crearGrupo(this.categoria, this.nombreGrupo).subscribe(
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
}

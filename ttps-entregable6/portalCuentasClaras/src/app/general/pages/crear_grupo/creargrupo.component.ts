import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


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


  constructor() { }


  submitForm() {
    // Aquí puedes enviar el objeto gasto al servidor o realizar otras acciones
    console.log('Gasto enviado:');
  }
}

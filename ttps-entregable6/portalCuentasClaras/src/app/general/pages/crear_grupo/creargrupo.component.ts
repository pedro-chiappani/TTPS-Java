import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { GastosService } from '../../../services/gastos.service';
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
  errorMessage: string ='';
  categoria = '';

  constructor(private grupoService: GruposService, private router: Router) { }


  submitForm() {

    this.grupoService.crearGrupo(this.categoria, this.nombreGrupo).subscribe(
      response => {
        this.errorMessage = '';
        this.router.navigate(['/general/grupo'])
      },
      error => {
        this.errorMessage = error.error;
      }
    )
  }
}




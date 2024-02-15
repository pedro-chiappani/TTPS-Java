import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route } from '@angular/router';
import { NgForm } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';



@Component({
  selector: 'app-alta-gasto',
  templateUrl: './gasto.component.html',
  styles: `

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
})
export class GastoComponent {
  gasto: any = {
    monto: null,
    imagen: '',
    fecha: null,
    idGrupo: null,
    categoria: null,
    carga: null,
    realiza: null,
    tipoDiv: null,
    // Agrega más propiedades según tus necesidades
  };

  constructor(private gastoService: GastosService, private route: Route) { }

  submitForm() {
    this.gastoService.crearGasto(this.gasto)
    // Aquí puedes enviar el objeto gasto al servidor o realizar otras acciones
    console.log('Gasto enviado:', this.gasto);
  }
}

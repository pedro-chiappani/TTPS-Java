import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';
import { GruposService } from '../../../services/grupos.service';



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
  grupos: any[] = [];
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

  constructor(private gastoService: GastosService, private grupoService: GruposService, private router: Router) {}

  ngOnInit(): void {
    this.grupoService.listarGrupos().subscribe((grupos: any[]) =>  {
      this.grupos = grupos;
    })
  }

  submitForm() {
  this.gastoService.crearGasto(this.gasto.monto, this.gasto.imagen, this.gasto.fecha,
                              this.gasto.idGrupo, this.gasto.categoria, this.gasto.carga,
                               this.gasto.realiza, this.gasto.tipoDiv).subscribe(
    response => {
      console.log("manda", response)
    },
    error => {
      console.log("no manda", error)
    }
  )
    // Aquí puedes enviar el objeto gasto al servidor o realizar otras accione
    console.log('Gasto enviado:', this.gasto);
  }
}

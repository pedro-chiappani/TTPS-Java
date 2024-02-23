import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';


@Component({
  selector: 'app-alta-gasto',
  templateUrl: './gastosporgrupo.component.html',
  styles: 
  `
      .list-item-content {
        display: flex;
        align-items: center;
        justify-content: space-between;
        width: 100%;
      }
      
      .mat-list-item {
        margin-bottom: 10px;
      }

      .button-margin {
        margin-right: 8px; 
        margin-top: 8px;
      }

    `
})
export class GastoPorGrupoComponent implements OnInit {
  idGrupo: number=0;
  nombreGrupo: string="";
  gastos: any[]= [];

  constructor(private gastosService: GastosService, private route: ActivatedRoute) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idGrupo = +params['idGrupo'];
      this.nombreGrupo = params['nombreGrupo'];
    });
    this.listarGastosPorGrupo();
  }

  listarGastosPorGrupo(){
    this.gastosService.listarGastosPorGrupo(this.idGrupo)
      .subscribe(
        (data) => {
          this.gastos = data;
        },
        (error) => {
          console.error('Error al obtener los gastos del grupo:', error);
        }
      );
  }


  editarGasto(gasto:any) {
    // Lógica para editar el grupo
    console.log('Editando gasto:', gasto);
  }

  eliminarGasto(gasto:any) {
    // Lógica para eliminar el grupo
    console.log('Eliminando gasto:', gasto);
  }

}
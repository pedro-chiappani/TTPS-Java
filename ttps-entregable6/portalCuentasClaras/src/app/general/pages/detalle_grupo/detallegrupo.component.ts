import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { NgForm } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';
import { Gasto } from '../../../models/gasto';


@Component({
  selector: 'app-alta-gasto',
  templateUrl: './detallegrupo.component.html',
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
export class DetalleGrupoComponent implements OnInit {
  idGrupo: number=0;
  nombreGrupo: string="";
  gastos: any[]= [];

  constructor(private gastosService: GastosService, private route: ActivatedRoute, private router: Router) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.idGrupo = +params['id'];
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


  editarGasto(gasto: Gasto) {
    this.router.navigate(['/general/editargasto', gasto.id]);
  }

  eliminarGasto(gasto:any) {
    // Lógica para eliminar el grupo
    console.log('Eliminando gasto:', gasto);
  }

}

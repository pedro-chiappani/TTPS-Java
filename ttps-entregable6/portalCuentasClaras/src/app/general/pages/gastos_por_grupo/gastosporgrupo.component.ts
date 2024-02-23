import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';


@Component({
  selector: 'app-alta-gasto',
  templateUrl: './gastosporgrupo.component.html',
  styles: `
  
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
  agregarGasto() {
    // Aquí puedes redirigir a la página de agregar gasto para este grupo
    // Por ejemplo: this.router.navigate(['/agregargasto', this.idGrupo]);
  }

}
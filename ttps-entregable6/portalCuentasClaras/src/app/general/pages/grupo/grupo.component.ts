import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GruposService } from '../../../services/grupos.service';
import { HttpClient } from '@angular/common/http';
import { Grupo } from '../../../models/Grupo';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styles: [
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
  ]
})
export class GrupoComponent implements OnInit {
  grupos: Grupo[] = [];

  constructor(private grupoService: GruposService, private router: Router) {}

  ngOnInit() {
    this.obtenerGrupos();
  }

  obtenerGrupos() {
    this.grupoService.listarGrupos()
      .subscribe(
        (data) => {
          this.grupos = data;
        },
        (error) => {
          console.error('Error al obtener los grupos:', error);
        }
      );
  }

  listarGastos(grupo: Grupo) {
    this.router.navigate(['/general/gastosPorGrupo', grupo.id]);
  }

  editarGrupo(grupo: Grupo) {
    // Lógica para editar el grupo
    this.router.navigate(['/general/editargrupo', grupo.id]);
  }

  eliminarGrupo(grupo: Grupo) {
    // Lógica para eliminar el grupo
    console.log('Eliminando grupo:', grupo);
  }
}

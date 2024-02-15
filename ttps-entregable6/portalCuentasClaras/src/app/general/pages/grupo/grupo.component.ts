import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GruposService } from '../../../services/grupos.service';
import { HttpClient } from '@angular/common/http';
import { Grupo } from '../../../models/grupo';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styles: [
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

  editarGrupo(grupo: Grupo) {
    // Lógica para editar el grupo
    console.log('Editando grupo:', grupo);
  }

  eliminarGrupo(grupo: Grupo) {
    // Lógica para eliminar el grupo
    console.log('Eliminando grupo:', grupo);
  }
}

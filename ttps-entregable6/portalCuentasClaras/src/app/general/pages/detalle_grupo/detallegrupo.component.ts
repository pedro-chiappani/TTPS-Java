// detalle-grupo.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Grupo } from '../../../models/grupo';
import { GruposService } from '../../../services/grupos.service';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators'


@Component({
  selector: 'app-detalle-grupo',
  templateUrl: './detallegrupo.component.html',
  styles: []
})
export class DetalleGrupoComponent implements OnInit {
  grupoId: number
  grupo: Grupo;

  constructor(private grupoService:GruposService, private route: ActivatedRoute, private http: HttpClient) { }

  ngOnInit() {
    this.obtenerIdGrupoDesdeUrl();
    this.obtenerDetalleGrupo();
  }

  obtenerIdGrupoDesdeUrl() {
    this.route.params.subscribe(paramsId => {
      this.grupoId = paramsId["id"];
      console.log(this.grupoId)
    });
  }

  obtenerDetalleGrupo() {
    this.grupoService.obtenerGrupo(this.grupoId)
      .subscribe(
        (data) => {
          this.grupo = data;
        },
        (error) => {
          console.error('Error al obtener el detalle del grupo:', error);
        }
      );
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GruposService } from '../../../services/grupos.service';

@Component({
  selector: 'app-grupo',
  templateUrl: './grupo.component.html',
  styles: [
  ]
})
export class GrupoComponent implements OnInit {
  grupos: any[];
  constructor(private grupoService: GruposService, private router: Router) { }

  ngOnInit(): void {
    // console.log(this.grupoService.listarGrupos());
    // console.log(this.grupos);
  }


}

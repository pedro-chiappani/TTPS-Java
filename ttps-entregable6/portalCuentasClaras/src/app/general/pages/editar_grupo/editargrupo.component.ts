import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { GastosService } from '../../../services/gastos.service';
import { GruposService } from '../../../services/grupos.service';
import { CategoriaService } from '../../../services/categoria.service';

@Component({
  selector: 'app-grupo',
  templateUrl: './editargrupo.component.html',
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
export class EditarGrupoComponent {
  categorias: any[] = [];
  nombreGrupo: string ='';
  errorMessage: string ='';
  idGrupo: number;
  categoria = '';

  constructor(private grupoService: GruposService, private categoriaService: CategoriaService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.categoriaService.obtenerCatGrupos().subscribe((cats: any[]) => {
      this.categorias = cats;
    })

    this.route.params.subscribe(params => {
      this.idGrupo = +params['id']
    });
  }

  submitForm() {

    this.grupoService.editarGrupo(this.categoria, this.nombreGrupo, this.idGrupo).subscribe(
      response => {
        this.errorMessage = '';
        console.log("asda")
        this.router.navigate(['/general/grupo'])
      },
      error => {
        this.errorMessage = error.error;
      }
    )
  }
}




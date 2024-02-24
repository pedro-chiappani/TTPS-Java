import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { GastosService } from '../../../services/gastos.service';
import { GruposService } from '../../../services/grupos.service';
import { User } from '../../../models';
import { CategoriaService } from '../../../services/categoria.service';

interface UsuarioDetalle {
  id: string;
  valor: number;
  nombre: string;
}

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
  users: any[] = [];
  categorias: any[] = [];
  detalleGasto: any[] = [];
  gasto: any = {
    monto: null,
    imagen: '',
    fecha: null,
    idGrupo: null,
    categoria: null,
    realiza: null,
    carga: null,
    tipoDiv: null,
    // Agrega más propiedades según tus necesidades
  };
  usuariosDelGrupo: UsuarioDetalle[] = [];

  constructor(private fb: FormBuilder, private gastoService: GastosService, private categoriaService: CategoriaService, private grupoService: GruposService, private router: Router) {}

  ngOnInit(): void {
    let u = localStorage.getItem("user")!
    console.log("user", u)


    this.grupoService.listarGruposUsuario(u).subscribe((grupos: any[]) =>  {
      this.grupos = grupos;
    })

    this.categoriaService.obtenerCatGastos().subscribe((cats: any[]) => {
      this.categorias = cats;
    })
  }



  createMontoFijoFormGroup(): FormGroup {
    return this.fb.group({
      // Define form controls for Monto Fijo
      usuario: ['', Validators.required],
      monto: ['', Validators.required],
    });
  }

  createPorcentajeFormGroup(): FormGroup {
    return this.fb.group({
      // Define form controls for Porcentaje
      usuario: ['', Validators.required],
      porcentaje: ['', Validators.required],
    });
  }

  actualizarUsuariosDelGrupo(users: any){
    console.log("entra")
    this.usuariosDelGrupo = []
    for (let u of users) {
      this.usuariosDelGrupo.push({id: u.id, valor:0, nombre:u.nombre})
    }
    console.log("udg", this.usuariosDelGrupo)
  }

  fetchUsuariosDelGrupo(){
    console.log(this.usuariosDelGrupo)
  }

  fetchUsers(groupId: any) {
    this.grupoService.listarUsuariosGrupo(groupId).subscribe(users => {
      console.log("users", users)
      this.actualizarUsuariosDelGrupo(users)
      this.users = users;
    });
  }

  submitForm() {
    if (this.gasto.tipoDiv === "1") {

      // Aquí puedes iterar sobre los usuarios y obtener los valores ingresados
      this.usuariosDelGrupo.forEach(usuario => {
        this.detalleGasto.push({"idUsu": usuario.id, "valor": usuario.valor})
        console.log(`Valor para ${usuario.id}: ${usuario.valor}`);
        // Aquí puedes almacenar los valores en tu objeto de gasto o enviarlos al backend
      });

    } else if (this.gasto.tipoDiv === "2") {

      this.usuariosDelGrupo.forEach(usuario => {

        this.detalleGasto.push({"idUsu": usuario.id, "valor": parseInt(this.gasto.monto) * (usuario.valor/100)})
        console.log(`Usuario: ${usuario.id} - Porcentaje: ${usuario.valor}`);
        // Aquí puedes almacenar los valores en tu objeto de gasto o enviarlos al backend
      });
      // Aquí puedes almacenar el porcentaje en tu objeto de gasto o enviarlo al backend

    } else if (this.gasto.tipoDiv === "3") {

      // Aquí pu
      const valorIgual = this.gasto.monto / this.users.length;
      this.usuariosDelGrupo.forEach(usuario => {
        this.detalleGasto.push({"idUsu": usuario.id, "valor": valorIgual})

      })
      console.log(`Valor igual para todos: ${valorIgual}`);
      // Aquí puedes almacenar el valor igual en tu objeto de gasto o enviarlo al backend

    }




    this.gastoService.crearGasto(this.gasto.monto, this.gasto.imagen, this.gasto.fecha,
                              this.gasto.idGrupo, this.gasto.categoria, this.gasto.carga,
                               this.gasto.realiza, this.gasto.tipoDiv, this.detalleGasto).subscribe(
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

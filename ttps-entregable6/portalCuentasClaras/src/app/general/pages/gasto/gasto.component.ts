import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgForm } from '@angular/forms';

interface UsuarioDetalle {
  id: string; 
  valor: number; 
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
  
  
  
  gasto: any = {
    monto: null,
    imagen: '',
    fecha: null,
    // Agrega más propiedades según tus necesidades
  };

  usuariosDelGrupo: UsuarioDetalle[] = [];

  constructor(){
    this.usuariosDelGrupo.push({ id: 'usuario1', valor: 0 });
    this.usuariosDelGrupo.push({ id: 'usuario2', valor: 0 });
    this.usuariosDelGrupo.push({ id: 'usuario3', valor: 0 });
  }

  submitForm() {
    // Aquí puedes enviar el objeto gasto al servidor o realizar otras acciones
    //console.log('Gasto enviado:', this.gasto);

    if (this.gasto.tipoDivisionGasto === 'Fijo') {
      
      // Aquí puedes iterar sobre los usuarios y obtener los valores ingresados
      this.usuariosDelGrupo.forEach(usuario => {
        console.log(`Valor para ${usuario.id}: ${usuario.valor}`);
        // Aquí puedes almacenar los valores en tu objeto de gasto o enviarlos al backend
      });

    } else if (this.gasto.tipoDivisionGasto === 'Porcentaje') {
      
      this.usuariosDelGrupo.forEach(usuario => {
        console.log(`Usuario: ${usuario.id} - Porcentaje: ${usuario.valor}`);
        // Aquí puedes almacenar los valores en tu objeto de gasto o enviarlos al backend
      });
      // Aquí puedes almacenar el porcentaje en tu objeto de gasto o enviarlo al backend

    } else if (this.gasto.tipoDivisionGasto === 'Igual') {

      // Aquí puedes calcular el valor igual para todos los usuarios
      const valorIgual = this.gasto.monto / this.usuariosDelGrupo.length;
      console.log(`Valor igual para todos: ${valorIgual}`);
      // Aquí puedes almacenar el valor igual en tu objeto de gasto o enviarlo al backend

    }


  }
}


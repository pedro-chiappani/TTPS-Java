import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'

@Injectable()
export class CategoriaService {

  constructor(private http: HttpClient) {}

  obtenerCatGrupos():Observable<any>{
    return this.http.get<any>('http://localhost:8080/categorias/categoriasGrupos')
    .pipe(
        map(response => {
            console.log(response)
            return response;
        })
    );
  }

  obtenerCatGastos():Observable<any>{
    return this.http.get<any>('http://localhost:8080/categorias/categoriasGastos')
    .pipe(
        map(response => {
            console.log(response)
            return response;
        })
    );
  }

}

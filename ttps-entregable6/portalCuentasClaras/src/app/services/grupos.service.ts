import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable, map } from 'rxjs';

@Injectable({providedIn: 'root'})
export class GruposService {

  constructor(private http: HttpClient) {}

  crearGrupo(categoria: string, nombre: string): Observable<any>{
    return this.http.post<any>('http://localhost:8080/grupos/crearGrupo', {"idUsuario": localStorage.getItem('user'), "categoria": categoria, "nombre": nombre})
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    );
  }

}

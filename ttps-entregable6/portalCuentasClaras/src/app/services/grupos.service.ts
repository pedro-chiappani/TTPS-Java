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
        // console.log(response);
        return response;
      })
    );
  }

  editarGrupo(categoria: string, nombre: string, id:number): Observable<any>{
    return this.http.put<any>(`http://localhost:8080/grupos/${id}`, {"categoria": categoria, "nombre": nombre})
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    );
  }

  listarGrupos(): Observable<any>{
    return this.http.get<any>('http://localhost:8080/grupos/listarGrupos')
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

  listarUsuariosGrupo(id: string): Observable<any>{
    return this.http.get<any>(`http://localhost:8080/grupos/${id}/usuarios`)
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

  listarGruposUsuario(id: string): Observable<any>{
    return this.http.get<any>(`http://localhost:8080/usuarios/${id}/grupos`)
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

  obtenerGrupo(id: number): Observable<any>{
    return this.http.get<any>(`http://localhost:8080/grupos/${id}/gastos`)
    .pipe(
      map(response => {
        console.log('gastos', response);
        return response;
      })
    )
  }

}

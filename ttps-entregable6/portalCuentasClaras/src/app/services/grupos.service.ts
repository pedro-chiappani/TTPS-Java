import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class GruposService {

  constructor(private http: HttpClient) {}

  crearGrupo(categoria: string, nombre: string): Observable<any>{
    return this.http.post<any>('http://localhost:8081/grupos/crearGrupo', { "idUsuario": localStorage.getItem("userid"), "categoria": categoria, "nombre": nombre })
    .pipe(
      map(response => {
        console.log(response);
        return response; // Devuelve la respuesta si es necesario
      })
    );
  }

  listarGrupos(): Observable<any>{
    console.log(localStorage.getItem("userid"));
    return this.http.get<any>(`http://localhost:8081/usuarios/${localStorage.getItem("userid")}/grupos`)
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

  obtenerGrupo(id: number): Observable<any>{
    return this.http.get<any>(`http://localhost:8081/grupos/${id}/gastos`)
    .pipe(
      map(response => {
        console.log('gastos', response);
        return response;
      })
    )
  }


}
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class GastosService {

  constructor(private http: HttpClient) {}

  // crearGrupo(categoria: string, nombre: string): Observable<any>{
  //   return this.http.post<any>('http://localhost:8081/grupos/crearGrupo', { "idUsuario": localStorage.getItem("userid"), "categoria": categoria, "nombre": nombre })
  //   .pipe(
  //     map(response => {
  //       console.log(response);
  //       return response; // Devuelve la respuesta si es necesario
  //     })
  //   );
  // }

}
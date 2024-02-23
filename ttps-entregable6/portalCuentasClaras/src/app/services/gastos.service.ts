import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class GastosService {

  constructor(private http: HttpClient) {}

  listarGastosPorGrupo(idGrupo:number): Observable<any>{
    return this.http.get<any>('http://localhost:8081/grupos/listarGastosPorGrupo/${idGrupo}')
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

}
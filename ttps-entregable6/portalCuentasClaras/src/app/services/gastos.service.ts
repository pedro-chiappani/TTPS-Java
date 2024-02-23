import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class GastosService {

  constructor(private http: HttpClient) {}

  listarGastosPorGrupo(idGrupo:number): Observable<any>{
    console.log("id de grupo" + idGrupo);
    return this.http.get<any>(`http://localhost:8081/grupos/${idGrupo}/gastos`)
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    )
  }

}
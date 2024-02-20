import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'

@Injectable()
export class GastosService {

  constructor(private http: HttpClient) {}

//   getHeroes(): Observable<Heroe[]> {
//     return this.http.get<Heroe[]>('http://localhost:3000/heroes');
//   }
crearGasto(monto:number, imagen: string, fecha: Date, idGrupo:number, categoria:string, carga: string, realiza:string, tipoDiv: string): Observable<any>{
  return this.http.post<any>('http://localhost:8080/gastos/cargarGasto', {"monto": monto, "imagen": imagen, "fecha": fecha, "idGrupo": idGrupo, "categoria":categoria, "cargaGasto": carga, "realizaGasto": realiza, "tipoDivisionGasto": tipoDiv, })
  .pipe(
    map(response => {
      console.log(response);
      return response;
    })
  );
}
}

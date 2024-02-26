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

  crearGasto(monto:number, imagen: string, fecha: Date, idGrupo:number, categoria:string, carga: string, realiza:string, tipoDiv: string, detalleGasto: any[]): Observable<any>{
    return this.http.post<any>('http://localhost:8081/gastos/cargarGasto',
         {"monto": monto, "imagen": imagen, "fecha": fecha, "idGrupo": idGrupo,
          "categoria":categoria, "cargaGasto": carga, "realizaGasto": realiza,
           "tipoDivisionGasto": tipoDiv, "detalleDivisionGasto":detalleGasto
      })
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    );
  }


  editarGasto(categoria: string, nombre: string, id:number): Observable<any>{
    return this.http.put<any>(`http://localhost:8081/gastos/${id}`, {"categoria": categoria, "imagen": nombre})
    .pipe(
      map(response => {
        console.log(response);
        return response;
      })
    );
  }

}
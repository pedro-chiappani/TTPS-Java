import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
//import { Heroe } from '../interfaces/heroes.interface';
import { Observable } from 'rxjs';

@Injectable()
export class AuthService {

  constructor(private http: HttpClient) {}

//   getHeroes(): Observable<Heroe[]> {
//     return this.http.get<Heroe[]>('http://localhost:3000/heroes');
//   }

}
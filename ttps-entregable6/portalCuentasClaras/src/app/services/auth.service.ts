import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment as env } from '../../environments/environment';

import { User } from '../models';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<String>;
    public currentUser: Observable<String>;

    constructor(private http: HttpClient) {
        console.log(localStorage.getItem('user'))
        this.currentUserSubject = new BehaviorSubject<String>(localStorage.getItem('token') || '');
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): String {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string): Observable<any> {
        return this.http.post<any>("http://localhost:8080/usuarios/login", { "nombreUsuario": username, "clave":password })
            .pipe(map(response => {
                console.log(response);
                localStorage.setItem('token', response.token);
                localStorage.setItem('user', response.username)
                this.currentUserSubject.next(response.token);
                return response;
            }))
        }

    logout() {
        // elimino las credenciales del localstorage al deslogearme
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        this.currentUserSubject.next('');
    }
    register(username: string, password: string, email: string, name: string, lastname: string) {
        return this.http.post<any>('http://localhost:8081/usuarios/registrarUsuario', { "nombreUsuario": username, "clave": password , "nombre":name, "apellido":lastname, "email":email})
          .pipe(
            map(response => {
              return response; // Devuelve la respuesta si es necesario
            })
          );
      }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { User } from '../models/User';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {

  private currentTokenSubject: BehaviorSubject<String>;
  public currentToken: Observable<String>;

  constructor(private http: HttpClient) {
    this.currentTokenSubject = new BehaviorSubject<String>(localStorage.getItem('token') || "");
    this.currentToken = this.currentTokenSubject.asObservable();
  }

  public get currentTokenValue(): String {
    return this.currentTokenSubject.value;
  }

  login(username: string, password: string): Observable<any> {

    return this.http.post<any>('http://localhost:8081/usuarios/login', { "nombreUsuario": username, "clave": password })
      .pipe(
        map(response => {
          localStorage.setItem('token', response.token);
          this.currentTokenSubject.next(response.token);
          return response; // Devuelve la respuesta si es necesario
        })
      );
  }

  logout(): void {
    // remove token from local storage
    localStorage.removeItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isAuthenticated(): boolean {
    // check if a token exists
    return !!this.getToken();
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
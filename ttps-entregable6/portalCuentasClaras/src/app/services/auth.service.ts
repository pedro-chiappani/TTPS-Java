import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment as env } from '../../environments/environment';

import { User } from '../models';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {
    private currentUserSubject: BehaviorSubject<User>;
    public currentUser: Observable<User>;

    constructor(private http: HttpClient) {
        this.currentUserSubject = new BehaviorSubject<User>(JSON.parse(localStorage.getItem('currentUser') || '{}'));
        this.currentUser = this.currentUserSubject.asObservable();
    }

    public get currentUserValue(): User {
        return this.currentUserSubject.value;
    }

    login(username: string, password: string) {
      console.log("en login", username, password)
        return this.http.post<User>("http://localhost:8080/usuarios/login", { "nombreUsuario": username, "clave":password })
            // .pipe(map(credentials => {
            //   console.log(credentials)
            //     // login successful si hay un token en la respuesta
            //     console.log("asdf")
            //     if (credentials && credentials.token) {

            //       console.log("a")
            //         // store user details and jwt token in local storage to keep user logged in between page refreshes
            //         localStorage.setItem('token', JSON.stringify(credentials));
            //         this.currentUserSubject.next(credentials);
            //     }

            //     return credentials;
            // }))
            .subscribe(token => {
              console.log(token);
              localStorage.setItem('token', JSON.stringify(token.token))});
    }

    logout() {
        // elimino las credenciales del localstorage al deslogearme
        localStorage.removeItem('currentUser');
        this.currentUserSubject.next(new User());
    }
}

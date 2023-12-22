import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

import { AuthenticationService } from '../services/auth.service';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthenticationService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // agrego Authorization Header con jwt token si esta disponible
        let currentToken = this.authenticationService.currentTokenValue;
        if (currentToken && currentToken!=='') {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${currentToken}`
                }
            });
        }

        return next.handle(request);
    }
}
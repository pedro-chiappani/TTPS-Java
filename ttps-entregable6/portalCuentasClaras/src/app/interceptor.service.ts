import { HttpInterceptor, HttpSentEvent,
    HttpHeaderResponse, HttpHandler, HttpEvent,
    HttpRequest, HttpHeaders, HttpClient,
    HttpErrorResponse } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
constructor(private http: HttpClient){
}
intercept(req: HttpRequest<any>, next: HttpHandler) {
    // console.log(`TokenInterceptor - ${req.url}`);
    let authReq: HttpRequest<any> = req.clone({
    setHeaders:{
    Authorization : `Bearer ${localStorage.getItem("token")}`
    }
    });
    return next.handle(authReq); //para no hacer cambios
    //podría enviar next.handle(req)
    }
}

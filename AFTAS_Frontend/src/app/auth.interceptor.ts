import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor, HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';
import {Router} from "@angular/router";
import {AuthService} from "./auth/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private router: Router,
    private authService: AuthService
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const excluded_routes: string[] = ['register', 'login'];

    if (excluded_routes.some((route: string) => this.router.url.includes(route))) {
      return next.handle(request);
    }

    const token = this.authService.getToken();
    const modifiedRequest = request.clone({
      headers: new HttpHeaders({
        "Authorization": token ? `Bearer ${token}` : ''
      }),
    });

    return next.handle(modifiedRequest);
  }

}

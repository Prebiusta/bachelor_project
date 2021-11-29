import { Injectable } from '@angular/core';
import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { EMPTY, throwError } from 'rxjs';
import { TokenService } from './sf-token.service';
import { catchError, map } from 'rxjs/operators';
import { AuthorizationService } from './sf-authorization.service';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    constructor(private router: Router, private tokenService: TokenService, private authService: AuthorizationService) {

    }

    intercept(request: HttpRequest<any>, next: HttpHandler): any {
        const token = this.tokenService.getToken();

        if (token) {
            request = request.clone({
                setHeaders: {
                    Authorization: 'Bearer ' + token
                }
            });
        }

        if (!request.headers.has('Content-Type')) {
            request = request.clone({
                setHeaders: {
                    'content-type': 'application/json'
                }
            });
        }

        request = request.clone({
            headers: request.headers.set('Accept', 'application/json')
        });

        return next.handle(request).pipe(
            map((event: HttpEvent<any>) => {
                return event;
            }),
            catchError((error: HttpErrorResponse) => {
                if (error.status === 401) {
                        this.authService.logout();
                        this.router.navigate(['login']);
                        return EMPTY;
                }
                return throwError(error);
            }));
    }
}
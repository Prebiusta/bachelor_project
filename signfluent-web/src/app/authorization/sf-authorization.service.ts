import {Injectable} from "@angular/core";
import { HttpRequestService } from "../modules/core/services/http-request.service";
import { TokenService } from "./sf-token.service";
import { tap } from 'rxjs/operators';
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class AuthorizationService {
  constructor(private http: HttpRequestService, private tokenService: TokenService) {
  }

  public redirectUrl = '';

  public login(loginData: any): Observable<any> {
    this.tokenService.removeToken();
    this.tokenService.removeRefreshToken();
    const password = loginData.password;
    const username = loginData.username;

    const body = {password: password, username: username};

    return this.http.postType<any>('/authenticate', body).pipe(
        tap(res => {
          this.tokenService.saveToken(res.token);
          this.tokenService.saveRefreshToken(res.refreshToken);
        })
      );
  }

  public refreshToken(refreshData: any): Observable<any> {
      this.tokenService.removeToken();
      this.tokenService.removeRefreshToken();

      const body = {refreshToken: refreshData.refresh_token}

      return this.http.postType<any>('/refreshToken', body).pipe(
          tap(res => {
              this.tokenService.saveToken(res.token);
              this.tokenService.saveRefreshToken(res.refreshToken);
          })
      )
  }

  public logout(): void {
      this.tokenService.removeRefreshToken();
      this.tokenService.removeToken();
  }



}

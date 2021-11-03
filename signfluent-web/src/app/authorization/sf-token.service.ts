import {Injectable} from "@angular/core";
const ACCESS_TOKEN = 'access_token';
const REFRESH_TOKEN = 'refresh_token';



@Injectable({
  providedIn: 'root',
})
export class TokenService {
  constructor() {
  }

  getToken(): string | null {
    return sessionStorage.getItem(ACCESS_TOKEN);
  }

  getRefreshToken(): string | null {
    return sessionStorage.getItem(REFRESH_TOKEN);
  }

  saveToken(token: any): void {
    sessionStorage.setItem(ACCESS_TOKEN, token);
  }

  saveRefreshToken(refreshToken: any): void {
    sessionStorage.setItem(REFRESH_TOKEN, refreshToken);
  }

  removeToken(): void {
    sessionStorage.removeItem(ACCESS_TOKEN);
  }

  removeRefreshToken(): void {
    sessionStorage.removeItem(REFRESH_TOKEN);
  }

}

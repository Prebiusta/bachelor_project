import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { EnvironmentUrlService } from "./environment-url.service";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class HttpRequestService {
  constructor(private http: HttpClient, private envUrl: EnvironmentUrlService) { }

  public get = (route: string) => {
    return this.http.get(this.createCompleteRoute(route, this.envUrl.url));
  }

  public post(route: string, body: any): Observable<Object> {
    return this.http.post(this.createCompleteRoute(route, this.envUrl.url), body);
  }

  public postType<T>(route: string, body: any): Observable<T> {
    return this.http.post<T>(this.createCompleteRoute(route, this.envUrl.url), body);
  }

  public put = (route: string, body: any) => {
    return this.http.put(this.createCompleteRoute(route, this.envUrl.url), body);
  }

  public delete = (route: string) => {
    return this.http.delete(this.createCompleteRoute(route, this.envUrl.url));
  }

  private createCompleteRoute = (route: string, envAddress: string) => {
    return `${envAddress}/${route}`;
  }
}

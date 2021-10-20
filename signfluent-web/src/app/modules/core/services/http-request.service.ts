import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { EnvironmentUrlService } from "./environment-url.service";

@Injectable({
    providedIn: 'root'
})
export class HttpRequestService {
    constructor(private http: HttpClient, private envUrl: EnvironmentUrlService) { }

    public get = (route: string) => {
        return this.http.get(this.createCompleteRoute(route, this.envUrl.url));
      }
     
      public post = (route: string, body: any) => {
        return this.http.post(this.createCompleteRoute(route, this.envUrl.url), body, this.generateHeaders());
      }
     
      public put = (route: string, body: any) => {
        return this.http.put(this.createCompleteRoute(route, this.envUrl.url), body, this.generateHeaders());
      }
     
      public delete = (route: string) => {
        return this.http.delete(this.createCompleteRoute(route, this.envUrl.url));
      }
     
      private createCompleteRoute = (route: string, envAddress: string) => {
        return `${envAddress}/${route}`;
      }
     
      private generateHeaders = () => {
        return {
          headers: new HttpHeaders({'Content-Type': 'application/json'})
        }
      }
}
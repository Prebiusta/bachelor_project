import {Injectable} from "@angular/core";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EnvironmentUrlService {
  public url: string = `http://${environment.apiHost}:${environment.apiPort}`
}

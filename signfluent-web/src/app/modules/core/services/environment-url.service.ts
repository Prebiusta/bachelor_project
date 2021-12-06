import {Injectable} from "@angular/core";
import {environment} from "../../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EnvironmentUrlService {
  public url: string = environment.businessServiceHost
}

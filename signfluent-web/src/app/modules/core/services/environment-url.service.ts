import { Injectable } from "@angular/core";

@Injectable({
    providedIn: 'root'
})
export class EnvironmentUrlService {
    public url: string = 'http://localhost:8000'
}
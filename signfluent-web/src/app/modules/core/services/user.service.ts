import { Injectable } from "@angular/core";
import { HttpRequestService } from "./http-request.service";
import { SfUser } from "../models/sf-user";

@Injectable({
    providedIn: 'root'
})
export class UserService {
    constructor(private http: HttpRequestService) {

    }

    public getActiveApprovers() {
        return this.http.postType<SfUser[]>("/api/signingProcess/getActiveApprovers", undefined)
    }
}
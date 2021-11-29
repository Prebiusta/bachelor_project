import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { SfUser } from "../../core/models/sf-user";
import { HttpRequestService } from "../../core/services/http-request.service";


@Injectable({
    providedIn: 'root',
})
export class UserService {
    constructor(private http: HttpRequestService) {
    }

    public createUser(user: SfUser): Observable<Object> {
        return this.http.post("api/user/createUser", user);
    }

    public getAllUsers(): Observable<SfUser[]> {
        return this.http.postType<SfUser[]>("api/user/getAllUsers", {});
    }

    public getUserDetails(id: string): Observable<SfUser> {
        return this.http.postType<SfUser>(`api/user/getUserDetails/${id}`, {});
    }


}

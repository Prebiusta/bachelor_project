import { Injectable } from "@angular/core";
import { SfUser } from "../models/sf-user";
import { HttpRequestService } from "./http-request.service";
import { SfRole } from "../models/sf-role";


@Injectable({
    providedIn: 'root',
})
export class SessionService {

    private roles: SfRole[] = [];

    constructor(private http: HttpRequestService) {
        this.saveRoles();
    }

    public saveRoles(): void {
        this.http.postType<SfRole[]>("api/role/getForCurrentUser", {}).subscribe(roles => {
            this.roles = roles;
        });
    }

    public removeRoles(): void {
        this.roles = [];
    }

    public hasRole(userRole: string): boolean {
        return this.roles.filter((role: SfRole) => role.name == userRole).length > 0
    }


    public getCurrentUserDetails() {
        return this.http.postType<SfUser>("api/user/getCurrentUserDetails", {});
    }

}

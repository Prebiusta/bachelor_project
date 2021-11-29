import { Component } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { AuthorizationService } from "src/app/authorization/sf-authorization.service";
import { RoleService } from "src/app/modules/users/services/sf-role.service";
import { SessionService } from "../../services/sf-session.service";


@Component({
    selector: 'sf-logout-dialog',
    templateUrl: './sf-logout-dialog.component.html',
    styleUrls: ['./sf-logout-dialog.component.scss']
})

export class SfLogoutDialogComponent {
    
    constructor(public dialogRef: MatDialogRef<SfLogoutDialogComponent>, private authService: AuthorizationService, private router: Router, private sessionService: SessionService) { }

    public close(): void {
        this.dialogRef.close();
    }

    public logout(): void {
        this.authService.logout();
        this.sessionService.removeRoles();
        this.dialogRef.close();
        this.router.navigate(['/login']);
    }
}

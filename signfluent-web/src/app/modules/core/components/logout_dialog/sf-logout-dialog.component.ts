import { Component } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";
import { Router } from "@angular/router";
import { AuthorizationService } from "src/app/authorization/sf-authorization.service";


@Component({
    selector: 'sf-logout-dialog',
    templateUrl: './sf-logout-dialog.component.html',
    styleUrls: ['./sf-logout-dialog.component.scss']
})

export class SfLogoutDialogComponent {
    
    constructor(public dialogRef: MatDialogRef<SfLogoutDialogComponent>, private authService: AuthorizationService, private router: Router) { }

    public close(): void {
        this.dialogRef.close();
    }

    public logout(): void {
        this.authService.logout();
        this.dialogRef.close();
        this.router.navigate(['/login']);
    }
}

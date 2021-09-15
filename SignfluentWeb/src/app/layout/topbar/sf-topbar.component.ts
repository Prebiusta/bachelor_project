import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { SfLogoutDialogComponent } from "./logout_dialog/sf-logout-dialog.component";


@Component({
    selector: 'sf-topbar',
    templateUrl: './sf-topbar.component.html',
    styleUrls: ['./sf-topbar.component.scss']
})

export class SfTopbarComponent {

    constructor(public dialog: MatDialog) {}

    public openLogoutDialog(): void {
        this.dialog.open(SfLogoutDialogComponent);
    }
}
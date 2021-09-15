import { Component } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";
import {MatButtonModule} from '@angular/material/button';


@Component({
    selector: 'sf-logout-dialog',
    templateUrl: './sf-logout-dialog.component.html',
})

export class SfLogoutDialogComponent {
    
    constructor(public dialogRef: MatDialogRef<SfLogoutDialogComponent>){}

    public close(): void {
        this.dialogRef.close();
    }
 }

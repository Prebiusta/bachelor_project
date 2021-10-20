import { Component } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";


@Component({
    selector: 'sf-delegate-reject',
    templateUrl: './sf-delegate-reject.component.html',
    styleUrls: ['./sf-delegate-reject.component.scss']
})

export class SfDelegateRejectComponent {
    
    constructor(public dialogRef: MatDialogRef<SfDelegateRejectComponent>) { }

    public close(): void {
        this.dialogRef.close();
    }
}

import { Component } from "@angular/core";
import { MatDialogRef } from "@angular/material/dialog";
import { DocumentProcessUtil } from "../../constants/document-process-util";


@Component({
    selector: 'sf-dialog-reject-document',
    templateUrl: './sf-dialog-reject-document.component.html',
    styleUrls: ['./sf-dialog-reject-document.component.scss']
})

export class SfDialogRejectDocument {
    
    constructor(public dialogRef: MatDialogRef<SfDialogRejectDocument>) { }

    public close(): void {
        this.dialogRef.close();
    }

    public reject(): void {
        this.dialogRef.close({event: DocumentProcessUtil.REJECT})
    }
}

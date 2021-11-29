import { Component } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { ActivatedRoute, Router } from "@angular/router";
import { SfDocument } from "../../model/sf-document";
import { DocumentSigningProcessService } from "../../services/document-signing-process.service";
import { SfDialogRejectDocument } from "../dialogs/sf-dialog-reject-document.component";
import { DocumentProcessUtil } from "../../constants/document-process-util";
import { SfDocumentApproval } from "../../model/sf-document-approval";
import { MatSnackBar } from "@angular/material/snack-bar";



@Component({
    selector: 'sf-documents-approve',
    templateUrl: './sf-documents-approve.component.html',
    styleUrls: ['./sf-documents-approve.component.scss']
})
export class SfDocumentsApproveComponent {

    public document!: SfDocument;

    private processId!: string;

    constructor(private signingProcessService: DocumentSigningProcessService, private route: ActivatedRoute, public dialog: MatDialog, private router: Router, private snackbar: MatSnackBar) {

        
    }

    public ngOnInit() {
        this.getDocumentDetails();
    }

    private getDocumentDetails() {
        const processId = String(this.route.snapshot.paramMap.get('processId'))
        this.processId = processId;
        this.signingProcessService.get(processId).subscribe(document => {
            this.document = document;
        });
    }

    public approveDocument(): void {
        const approval: SfDocumentApproval = {processId: this.processId, approve: true};

        this.signingProcessService.approve(approval).subscribe({
            next: data => {
                this.snackbar.open("Started approval process", undefined, {
                    duration: 5 * 1000
                });
                this.router.navigate(['/signfluent/documents']);
            },
            error: error => {
                this.snackbar.open("Unable to start approval process", undefined, {
                    duration: 5 * 1000
                });
            }
        });
    }

    public openRejectDialog(): void {
        const dialogRef = this.dialog.open(SfDialogRejectDocument);
        dialogRef.afterClosed().subscribe(result => {
            if (result.event == DocumentProcessUtil.REJECT) {
                this.rejectDocument();
            }
        })
    }

    private rejectDocument(): void {
        const rejection: SfDocumentApproval = {processId: this.processId, approve: false};

        this.signingProcessService.approve(rejection).subscribe({
            next: data => {
                this.snackbar.open("Document rejected", undefined, {
                    duration: 5 * 1000
                });
                this.router.navigate(['/signfluent/documents']);
            },
            error: error => {
                this.snackbar.open("Unable to reject document", undefined, {
                    duration: 5 * 1000
                });
            }
        });;
    }
}
import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { SfDialogRejectDocument } from "../dialogs/sf-dialog-reject-document.component";
import { MatDialog } from "@angular/material/dialog";
import { SfUser } from "src/app/modules/core/models/sf-user";
import { DocumentSigningProcessService } from "../../services/document-signing-process.service";
import { ActivatedRoute, Router } from "@angular/router";
import { SfDocument } from "../../model/sf-document";
import { SfApproverOrder } from "../../model/sf-approver-order";
import { SfDocumentDelegation } from "../../model/sf-document-delegation";
import { SfDocumentInspection } from "../../model/sf-document-inspection";
import { MatSnackBar } from "@angular/material/snack-bar";
import { DocumentProcessUtil } from "../../constants/document-process-util";

@Component({
    selector: 'sf-documents-delegate',
    templateUrl: './sf-documents-delegate.component.html',
    styleUrls: ['./sf-documents-delegate.component.scss'],
})

export class SfDocumentsDelegateComponent {
    public validForm!: FormGroup;
    public validOrderForm!: FormGroup;

    public document!: SfDocument;
    public approvers!: SfUser[];
    public assigned: SfUser[] = [];

    private processId!: string;

    constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, public dialog: MatDialog, private signingProcessService: DocumentSigningProcessService, private snackbar: MatSnackBar, private router: Router) {

    }

    public ngOnInit() {
        this.validForm = this.formBuilder.group({
            valid: [false, Validators.requiredTrue]
        })
        this.validOrderForm = this.formBuilder.group({
            validOrder: [false, Validators.requiredTrue]
        })


        this.getDocumentDetails();
        this.getActiveApprovers();
    }

    public getActiveApprovers() {
        this.signingProcessService.getActiveApprovers().subscribe(activeApprovers => this.approvers = activeApprovers);
    }

    public drop(event: CdkDragDrop<SfUser[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data,
                event.container.data,
                event.previousIndex,
                event.currentIndex);
        }
    }

    private getDocumentDetails() {
        const processId = String(this.route.snapshot.paramMap.get('processId'))
        this.processId = processId;
        this.signingProcessService.get(processId).subscribe(document => {
            this.document = document;
        });
    }

    public inspectDocument() {
        const inspection: SfDocumentInspection = { processId: this.processId, isValid: this.validForm.valid };

        this.signingProcessService.inspect(inspection).subscribe();
    }

    public rejectDocument() {
        const rejection: SfDocumentInspection = { processId: this.processId, isValid: false };

        this.signingProcessService.inspect(rejection).subscribe({
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
        });
    }


    public delegateDocument() {
        const delegation: SfDocumentDelegation = { processId: this.processId, approvers: this.orderApprovers() };

        this.signingProcessService.delegate(delegation).subscribe({
            next: data => {
                this.snackbar.open("Document sucessfully delegated", undefined, {
                    duration: 5 * 1000
                });
                this.router.navigate(['/signfluent/documents']);
            },
            error: error => {
                this.snackbar.open("Unable to delegate document", undefined, {
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

    private orderApprovers() {
        return this.assigned.map((assigne, index) => {
            const approverId = assigne.id;
            const approver: SfApproverOrder = { approverId: approverId, order: index }
            return approver;
        })
    }

}

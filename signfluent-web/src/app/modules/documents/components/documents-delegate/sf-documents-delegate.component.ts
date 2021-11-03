import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { SfDelegateRejectComponent } from "./dialogs/sf-delegate-reject.component";
import { MatDialog } from "@angular/material/dialog";
import { UserService } from "src/app/modules/core/services/user.service";
import { SfUser } from "src/app/modules/core/models/sf-user";
import { DocumentService } from "../../services/document.service";
import { ActivatedRoute } from "@angular/router";
import { SfDocument } from "../../model/sf-document";
import { SfApproverOrder } from "../../model/sf-approver-order";
import { SfDocumentInspection } from "../../model/sf-document-inspection";
import { MatSnackBar } from "@angular/material/snack-bar";

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

    private taskId!: string;

    constructor(private route: ActivatedRoute, private formBuilder: FormBuilder, public dialog: MatDialog, private userService: UserService, private documentService: DocumentService, private snackbar: MatSnackBar) { }

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
        this.userService.getActiveApprovers().subscribe(activeApprovers => this.approvers = activeApprovers);
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
        const taskId = String(this.route.snapshot.paramMap.get('taskId'))
        this.taskId = taskId;
        this.documentService.get(taskId).subscribe(document => {
            this.document = document;
        });
    }


    public delegateDocument() {
        const orderedApprovers = this.orderApprovers();
        const isValid = this.validForm.valid;
        const delegatorId = "cba00e70-29e2-4dc3-a0ae-6d9c983358ed"

        const documentInspection: SfDocumentInspection = { taskId: this.taskId, isValid: isValid, delegatorId: delegatorId, approvers: orderedApprovers };

        this.documentService.delegate(documentInspection).subscribe({
            next: data => {
                this.snackbar.open("Document sucessfully delegated", undefined, {
                    duration: 5 * 1000
                });
            },
            error: error => {
                console.error(error);
                this.snackbar.open("Unable to delegate document", undefined, {
                    duration: 5 * 1000
                });
            }
        });
    }

    public openRejectDialog(): void {
        this.dialog.open(SfDelegateRejectComponent)
    }

    private orderApprovers() {
        return this.assigned.map((assigne, index) => {
            const approverId = assigne.userId;
            const approver: SfApproverOrder = { approverId: approverId, order: index }
            return approver;
        })
    }

}

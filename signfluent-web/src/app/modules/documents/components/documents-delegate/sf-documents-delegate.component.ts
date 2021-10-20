import { Component } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { SfDelegateRejectComponent } from "./dialogs/sf-delegate-reject.component";
import { MatDialog } from "@angular/material/dialog";

@Component({
    selector: 'sf-documents-delegate',
    templateUrl: './sf-documents-delegate.component.html',
    styleUrls: ['./sf-documents-delegate.component.scss'],
})

export class SfDocumentsDelegateComponent {
    validForm: FormGroup;
    validOrderForm: FormGroup;

    approvers: string[] = ['Angel', 'Dorcia', 'Gicu', 'David'];
    assigned: string[] = [];

    constructor(private formBuilder: FormBuilder, public dialog: MatDialog) { }

    ngOnInit() {
        this.validForm = this.formBuilder.group({
            valid: [false, Validators.requiredTrue]
        })
        this.validOrderForm = this.formBuilder.group({
            validOrder: [false, Validators.requiredTrue]
        })
    }

    resetOrderForm() {
        this.validOrderForm.reset()
    }

    drop(event: CdkDragDrop<string[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            transferArrayItem(event.previousContainer.data,
                event.container.data,
                event.previousIndex,
                event.currentIndex);
        }
    }

    public openRejectDialog(): void {
        this.dialog.open(SfDelegateRejectComponent)
    }

}
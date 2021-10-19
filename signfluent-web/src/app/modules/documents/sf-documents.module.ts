import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";
import { SignfluentDocumentsRoutingModule } from "./sf-documents-routing.module";
import { ReactiveFormsModule } from "@angular/forms";
import { DragDropModule } from '@angular/cdk/drag-drop';

import { MatTableModule } from "@angular/material/table";
import { MatTabsModule } from '@angular/material/tabs';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from "@angular/material/button";
import { MatStepperModule } from '@angular/material/stepper';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatDialogModule } from "@angular/material/dialog";
import { MatCardModule } from '@angular/material/card';

import { SfDocumentsComponent } from "./sf-documents.component";
import { SfDocumentsDelegateComponent } from "./documents-delegate/sf-documents-delegate.component";
import { SfDocumentsListComponent } from "./documents-list/sf-documents-list.component";
import { SfDocumentDetailsComponent } from "./document-details/sf-document-details.component";
import { SfDelegateRejectComponent } from "./documents-delegate/dialogs/sf-delegate-reject.component";
import { SfDocumentsApproveComponent } from "./documents-approve/sf-documents-approve.component";

@NgModule({
    declarations: [SfDocumentsComponent, SfDocumentsListComponent, SfDocumentsApproveComponent, SfDocumentsDelegateComponent, SfDocumentDetailsComponent, SfDelegateRejectComponent],
    imports: [CommonModule, SignfluentDocumentsRoutingModule, ReactiveFormsModule, MatTableModule, MatTabsModule, MatPaginatorModule, MatFormFieldModule, MatInputModule, MatIconModule, MatMenuModule, MatButtonModule, MatStepperModule, MatCheckboxModule, DragDropModule, MatDialogModule, MatCardModule],
    exports: [SfDocumentsComponent]
})
export class SignfluentDocumentsModule { }
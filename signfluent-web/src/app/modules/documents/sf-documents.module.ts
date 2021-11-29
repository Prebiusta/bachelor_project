import { CommonModule, Location } from "@angular/common";
import { RouterModule } from "@angular/router";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
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
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";

import { SfDocumentsComponent } from "./sf-documents.component";
import { SfDocumentsDelegateComponent } from "./components/documents-delegate/sf-documents-delegate.component";
import { SfDocumentDetailsComponent } from "./components/document-details/sf-document-details.component";
import { SfDialogRejectDocument } from "./components/dialogs/sf-dialog-reject-document.component";
import { SfDocumentsApproveComponent } from "./components/documents-approve/sf-documents-approve.component";
import { SfDocumentUploadComponent } from "./components/document-upload/sf-document-upload.component";
import { SfDocumentsListComponent } from "./components/documents-list/sf-documents-list.component";

@NgModule({
    declarations: [SfDocumentsComponent, SfDocumentsApproveComponent, SfDocumentsDelegateComponent, SfDocumentDetailsComponent, SfDialogRejectDocument, SfDocumentUploadComponent, SfDocumentsListComponent],
    imports: [CommonModule, FormsModule, SignfluentDocumentsRoutingModule, RouterModule, ReactiveFormsModule, MatTableModule, MatTabsModule, MatPaginatorModule, MatFormFieldModule, MatInputModule, MatIconModule, MatMenuModule, MatButtonModule, MatStepperModule, MatCheckboxModule, DragDropModule, MatDialogModule, MatCardModule, MatSnackBarModule, MatProgressSpinnerModule],
    exports: [SfDocumentsComponent]
})
export class SignfluentDocumentsModule { }

import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { SfUsersComponent } from "./sf-users.component";
import { MatTabsModule } from "@angular/material/tabs";
import { SignfluentUsersRoutingModule } from "./sf-users-routing.module";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatButtonModule } from "@angular/material/button";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { MatSnackBarModule } from "@angular/material/snack-bar";
import { SfUsersCreateComponent } from "./components/users-create/sf-users-create.component";
import { MatTableModule } from '@angular/material/table';
import { SfUsersListComponent } from "./components/users-list/sf-users-list.component";
import { MatMenuModule } from "@angular/material/menu";
import { MatIconModule } from "@angular/material/icon";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatSortModule } from "@angular/material/sort";
import { SfUsersRoleManagementComponent } from "./components/users-role-management/sf-users-role-management.component";
import { DragDropModule } from '@angular/cdk/drag-drop';


@NgModule({
    imports: [CommonModule, RouterModule, MatTabsModule, SignfluentUsersRoutingModule, ReactiveFormsModule, MatFormFieldModule, MatInputModule, FormsModule, MatButtonModule, MatProgressSpinnerModule, MatSnackBarModule, MatTableModule, MatMenuModule, MatIconModule, MatPaginatorModule, MatSortModule, DragDropModule],
    declarations: [SfUsersComponent, SfUsersCreateComponent, SfUsersListComponent, SfUsersRoleManagementComponent],
    exports: [SfUsersComponent]
})
export class SignfluentUsersModule { }
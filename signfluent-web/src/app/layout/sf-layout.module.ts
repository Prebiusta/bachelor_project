import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

// Material imports
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

// Signfluent components
import { SfTopbarComponent } from "../layout/topbar/sf-topbar.component";
import { SfLogoutDialogComponent } from "./topbar/logout_dialog/sf-logout-dialog.component";


@NgModule({
    declarations:[SfTopbarComponent, SfLogoutDialogComponent],
    imports:[CommonModule, MatToolbarModule, MatGridListModule, MatIconModule, MatDialogModule, MatButtonModule],
    exports:[SfLogoutDialogComponent, SfTopbarComponent]
})
export class SignfluentLayoutModule {}
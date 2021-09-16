import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

// Material imports
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';

// Signfluent components
import { SfTopbarComponent } from "../layout/topbar/sf-topbar.component";
import { SfLogoutDialogComponent } from "./topbar/logout_dialog/sf-logout-dialog.component";
import { SfFooterComponent } from "./footer/sf-footer.component";


@NgModule({
    declarations:[SfTopbarComponent, SfLogoutDialogComponent, SfFooterComponent],
    imports:[CommonModule, MatToolbarModule, MatGridListModule, MatIconModule, MatDialogModule, MatButtonModule, MatMenuModule],
    exports:[SfTopbarComponent, SfFooterComponent]
})
export class SignfluentLayoutModule {}
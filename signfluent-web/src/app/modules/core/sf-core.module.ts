import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";

// Material imports
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';

// Signfluent components
import { SfTopbarComponent } from "../core/components/topbar/sf-topbar.component"
import { SfLogoutDialogComponent } from "../core/components/logout_dialog/sf-logout-dialog.component"
import { SfFooterComponent } from "../core/components/footer/sf-footer.component";
import { SfHomeComponent } from "./components/home/sf-home.component";
import { SignfluentCoreRoutingModule } from "./sf-core-routing.module";





@NgModule({
    declarations: [SfTopbarComponent, SfLogoutDialogComponent, SfFooterComponent, SfHomeComponent],
    imports: [CommonModule, SignfluentCoreRoutingModule, RouterModule, MatToolbarModule, MatGridListModule, MatIconModule, MatDialogModule, MatButtonModule, MatMenuModule],
    exports: [SfTopbarComponent, SfFooterComponent, SfHomeComponent]
})
export class SignfluentCoreModule { }
import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { SfAppSettingsComponent } from "./sf-app-settings.component";
import { SignfluentAppSettingsRoutingModule } from "./sf-app-settings-routing.module";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatButtonModule } from "@angular/material/button";
import { MatInputModule } from "@angular/material/input";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

@NgModule({
    imports: [CommonModule, RouterModule, SignfluentAppSettingsRoutingModule, MatFormFieldModule, MatButtonModule, MatInputModule, ReactiveFormsModule, FormsModule],
    declarations: [SfAppSettingsComponent],
    exports: [SfAppSettingsComponent]
})
export class SignfluentAppSettingsModule { }
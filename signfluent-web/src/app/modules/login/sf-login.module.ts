import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";
import { RouterModule } from "@angular/router";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";

// Material imports
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatCardModule } from "@angular/material/card";
import { MatInputModule } from "@angular/material/input";
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';


// Signfluent components
import { SfLoginComponent } from "./components/login/sf-login.component";
import { SignfluentLoginRoutingModule } from "./sf-login-routing.module";
import { MatButtonModule } from "@angular/material/button";








@NgModule({
    declarations: [SfLoginComponent],
    imports: [CommonModule, FormsModule, ReactiveFormsModule, SignfluentLoginRoutingModule, RouterModule, MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatProgressSpinnerModule],
})
export class SignfluentLoginModule { }
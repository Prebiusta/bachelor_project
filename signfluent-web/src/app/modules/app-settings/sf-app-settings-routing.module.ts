import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfAppSettingsComponent } from "./sf-app-settings.component";

const routes: Routes = [
    {
        path: '',
        component: SfAppSettingsComponent,
        pathMatch: 'full',
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentAppSettingsRoutingModule { }

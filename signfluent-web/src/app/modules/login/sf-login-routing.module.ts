import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfLoginComponent } from "./components/login/sf-login.component"

const routes: Routes = [
    {
        path: '',
        component: SfLoginComponent,
        pathMatch: 'full',
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentLoginRoutingModule { }

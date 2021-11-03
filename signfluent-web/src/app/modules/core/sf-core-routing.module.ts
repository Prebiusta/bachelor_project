import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfHomeComponent } from "./components/home/sf-home.component";

const routes: Routes = [
    {
        path: '',
        component: SfHomeComponent,
        children: [
            {
                pathMatch: 'full',
                path: '',
                redirectTo: 'documents',
            },
            {
                path: 'documents',
                loadChildren: () => import('../documents/sf-documents.module').then(m => m.SignfluentDocumentsModule),
            }
        ]
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentCoreRoutingModule { }

import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfDocumentsApproveComponent } from "./components/documents-approve/sf-documents-approve.component";
import { SfDocumentsDelegateComponent } from "./components/documents-delegate/sf-documents-delegate.component";
import { SfDocumentsComponent } from "./sf-documents.component";

const routes: Routes = [
    {
        path: '',
        component: SfDocumentsComponent,
        pathMatch: 'full',
    },
    {
        path: 'delegate/:processId',
        component: SfDocumentsDelegateComponent,
    },
    {
        path: 'approve/:processId',
        component: SfDocumentsApproveComponent,
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentDocumentsRoutingModule { }

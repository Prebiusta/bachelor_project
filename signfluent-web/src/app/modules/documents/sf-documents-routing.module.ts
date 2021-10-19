import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfDocumentsApproveComponent } from "./documents-approve/sf-documents-approve.component";
import { SfDocumentsDelegateComponent } from "./documents-delegate/sf-documents-delegate.component";
import { SfDocumentsComponent } from "./sf-documents.component";

const routes: Routes = [
    {
        path: '',
        component: SfDocumentsComponent
    },
    {
        path: 'delegate',
        component: SfDocumentsDelegateComponent
    },
    {
        path: 'approve',
        component: SfDocumentsApproveComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentDocumentsRoutingModule { }
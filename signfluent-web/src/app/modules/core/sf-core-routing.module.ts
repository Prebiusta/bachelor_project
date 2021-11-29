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
            },
            {
                path: 'accounts',
                loadChildren: () => import('../users/sf-users.module').then(m => m.SignfluentUsersModule),
            },
            {
                path: 'settings',
                loadChildren: () => import('../app-settings/sf-app-settings.module').then(m => m.SignfluentAppSettingsModule)
            }
        ]
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentCoreRoutingModule { }

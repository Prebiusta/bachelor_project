import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: 'documents',
    loadChildren: () => import('./modules/documents/sf-documents.module').then(m => m.SignfluentDocumentsModule)
  },
  {
    path: '',
    redirectTo: 'documents',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

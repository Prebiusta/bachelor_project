import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'signfluent/documents',
    pathMatch: 'full'
  },
  {
    path: 'signfluent',
    canActivate: [AuthGuard],
    loadChildren: () => import('./modules/core/sf-core.module').then(m => m.SignfluentCoreModule)
  },
  {
    path: 'login',
    loadChildren: () => import('./modules/login/sf-login.module').then(m => m.SignfluentLoginModule)
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

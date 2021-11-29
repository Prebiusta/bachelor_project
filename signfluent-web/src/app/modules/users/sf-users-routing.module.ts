import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { SfUsersComponent } from "./sf-users.component";
import { SfUsersRoleManagementComponent } from "./components/users-role-management/sf-users-role-management.component";

const routes: Routes = [
    {
        path: '',
        component: SfUsersComponent,
        pathMatch: 'full',
    },
    {
        path: 'role/:id',
        component: SfUsersRoleManagementComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class SignfluentUsersRoutingModule { }

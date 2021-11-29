import { Component } from "@angular/core";
import { MatSnackBar } from "@angular/material/snack-bar";
import { UserService } from "src/app/modules/users/services/sf-user.service";
import { SfUser } from "src/app/modules/core/models/sf-user";
import { ActivatedRoute, Router } from "@angular/router";
import { SfRole } from "../../../core/models/sf-role";
import { CdkDragDrop, moveItemInArray, transferArrayItem } from "@angular/cdk/drag-drop";
import { RoleService } from "../../services/sf-role.service";
import { mergeMap } from 'rxjs/operators';
import { Observable } from "rxjs";

@Component({
    selector: 'sf-users-role-management',
    templateUrl: './sf-users-role-management.component.html',
    styleUrls: ['./sf-users-role-management.component.scss']
})

export class SfUsersRoleManagementComponent {

    public isLoadingResults = false;
    public user!: SfUser;
    public assignedRoles: SfRole[] = [];
    public availableRoles: SfRole[] = [];
    public assignedListId = 'ASSIGNED_LIST';
    public availableListId = 'AVAILABLE_LIST';


    constructor(private userService: UserService, private snackbar: MatSnackBar, private route: ActivatedRoute, private roleService: RoleService, private router: Router) {
    }

    public ngOnInit(): void {
        this.getUserDetails();
    }

    public getUserDetails(): void {
        const userId = String(this.route.snapshot.paramMap.get('id'))
        this.userService.getUserDetails(userId).subscribe(user => {
            this.user = user;
        })
        this.roleService.getForUser(userId).pipe(
            mergeMap(assignedRoles => {
                this.assignedRoles = assignedRoles;
                return this.roleService.getAvailableRoles();
            })).subscribe(availableRoles => {
                this.availableRoles = availableRoles.filter(role => !this.assignedRoles.map(role => role.key).includes(role.key))
            });
    }

    public goToParent(): void {
        this.router.navigate(['signfluent/accounts']);
    }

    public drop(event: CdkDragDrop<SfRole[]>) {
        if (event.previousContainer === event.container) {
            moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
        } else {
            this.isLoadingResults = true;
            if (event.container.id == this.assignedListId) {
                this.assignRole(event.previousIndex).subscribe({
                    next: data => {
                        this.isLoadingResults = false;
                        transferArrayItem(event.previousContainer.data,
                            event.container.data,
                            event.previousIndex,
                            event.currentIndex);
                    },
                    error: error => {
                        this.isLoadingResults = false;
                        this.snackbar.open("Unable to assign role", undefined, {
                            duration: 5 * 1000
                        });
                    }
                });
            } else if (event.container.id == this.availableListId) {
                this.revokeRole(event.previousIndex).subscribe({
                    next: data => {
                        this.isLoadingResults = false;
                        transferArrayItem(event.previousContainer.data,
                            event.container.data,
                            event.previousIndex,
                            event.currentIndex);
                    },
                    error: error => {
                        this.isLoadingResults = false;
                        this.snackbar.open("Unable to revoke role", undefined, {
                            duration: 5 * 1000
                        });
                    }
                });
            }
        }
    }

    private assignRole(index: number): Observable<Object> {
        return this.roleService.assignRole(this.user.id, this.availableRoles[index].key);
    }

    private revokeRole(index: number): Observable<Object> {
        return this.roleService.revokeRole(this.user.id, this.assignedRoles[index].key);
    }

}
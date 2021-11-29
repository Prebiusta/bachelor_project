import { Component, OnInit } from "@angular/core";
import { MatDialog } from "@angular/material/dialog";
import { SfLogoutDialogComponent } from "../logout_dialog/sf-logout-dialog.component";
import { Router, RouterEvent } from "@angular/router";
import { filter } from "rxjs/operators";
import { SfRoles } from "src/app/modules/core/constants/sf-roles";
import { SessionService } from "../../services/sf-session.service";


@Component({
    selector: 'sf-topbar',
    templateUrl: './sf-topbar.component.html',
    styleUrls: ['./sf-topbar.component.scss']
})

export class SfTopbarComponent implements OnInit {

    navigatedModule: string = '';
    name: string = '';

    constructor(private router: Router, public dialog: MatDialog, private sessionService: SessionService) { 
        this.router.events.pipe(
            filter((e: any): e is RouterEvent => e instanceof RouterEvent)
        ).subscribe((e: RouterEvent) => {
            if (e.url.includes('documents')) {
                this.navigatedModule = 'Documents'
            }
            if (e.url.includes('accounts')) {
                this.navigatedModule = 'Accounts management'
            }
            if (e.url.includes('settings')) {
                this.navigatedModule = 'Process management'
            }
        });
    }

    public ngOnInit() {
        if (this.router.url.includes('documents')) {
            this.navigatedModule = 'Documents'
        }
        if (this.router.url.includes('accounts')) {
            this.navigatedModule = 'Accounts management'
        }
        if (this.router.url.includes('settings')) {
            this.navigatedModule = 'Process management'
        }
        this.sessionService.getCurrentUserDetails().subscribe(user => {
            this.name = `${user.firstName} ${user.lastName}`;
        })
    }


    public openLogoutDialog(): void {
        this.dialog.open(SfLogoutDialogComponent);
    }

    public isAdministrator(): boolean {
        return this.sessionService.hasRole(SfRoles.Administrator);
    }
}
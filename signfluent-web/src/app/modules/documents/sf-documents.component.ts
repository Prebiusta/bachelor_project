import { Component } from "@angular/core";
import { SfRoles } from "src/app/modules/core/constants/sf-roles";
import { DocumentListType } from "./constants/document-list-type";
import { SessionService } from "../core/services/sf-session.service";



@Component({
    selector: 'sf-documents',
    templateUrl: './sf-documents.component.html',
    styleUrls: ['./sf-documents.component.scss']
})

export class SfDocumentsComponent {

    listType = DocumentListType;

    public constructor(private sessionService: SessionService) {
    }

    ngOnInit() {

    }

    public isAdministrator(): boolean {
        return this.sessionService.hasRole(SfRoles.Administrator);
    }

    public isDelegator(): boolean {
        return this.sessionService.hasRole(SfRoles.Delegator);
    }

    public isApprover(): boolean {
        return this.sessionService.hasRole(SfRoles.Approver);
    }

}
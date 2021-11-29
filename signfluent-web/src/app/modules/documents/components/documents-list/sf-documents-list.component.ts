import { Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DocumentSigningProcessService } from '../../services/document-signing-process.service';
import { SfDocumentProcess } from "../../model/sf-document-process";
import { DocumentListType } from '../../constants/document-list-type';
import { DocumentService } from '../../services/document.service';
import { SfDocument } from '../../model/sf-document';
import { DocumentStatus } from '../../constants/document-status';
import { DocumentTranslations } from '../../constants/document-translations';

@Component({
    selector: 'sf-documents-list',
    styleUrls: ['sf-documents-list.component.scss'],
    templateUrl: './sf-documents-list.component.html'
})
export class SfDocumentsListComponent {
    dataSource!: MatTableDataSource<SfDocumentProcess | SfDocument>;

    @Input() type: string = '';
    documentListType = DocumentListType;
    documentStatusTypes = DocumentStatus;
    displayedColumns: string[] = [];
    isLoadingResults = false;
    private ALL = ['description', 'status', 'uploadedBy', 'date', 'action'];
    private OWN = ['description', 'status', 'date'];
    private DELEGATE = ['description', 'uploadedBy', 'date', 'action'];
    private APPROVAL = ['description', 'uploadedBy', 'date', 'action'];

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    constructor(private signingProcessService: DocumentSigningProcessService, private documentService: DocumentService) {
        this.dataSource = new MatTableDataSource<SfDocumentProcess | SfDocument>();
    }

    public ngOnInit() {
        this.isLoadingResults = true;
        if (this.type == DocumentListType.Delegator) {
            this.signingProcessService.getDocumentsForInspection().subscribe(documentTasks => {
                this.isLoadingResults = false;
                this.dataSource = new MatTableDataSource<SfDocumentProcess | SfDocument>(documentTasks);
                this.displayedColumns = this.DELEGATE;
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
            });
        } else if (this.type == DocumentListType.Approver) {
            this.signingProcessService.getDocumentsForApproval().subscribe(documentTasks => {
                this.isLoadingResults = false;
                this.dataSource = new MatTableDataSource<SfDocumentProcess | SfDocument>(documentTasks);
                this.displayedColumns = this.APPROVAL;
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
            });
        }
        else if (this.type == DocumentListType.Administrator) {
            this.documentService.getAllDocuments().subscribe(documents => {
                this.isLoadingResults = false;
                this.dataSource = new MatTableDataSource<SfDocumentProcess | SfDocument>(documents);
                this.displayedColumns = this.ALL;
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
            });
        }
        else if (this.type == DocumentListType.Own) {
            this.documentService.getOwnDocuments().subscribe(documents => {
                this.isLoadingResults = false;
                this.dataSource = new MatTableDataSource<SfDocumentProcess | SfDocument>(documents);
                this.displayedColumns = this.OWN;
                this.dataSource.paginator = this.paginator;
                this.dataSource.sort = this.sort;
            })
        }
    }

    public applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }

    public translateDocumentStatus(status: string): string {
        if (status == DocumentStatus.APPROVED) {
            return DocumentTranslations.STATUS_APPROVED;
        } else if (status == DocumentStatus.FOR_APPROVAL) {
            return DocumentTranslations.STATUS_FOR_APPROVAL;
        } else if (status == DocumentStatus.RECEIVED) {
            return DocumentTranslations.STATUS_RECEIVED;
        } else if (status == DocumentStatus.REJECTED) {
            return DocumentTranslations.STATUS_REJECTED;
        } else {
            return 'UNKNOWN'
        }
    }

}

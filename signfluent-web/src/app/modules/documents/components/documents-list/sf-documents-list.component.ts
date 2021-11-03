import { AfterViewInit, Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DocumentService } from '../../services/document.service';
import {SfDocumentTask} from "../../model/sf-document-task";

@Component({
    selector: 'sf-documents-list',
    styleUrls: ['sf-documents-list.component.scss'],
    templateUrl: './sf-documents-list.component.html'
})
export class SfDocumentsListComponent implements AfterViewInit {
    dataSource!: MatTableDataSource<SfDocumentTask>;

    @Input() type: string = '';
    displayedColumns: string[] = [];
    private ALL = ['description', 'status', 'uploadedBy', 'date'];
    private OWN = ['description', 'status', 'date'];
    private DELEGATE = ['description', 'uploadedBy', 'date', 'action'];
    private APPROVAL = ['description', 'uploadedBy', 'date', 'action'];

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    constructor(private documentService: DocumentService) {
      this.dataSource = new MatTableDataSource<SfDocumentTask>();
    }

    public ngOnInit() {
        if (this.type == 'OWN') {
            this.displayedColumns = this.OWN;
        } else if (this.type == 'ALL') {
            this.displayedColumns = this.ALL;
        } else if (this.type == 'DELEGATE') {
            this.documentService.getDocuments('DELEGATE').subscribe(documentTasks => {
              console.log(documentTasks);
              this.dataSource = new MatTableDataSource<SfDocumentTask>(documentTasks);
            });
            this.displayedColumns = this.DELEGATE;
        } else if (this.type == 'APPROVAL') {
            this.displayedColumns = this.APPROVAL;
        }
    }

    public ngAfterViewInit() {
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    }

    public applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }
}

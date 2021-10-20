import { AfterViewInit, Component, Input, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { SfDocument } from '../../model/sf-document';

const DOCUMENT_DATA: SfDocument[] = [
    { description: 'Am so good so I need Money', status: 'Received', uploadedBy: 'Gicu', date: new Date() },
    { description: 'Angular sucks!', status: 'Approved', uploadedBy: 'David', date: new Date() },
    { description: 'I love Camunda!', status: 'For Approval', uploadedBy: 'Dorcia', date: new Date() },
    { description: 'Please killmyself!', status: 'Rejected', uploadedBy: 'Angel', date: new Date() },
    { description: 'Am so good so I need Money', status: 'Received', uploadedBy: 'Gicu', date: new Date() },
    { description: 'Angular sucks!', status: 'Received', uploadedBy: 'David', date: new Date() },
    { description: 'I love Camunda!', status: 'Received', uploadedBy: 'Dorcia', date: new Date() },
    { description: 'Please killmyself!', status: 'Received', uploadedBy: 'Angel', date: new Date() },
    { description: 'Am so good so I need Money', status: 'For Approval', uploadedBy: 'Gicu', date: new Date() },
    { description: 'Angular sucks!', status: 'Received', uploadedBy: 'David', date: new Date() },
    { description: 'I love Camunda!', status: 'Received', uploadedBy: 'Dorcia', date: new Date() },
    { description: 'Please killmyself!', status: 'Received', uploadedBy: 'Angel', date: new Date() }
]
@Component({
    selector: 'sf-documents-list',
    styleUrls: ['sf-documents-list.component.scss'],
    templateUrl: './sf-documents-list.component.html'
})
export class SfDocumentsListComponent implements AfterViewInit {
    dataSource: MatTableDataSource<SfDocument>;

    @Input() type: string = '';
    displayedColumns: string[] = [];
    private ALL = ['description', 'status', 'uploadedBy', 'date'];
    private OWN = ['description', 'status', 'date'];
    private DELEGATE = ['description', 'uploadedBy', 'date', 'action'];
    private APPROVAL = ['description', 'uploadedBy', 'date', 'action'];

    @ViewChild(MatPaginator) paginator: MatPaginator;
    @ViewChild(MatSort) sort: MatSort;

    constructor() {
        this.dataSource = new MatTableDataSource(DOCUMENT_DATA);
    }

    ngOnInit() {
        if (this.type == 'OWN') {
            this.displayedColumns = this.OWN;
        } else if (this.type == 'ALL') {
            this.displayedColumns = this.ALL;
        } else if (this.type =='DELEGATE') {
            this.displayedColumns = this.DELEGATE;
        } else if (this.type ==  'APPROVAL') {
            this.displayedColumns = this.APPROVAL;
        }
    }

    ngAfterViewInit() {
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
    }

    applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }
}
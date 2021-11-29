import { Component } from "@angular/core";
import { MatTableDataSource } from "@angular/material/table";
import { SfUser } from "src/app/modules/core/models/sf-user";
import { ViewChild } from "@angular/core";
import { MatPaginator } from "@angular/material/paginator";
import { MatSort } from "@angular/material/sort";
import { UserService } from "../../services/sf-user.service";

@Component({
    selector: 'sf-users-list',
    templateUrl: './sf-users-list.component.html',
    styleUrls: ['./sf-users-list.component.scss']
})
export class SfUsersListComponent {

    public dataSource!: MatTableDataSource<SfUser>;
    public displayedColumns: string[] = ['username','name','email','action'];
    public isLoadingResults: boolean = false;

    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    constructor(private userService: UserService) {

    }

    public ngOnInit(): void {
        this.isLoadingResults = true;
        this.userService.getAllUsers().subscribe(users => {
            this.isLoadingResults = false;
            this.dataSource = new MatTableDataSource<SfUser>(users);
            this.dataSource.paginator = this.paginator;
            this.dataSource.sort = this.sort;
        })
    }

    public applyFilter(event: Event) {
        const filterValue = (event.target as HTMLInputElement).value;
        this.dataSource.filter = filterValue.trim().toLowerCase();

        if (this.dataSource.paginator) {
            this.dataSource.paginator.firstPage();
        }
    }


}
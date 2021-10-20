import { Component } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { DocumentUploadService } from "../../services/document-upload.service";
@Component({
    selector: 'sf-document-upload',
    templateUrl: './sf-document-upload.component.html',
    styleUrls: ['./sf-document-upload.component.scss']
})

export class SfDocumentUploadComponent {
    
    public description = '';
    private file: File;

    constructor(public uploadDocumentService: DocumentUploadService) {}

    public onFileSelected(event: any): void {
        this.file = event.target.files[0];
    }

    public onUpload(): void {
        this.uploadDocumentService.upload(this.file, this.description)
    }
}

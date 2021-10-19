import { Component } from "@angular/core";
import { SfDocument } from "../model/sf-document";



@Component({
    selector: 'sf-document-details',
    templateUrl: './sf-document-details.component.html',
    styleUrls: ['./sf-document-details.component.scss']
})

export class SfDocumentDetailsComponent {

    document: SfDocument = { description: 'Am so good so I need Money', status: 'Received', uploadedBy: 'Gicu', date: new Date() }

    downloadMyFile() {
        const link = document.createElement('a');
        link.setAttribute('target', '_blank');
        link.setAttribute('href', '../../../../assets/Signfluent test PDF.pdf');
        link.setAttribute('download', `Signfluent test PDF.pdf`);
        document.body.appendChild(link);
        link.click();
        link.remove();
    }

}
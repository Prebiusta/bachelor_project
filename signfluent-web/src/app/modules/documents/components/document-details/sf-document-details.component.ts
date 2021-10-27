import {Component, Input} from "@angular/core";
import {DocumentService} from "../../services/document.service";
import {ActivatedRoute} from "@angular/router";
import {SfDocument} from "../../model/sf-document";


@Component({
  selector: 'sf-document-details',
  templateUrl: './sf-document-details.component.html',
  styleUrls: ['./sf-document-details.component.scss']
})

export class SfDocumentDetailsComponent {

  @Input() public document!: SfDocument;

  constructor(private documentService: DocumentService, private route: ActivatedRoute) {
  }

  public downloadMyFile() {
    const link = document.createElement('a');
    link.setAttribute('target', '_blank');
    link.setAttribute('href', '../../../../assets/Signfluent test PDF.pdf');
    link.setAttribute('download', `Signfluent test PDF.pdf`);
    document.body.appendChild(link);
    link.click();
    link.remove();
  }

}

import { Component, Input } from "@angular/core";
import { SfDocument } from "../../model/sf-document";


@Component({
  selector: 'sf-document-details',
  templateUrl: './sf-document-details.component.html',
  styleUrls: ['./sf-document-details.component.scss']
})

export class SfDocumentDetailsComponent {

  @Input() public document?: SfDocument;

  constructor() { }

  public download() {
      const source = `data:application/pdf;base64,${this.document?.content}`;
      const link = document.createElement("a");
      link.href = source;
      link.download = `Document.pdf`
      link.click();
      link.remove();
  }
}

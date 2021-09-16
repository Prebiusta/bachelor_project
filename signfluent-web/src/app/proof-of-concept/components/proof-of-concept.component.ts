import { Component, OnInit } from '@angular/core';
import { ProofOfConceptService } from '../services/proof-of-concept.service';

@Component({
  selector: 'app-proof-of-concept',
  templateUrl: '../views/proof-of-concept.component.html'
})
export class ProofOfConceptComponent implements OnInit {

  public taskId: string = '';
  public documentId: string = '';
  public document: any = '';

  constructor(private proofOfConceptService: ProofOfConceptService) { }

  ngOnInit(): void {

  }

  public uploadDocumentIdentifier(): void {
    this.proofOfConceptService.uploadDocumentIdentifier(this.taskId, this.documentId);
  }

  public fetchDocument(): void {
    this.proofOfConceptService.fetchDocument(this.taskId).subscribe(document => this.document = document);
  }

}

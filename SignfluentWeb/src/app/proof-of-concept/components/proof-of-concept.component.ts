import { Component, OnInit } from '@angular/core';
import { ProofOfConceptService } from '../services/proof-of-concept.service';

@Component({
  selector: 'app-proof-of-concept',
  templateUrl: '../views/proof-of-concept.component.html'
})
export class ProofOfConceptComponent implements OnInit {

  public pocResponse: string = 'something';
  public documentId: string = "8a4ead3a-1609-11ec-9621-0242ac130002";
  public document: any = '';

  constructor(private proofOfConceptService: ProofOfConceptService) { }

  ngOnInit(): void {
    this.getPocResponse();
  }

  public getPocResponse(): void {
    this.proofOfConceptService.getPocResponse().subscribe(value => this.pocResponse = value);
  }

  public onSendDocumentId(): void {
    this.proofOfConceptService.sendDocumentId(this.documentId);
  }

  public fetchDocument(): void {
    this.proofOfConceptService.fetchDocument().subscribe(document => this.document = document);
  }

}

import { Component, OnInit } from '@angular/core';
import { ProofOfConceptService } from '../services/proof-of-concept.service';

@Component({
  selector: 'app-proof-of-concept',
  templateUrl: '../views/proof-of-concept.component.html'
})
export class ProofOfConceptComponent implements OnInit {

  public pocResponse: string = 'something';

  constructor(private proofOfConceptService: ProofOfConceptService) { }

  ngOnInit(): void {
    this.getPocResponse();
  }

  public getPocResponse(): void {
    this.proofOfConceptService.getPocResponse().subscribe(value => this.pocResponse = value);
  }

}

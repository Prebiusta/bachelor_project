import { TestBed } from '@angular/core/testing';

import { ProofOfConceptService } from './proof-of-concept.service';

describe('ProofOfConceptService', () => {
  let service: ProofOfConceptService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProofOfConceptService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

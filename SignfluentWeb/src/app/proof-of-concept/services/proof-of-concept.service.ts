import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProofOfConceptService {

  private url: string = '';

  constructor(private http: HttpClient) { }

  public getPocResponse(): Observable<any> {
    return this.http.get<any>(this.url).pipe(
      catchError(error => of('error encountered, provide URL'))
    );
  }
}

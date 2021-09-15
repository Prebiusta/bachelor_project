import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProofOfConceptService {

  private url: string = '';
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  public getPocResponse(): Observable<any> {
    return this.http.get<any>(this.url).pipe(
      catchError(error => of('error encountered, provide URL'))
    );
  }

  public fetchDocument(): Observable<any> {
    return this.http.get<any>(this.url).pipe(
      catchError(error => of('cant fetch document provide URL'))
    );
  }

  public sendDocumentId(documentId: string): Observable<string> {
    return this.http.post<string>(this.url, documentId, this.httpOptions).pipe(
      tap(_ => console.log(`sent document id=${documentId}`))
      );
  }
}

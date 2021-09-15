import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProofOfConceptService {

  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  public fetchDocument(taskId: string): Observable<any> {
    return this.http.post<any>(`http://localhost:8181/retrieve/${taskId}`,'',this.httpOptions);
  }

  public uploadDocumentIdentifier(taskId: string, documetId: string): void {
    this.http.post<string>(`http://localhost:8181/upload/${taskId}/${documetId}`, '', this.httpOptions).subscribe(response => response);
  }
}

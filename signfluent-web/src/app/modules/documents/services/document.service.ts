import { Injectable } from "@angular/core";
import { HttpRequestService } from "../../core/services/http-request.service";
import { SfDocument } from "../model/sf-document";


@Injectable({
  providedIn: 'root',
})
export class DocumentService {
  constructor(private http: HttpRequestService) {
  }

  public getAllDocuments() {
      return this.http.postType<SfDocument[]>("api/document/getAll", undefined);
  }

  public getOwnDocuments() {
    return this.http.postType<SfDocument[]>("api/document/getOwn", undefined);
}



}

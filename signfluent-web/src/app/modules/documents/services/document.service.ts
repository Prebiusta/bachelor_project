import {Injectable} from "@angular/core";
import {HttpRequestService} from "../../core/services/http-request.service";
import {SfDocument} from "../model/sf-document";
import { SfDocumentInspection } from "../model/sf-document-inspection";
import {SfDocumentTask} from "../model/sf-document-task";

@Injectable({
  providedIn: 'root',
})
export class DocumentService {
  constructor(private http: HttpRequestService) {
  }

  public upload(request: any) {
    console.log(request);
    return this.http.post("/api/signingProcess/uploadDocument", request);
  }

  public getDocuments(type: string) {
    return this.http.postType<SfDocumentTask[]>("api/signingProcess/getDocumentsForInspection", undefined);
  }

  public get(taskId: string) {
    const request = {taskId: taskId};

    return this.http.postType<SfDocument>("/api/signingProcess/getDocumentDetails", request);
  }

  public delegate(documentInspection: SfDocumentInspection) {
    console.log(documentInspection);
    return this.http.post("/api/signingProcess/getActiveApprovers", documentInspection);
  }
}

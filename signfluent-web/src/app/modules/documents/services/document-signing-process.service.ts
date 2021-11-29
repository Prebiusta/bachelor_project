import { Injectable } from "@angular/core";
import { HttpRequestService } from "../../core/services/http-request.service";
import { SfDocument } from "../model/sf-document";
import { SfDocumentInspection } from "../model/sf-document-inspection";
import { SfDocumentDelegation } from "../model/sf-document-delegation";
import { SfDocumentProcess } from "../model/sf-document-process";
import { SfDocumentApproval } from "../model/sf-document-approval";
import { SfUser } from "../../core/models/sf-user";

@Injectable({
  providedIn: 'root',
})
export class DocumentSigningProcessService {
  constructor(private http: HttpRequestService) {
  }

  public upload(request: any) {
    return this.http.post("api/signingProcess/uploadDocument", request);
  }

  public getDocumentsForInspection() {
    return this.http.postType<SfDocumentProcess[]>("api/signingProcess/getDocumentsForInspection", undefined);
  }

  public getDocumentsForApproval() {
    return this.http.postType<SfDocumentProcess[]>("api/signingProcess/getDocumentsForApproval", undefined);
  }

  public get(processId: string) {
    const request = { processId: processId };
    console.log(processId);
    return this.http.postType<SfDocument>("api/signingProcess/getDocumentDetails", request);
  }

  public delegate(delegation: SfDocumentDelegation) {
    return this.http.post("api/signingProcess/assignApprovers", delegation);
  }

  public inspect(inspection: SfDocumentInspection) {
    return this.http.post("api/signingProcess/inspectDocument", inspection);
  }

  public approve(approval: SfDocumentApproval) {
    return this.http.post("api/signingProcess/approveDocument", approval);
  }

  public getActiveApprovers(){
    return this.http.postType<SfUser[]>("api/signingProcess/getActiveApprovers", {});
}
}

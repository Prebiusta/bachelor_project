import { Injectable } from "@angular/core";
import { HttpRequestService } from "../../core/services/http-request.service";

@Injectable({
    providedIn: 'root',
})
export class DocumentUploadService {
    constructor(private http: HttpRequestService) { }

    public upload(file: any, description: string) {
        const formData = new FormData();

        formData.append("userId", "4da64240-b567-44fc-98c7-5d1f91cb9982");
        formData.append("document", file);
        formData.append("description", description);

        return this.http.put("api/signingProcess/uploadDocument", formData)
    }
}
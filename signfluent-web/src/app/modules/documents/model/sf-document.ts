import { SfUser } from "../../core/models/sf-user";

export interface SfDocument {
  documentId?: string,
  description: string,
  status: string,
  uploadedBy: SfUser,
  uploadedAt: Date,
  content?: File
}

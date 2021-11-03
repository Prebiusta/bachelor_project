export interface SfDocument {
  description: string,
  status: string,
  uploadedBy: string,
  uploadedAt: Date,
  content?: File
}

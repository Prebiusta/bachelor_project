import { SfApproverOrder } from "./sf-approver-order";

export interface SfDocumentInspection {
    taskId: string,
    isValid: boolean,
    delegatorId: string,
    approvers: SfApproverOrder[];
}
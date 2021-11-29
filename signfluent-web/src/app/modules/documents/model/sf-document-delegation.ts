import { SfApproverOrder } from "./sf-approver-order";

export interface SfDocumentDelegation {
    processId: string,
    approvers: SfApproverOrder[];
}
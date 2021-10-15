package dk.signfluent.service.document.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ApprovalOrderModel {
    private UUID approverId;
    private int order;
}

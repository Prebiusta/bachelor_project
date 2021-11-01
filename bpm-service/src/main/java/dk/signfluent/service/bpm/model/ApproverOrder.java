package dk.signfluent.service.bpm.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApproverOrder implements Serializable {
    private String approverId;
    private int order;
}

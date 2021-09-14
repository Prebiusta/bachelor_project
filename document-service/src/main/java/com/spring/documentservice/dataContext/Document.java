package com.spring.documentservice.dataContext;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String content;
    @ElementCollection
    private List<String> signatures;

    public Document(String content, List<String> signatures) {
        this.content = content;
        this.signatures = signatures;
    }
}

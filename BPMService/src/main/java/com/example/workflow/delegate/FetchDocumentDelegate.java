package com.example.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
public class FetchDocumentDelegate implements JavaDelegate
{
    HttpClient client = HttpClient.newHttpClient();

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String documentid = (String) delegateExecution.getVariable("DOCUMENTID");
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/getDocument?id=6d66af48-0334-4f3f-9a61-9009673c28cb"))
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        Object document = response.body();
        delegateExecution.setVariable("DOCUMENT",document);
    }
}

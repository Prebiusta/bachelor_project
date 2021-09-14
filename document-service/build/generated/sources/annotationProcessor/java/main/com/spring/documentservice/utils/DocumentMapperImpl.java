package com.spring.documentservice.utils;

import com.spring.documentservice.dataContext.Document;
import com.spring.documentservice.models.DocumentReturnModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-09-14T19:33:58+0200",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.1.jar, environment: Java 11.0.2 (Oracle Corporation)"
)
public class DocumentMapperImpl implements DocumentMapper {

    @Override
    public DocumentReturnModel sourceToDestination(Document source) {
        if ( source == null ) {
            return null;
        }

        DocumentReturnModel documentReturnModel = new DocumentReturnModel();

        documentReturnModel.setContent( source.getContent() );

        return documentReturnModel;
    }
}

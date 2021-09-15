package com.spring.documentservice.utils;

import com.spring.documentservice.dataContext.Document;
import com.spring.documentservice.models.DocumentReturnModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DocumentMapper {

    DocumentReturnModel sourceToDestination(Document source);
}

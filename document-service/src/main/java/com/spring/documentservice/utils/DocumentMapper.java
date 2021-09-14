package com.spring.documentservice.utils;

import com.spring.documentservice.dataContext.Document;
import com.spring.documentservice.models.DocumentReturnModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper( DocumentMapper.class );

    DocumentReturnModel sourceToDestination(Document source);
}

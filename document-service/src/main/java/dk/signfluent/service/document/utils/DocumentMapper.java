package dk.signfluent.service.document.utils;

import dk.signfluent.service.document.entity.DocumentEntity;
import dk.signfluent.service.document.model.DocumentReturnModel;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface DocumentMapper {
    DocumentReturnModel sourceToDestination(DocumentEntity source);
}

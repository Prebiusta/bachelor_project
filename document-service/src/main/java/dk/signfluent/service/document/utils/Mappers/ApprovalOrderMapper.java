package dk.signfluent.service.document.utils.Mappers;

import dk.signfluent.service.document.entity.ApprovalOrder;
import dk.signfluent.service.document.model.ApprovalOrderModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApprovalOrderMapper {
    @Mapping(source = "order", target = "myOrder")
    List<ApprovalOrder> modelToEntity(List<ApprovalOrderModel> source);

    default ApprovalOrder map(ApprovalOrderModel source) {
        ApprovalOrder approver = new ApprovalOrder();
        approver.setApprovingOrder(source.getOrder());
        approver.setApproverId(source.getApproverId());

        return approver;
    }
}

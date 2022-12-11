package br.imd.distprog.finance.dto.buyorder;

import br.imd.distprog.finance.model.BuyOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuyOrderMapper {

    BuyOrderMapper INSTANCE = Mappers.getMapper(BuyOrderMapper.class);

    BuyOrder postRequestBodyToBuyOrder(BuyOrderPostRequestBody buyOrderPostRequestBody);

    BuyOrder putRequestBodyToBuyOrder(BuyOrderPutRequestBody buyOrderPutRequestBody);

    BuyOrderPostRequestBody buyOrderToPostRequestBody(BuyOrder buyOrder);

    BuyOrderPutRequestBody buyOrderToPutRequestBody(BuyOrder buyOrder);
}

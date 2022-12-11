package br.imd.distprog.finance.dto.billpayable;

import br.imd.distprog.finance.model.BillPayable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillPayableMapper {

    BillPayableMapper INSTANCE = Mappers.getMapper(BillPayableMapper.class);

    BillPayable postRequestBodyToBillPayable(BillPayablePostRequestBody billPayablePostRequestBody);

    BillPayable putRequestBodyToBillPayable(BillPayablePutRequestBody billPayablePutRequestBody);

}

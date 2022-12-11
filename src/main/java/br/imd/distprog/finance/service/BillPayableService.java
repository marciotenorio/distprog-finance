package br.imd.distprog.finance.service;

import br.imd.distprog.finance.BillPayableRepository;
import br.imd.distprog.finance.client.ProcurementClient;
import br.imd.distprog.finance.dto.billpayable.BillPayableMapper;
import br.imd.distprog.finance.dto.billpayable.BillPayablePostRequestBody;
import br.imd.distprog.finance.dto.billpayable.BillPayablePutRequestBody;
import br.imd.distprog.finance.dto.buyorder.BuyOrderMapper;
import br.imd.distprog.finance.dto.buyorder.BuyOrderPutRequestBody;
import br.imd.distprog.finance.exception.BadRequestException;
import br.imd.distprog.finance.exception.InvalidFieldsException;
import br.imd.distprog.finance.model.BillPayable;
import br.imd.distprog.finance.model.BuyOrder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BillPayableService {

    private BillPayableRepository billPayableRepository;

    private ProcurementClient procurementClient;

    public List<BillPayable> findAll() {
        return billPayableRepository.findAll();
    }

    @Transactional
    public BillPayable save(BillPayablePostRequestBody billPayablePostRequestBody) {
        BuyOrder buyOrder = procurementClient.findBuyOrderById(billPayablePostRequestBody.getBuyOrderId());

        if(buyOrder.isApproved())
            throw new InvalidFieldsException("Buy order already paid.");

        BuyOrderPutRequestBody buyOrderPut = BuyOrderMapper.INSTANCE.buyOrderToPutRequestBody(buyOrder);
        buyOrderPut.setApproved(billPayablePostRequestBody.isPaid());
        procurementClient.replaceBuyOrder(buyOrderPut);

        BillPayable billPayable = BillPayableMapper.INSTANCE.postRequestBodyToBillPayable(billPayablePostRequestBody);

        return billPayableRepository.save(billPayable);
    }

    public void deleteById(Long id) {
        findByIdOrThrowBadRequestException(id);
        billPayableRepository.deleteById(id);
    }

    public void replace(BillPayablePutRequestBody billPayablePutRequestBody) {
        BillPayable incomingBillPayable = findByIdOrThrowBadRequestException(billPayablePutRequestBody.getId());
        BillPayable billPayable = BillPayableMapper.INSTANCE.putRequestBodyToBillPayable(billPayablePutRequestBody);
        billPayable.setId(incomingBillPayable.getId());
        billPayableRepository.save(billPayable);
    }

    public BillPayable findByIdOrThrowBadRequestException(Long id) {
        return billPayableRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Bill payable not found!"));
    }
}

package br.imd.distprog.finance.dto.billpayable;

import lombok.Data;

@Data
public class BillPayablePostRequestBody {

    private String justification;

    private Long buyOrderId;

    private boolean paid;
}

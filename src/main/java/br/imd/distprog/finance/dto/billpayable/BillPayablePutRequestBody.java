package br.imd.distprog.finance.dto.billpayable;

import lombok.Data;

@Data
public class BillPayablePutRequestBody {

    private Long id;

    private String justification;

    private Long buyOrderId;

    private boolean paid;
}

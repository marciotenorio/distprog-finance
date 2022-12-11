package br.imd.distprog.finance.dto.buyorder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyOrderPostRequestBody {

    private String description;

    private boolean isApproved;
}

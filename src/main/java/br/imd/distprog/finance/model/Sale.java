package br.imd.distprog.finance.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Sale {

    private Long id;

    private List<Long> productsId;

    private BigDecimal price;

}

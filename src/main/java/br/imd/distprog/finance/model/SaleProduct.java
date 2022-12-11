package br.imd.distprog.finance.model;

import lombok.Data;

import java.util.List;

@Data
public class SaleProduct {

    private Long id;

    private Long saleId;

    private Long productId;

    private List<Product> products;

    private List<Sale> sales;

}

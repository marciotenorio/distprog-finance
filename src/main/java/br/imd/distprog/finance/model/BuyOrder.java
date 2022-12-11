package br.imd.distprog.finance.model;

import lombok.Data;

@Data
public class BuyOrder {

    private Long id;

    private String description;

    private boolean isApproved;

}

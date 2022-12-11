package br.imd.distprog.finance.model;

import lombok.Data;

@Data
public class Vendor {

    private Long id;

    private String name;

    private VendorType type;

    private boolean isApproved;
}

package br.imd.distprog.finance.util;

public class Route {

    public static final String PROCUREMENT_SALES = "http://localhost:8081/sales";

    public static final String PROCUREMENT_BUY_ORDER = "http://localhost:8081/buy-orders";

    public static final String PROCUREMENT_BUY_ORDER_BY_ID = "http://localhost:8081/buy-orders/{id}";

    public static final String BILLS_PAYABLE = "/bills-payable";

    private Route(){}
}

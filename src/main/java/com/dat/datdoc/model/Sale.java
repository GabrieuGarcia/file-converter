package com.dat.datdoc.model;

import java.util.List;

public class Sale {

    public static final String SALE_CODE = "003";

    private String id;
    private List<SaleItem> salesItens;
    private String salesmanName;

    public static void processDocs(String s) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SaleItem> getSalesItens() {
        return salesItens;
    }

    public void setSalesItens(List<SaleItem> salesItens) {
        this.salesItens = salesItens;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

}

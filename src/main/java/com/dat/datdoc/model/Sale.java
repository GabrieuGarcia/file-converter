package com.dat.datdoc.model;

import java.util.List;

/**
 * @author Gabriel Fernandes Garcia
 */
public class Sale {

    public static final String SALE_CODE = "003";

    private String id;
    private List<SaleItem> saleItemList;
    private String salesmanName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SaleItem> getSaleItemList() {
        return saleItemList;
    }

    public void setSaleItemList(List<SaleItem> saleItemList) {
        this.saleItemList = saleItemList;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

}

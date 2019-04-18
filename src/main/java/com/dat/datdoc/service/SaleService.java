package com.dat.datdoc.service;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.model.Sale;
import com.dat.datdoc.model.SaleItem;

import java.math.BigDecimal;

public class SaleService {

    private static final String HIGHEST_SALE = "Maior venda: ";

    private final DocumentRead documentRead;
    private final SaleItemService saleItemService;

    public SaleService(DocumentRead documentRead, SaleItemService saleItemService) {
        this.documentRead = documentRead;
        this.saleItemService = saleItemService;
    }

    /**
     * Method responsible for get the Id of the highest Sale.
     *
     * @param documentRead documento that was read.
     * @return id of the biggest sale.
     */
    public String getIdHighestSale(DocumentRead documentRead) {
        String idBiggestSale = "";
        BigDecimal amount = new BigDecimal("0.0");
        BigDecimal biggestAmount = new BigDecimal("0.0");

        for (Sale sale : documentRead.getSaleList()) {
            for (SaleItem saleItem : sale.getSalesItens()) {
                amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getItemQuantity()))));
            }
            if (amount.compareTo(biggestAmount) == 1) {
                biggestAmount = amount;
                idBiggestSale = sale.getId();
            }
            amount = new BigDecimal(0.0);
        }
        return HIGHEST_SALE + idBiggestSale;
    }

    /**
     * Method responsible for set the infos comming from de document and set int the Sale and SaleItem.
     *
     * @param infos infos comming from the document.
     */
    public void setSale(String[] infos) {
        Sale sale = new Sale();
        sale.setId(infos[1]);
        saleItemService.splitItemsOnSale(infos[2]);
        sale.setSalesmanName(infos[3]);
        this.addToSalesList(sale);
    }

    private void addToSalesList(Sale sale){
        documentRead.addSales(sale);
    }
}

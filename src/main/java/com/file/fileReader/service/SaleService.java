package com.file.fileReader.service;

import com.file.fileReader.model.Sale;
import com.file.fileReader.model.SaleItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SaleService {

    private static final String HIGHEST_SALE = "Maior venda: ";

    private final SaleItemService saleItemService;

    public SaleService(SaleItemService saleItemService) {
        this.saleItemService = saleItemService;
    }

    public Sale buildSales(String[] infos) {
        Sale sale = new Sale();
        sale.setId(infos[1]);
        sale.setSaleItemList(saleItemService.buildSaleItemList(infos[2].substring(1, infos[2].length() - 1).split(",")));
        sale.setSalesmanName(infos[3]);
        return sale;
    }

    public String getIdHighestSale(List<Sale> saleList) {

        String idBiggestSale = "";
        BigDecimal amount = new BigDecimal("0.0");
        BigDecimal biggestAmount = new BigDecimal("0.0");

        for (Sale sale : saleList) {
            for (SaleItem saleItem : sale.getSaleItemList()) {
                amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getQuantity()))));
            }
            if (amount.compareTo(biggestAmount) == 1) {
                biggestAmount = amount;
                idBiggestSale = sale.getId();
            }
            amount = new BigDecimal(0.0);
        }
        return HIGHEST_SALE + idBiggestSale;
    }
}

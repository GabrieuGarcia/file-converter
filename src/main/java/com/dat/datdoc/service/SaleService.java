package com.dat.datdoc.service;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.model.Sale;
import com.dat.datdoc.model.SaleItem;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class SaleService {

    private static final String HIGHEST_SALE = "Maior venda: ";

    private final DocumentRead documentRead;
    private final SaleItemService saleItemService;

    public SaleService(DocumentRead documentRead, SaleItemService saleItemService) {
        this.documentRead = documentRead;
        this.saleItemService = saleItemService;
    }

    /**
     * Method responsible for set the infos comming from de document and set int the Sale and SaleItem.
     *
     * @param infos infos comming from the document.
     */
    public void setSale( String[] infos) {
        Sale sale = new Sale();
        sale.setId(infos[1]);
        saleItemService.splitItemsOnSale(infos[2]);
        sale.setSalesmanName(infos[3]);
        documentRead.addSales(sale);
    }
}

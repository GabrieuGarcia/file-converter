package com.dat.datdoc.service;

import com.dat.datdoc.model.Sale;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class SaleService {

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
}

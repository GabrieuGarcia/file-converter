package com.dat.datdoc.service;

import com.dat.datdoc.model.Sale;
import com.dat.datdoc.model.SaleItem;
import com.dat.datdoc.model.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class SalesmanService {

    private static final String HIGHEST_SALE = "Maior venda: ";
    private static final String WORST_SALESMAN = "Vendedor que menos vendeu: ";

    public Salesman buildSalesmanList(String[] infos) {

        return new Salesman.Builder()
                .name(infos[2])
                .cpf(infos[1])
                .salary(infos[3])
                .build();
    }

    public String getWorstSalesman(List<Sale> saleList, List<Salesman> salesmanList) {

        List<Salesman> sellersWithTotalPrice = new ArrayList<>();
        BigDecimal amount = new BigDecimal(0.0);

        for (Salesman seller : salesmanList) {

            for (Sale sale : saleList) {

                if (sale.getSalesmanName().equals(seller.getName())) {

                    for (SaleItem saleItem : sale.getSaleItemList()) {
                        amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getQuantity()))));
                        seller.setTotalSalePrice(amount);
                        sellersWithTotalPrice.add(seller);
                    }
                }
            }
        }
        Salesman salesman =  Collections.min(sellersWithTotalPrice, Comparator.comparing(s -> s.getTotalSalePrice()));

        return WORST_SALESMAN + salesman.getName();
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

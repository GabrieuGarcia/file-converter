package com.file.fileReader.service;

import com.file.fileReader.model.Sale;
import com.file.fileReader.model.SaleItem;
import com.file.fileReader.model.Salesman;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class SalesmanService {

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
}

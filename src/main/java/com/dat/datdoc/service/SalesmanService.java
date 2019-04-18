package com.dat.datdoc.service;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.model.Sale;
import com.dat.datdoc.model.SaleItem;
import com.dat.datdoc.model.Salesman;

import java.math.BigDecimal;
import java.util.Objects;

public class SalesmanService {

    private static final String WORST_SALESMAN = "Vendedor que menos vendeu: ";

    private final DocumentRead documentRead;

    public SalesmanService(DocumentRead documentRead) {
        this.documentRead = documentRead;
    }

    /**
     * Method responsible for get the name of the worst Salesman.
     *
     * @param documentRead documento that was read.
     * @return name of the worst salesman.
     */
    public String getWorstSalesman(DocumentRead documentRead) {
        String nameSalesman = "";
        BigDecimal amount = new BigDecimal(0.0);
        BigDecimal smallestAmount = new BigDecimal("0.0");

        for (Salesman seller : documentRead.getSalesmanList()) {

            for (Sale sale : documentRead.getSaleList()) {

                if (sale.getSalesmanName().equals(seller.getName())) {
                    for (SaleItem saleItem : sale.getSalesItens()) {
                        amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getItemQuantity()))));
                    }
                    if (amount.compareTo(smallestAmount) == -1) {
                        smallestAmount = amount;
                        nameSalesman = sale.getId();
                    }
                    amount = new BigDecimal(0.0);
                }
            }
        }
        return WORST_SALESMAN + nameSalesman;
    }

    /**
     * Method responsible for set the infos comming from de document and set int the Salesman.
     *
     * @param infos infos comming from the document.
     */
    public void setSalesman(String[] infos) {
            Salesman salesman = new Salesman();
            salesman.setCpf(infos[1]);
            salesman.setName(infos[2]);
            salesman.setSalary(new BigDecimal(infos[3]));
            this.addToSalesmanList(salesman);
    }

    private void addToSalesmanList(Salesman salesman){
        documentRead.addSalesman(salesman);
    }
}

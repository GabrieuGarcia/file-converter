package com.dat.datdoc.model;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Fernandes Garcia
 */
@Component
public class DocumentRead {

//    private static final String WORST_SALESMAN = "Vendedor que menos vendeu: ";
//    private static final String HIGHEST_SALE = "Maior venda: ";
//
//    private String nameDocument;
//    private List<Client> clientsList;
//    private List<Sale> saleList;
//    private List<Salesman> salesmanList;
//
//    public int getQtdClients(){
//        return clientsList.size();
//    }
//
//    public int getQtdSalesman(){
//        return salesmanList.size();
//    }
//
//    public String getWorstSalesman() {
//        String nameSalesman = "";
//        BigDecimal amount = new BigDecimal(0.0);
//        BigDecimal smallestAmount = new BigDecimal("0.0");
//
//        for (Salesman seller : getSalesmanList()) {
//
//            for (Sale sale : getSaleList()) {
//
//                if (sale.getSalesmanName().equals(seller.getName())) {
//                    for (SaleItem saleItem : sale.getSalesItens()) {
//                        amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getItemQuantity()))));
//                    }
//                    if (amount.compareTo(smallestAmount) == -1) {
//                        smallestAmount = amount;
//                        nameSalesman = sale.getId();
//                    }
//                    amount = new BigDecimal(0.0);
//                }
//            }
//        }
//        return WORST_SALESMAN + nameSalesman;
//    }
//
//    public String getIdHighestSale() {
//        String idBiggestSale = "";
//        BigDecimal amount = new BigDecimal("0.0");
//        BigDecimal biggestAmount = new BigDecimal("0.0");
//
//        for (Sale sale : getSaleList()) {
//            for (SaleItem saleItem : sale.getSalesItens()) {
//                amount = amount.add((saleItem.getItemPrice().multiply(BigDecimal.valueOf(saleItem.getItemQuantity()))));
//            }
//            if (amount.compareTo(biggestAmount) == 1) {
//                biggestAmount = amount;
//                idBiggestSale = sale.getId();
//            }
//            amount = new BigDecimal(0.0);
//        }
//        return HIGHEST_SALE + idBiggestSale;
//    }
//
//    public void addSalesman(Salesman salesman){
//        salesmanList.add(salesman);
//    }
//
//    public void addClient(Client client){
//        clientsList.add(client);
//    }
//
//    public void addSales(Sale sale){
//        saleList.add(sale);
//    }
//
//    public String getNameDocument() {
//        return nameDocument;
//    }
//
//    public void setNameDocument(String nameDocument) {
//        this.nameDocument = nameDocument;
//    }
//
//    public List<Client> getClientsList() {
//        return clientsList;
//    }
//    public void setClientsList(List<Client> clientsList) {
//        this.clientsList = clientsList;
//    }
//
//    public List<Sale> getSaleList() {
//        return saleList;
//    }
//
//    public void setSaleList(List<Sale> saleList) {
//        this.saleList = saleList;
//    }
//
//    public List<Salesman> getSalesmanList() {
//        return salesmanList;
//    }
//
//    public void setSalesmanList(List<Salesman> salesmanList) {
//        this.salesmanList = salesmanList;
//    }
}

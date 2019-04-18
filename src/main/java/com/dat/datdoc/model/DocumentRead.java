package com.dat.datdoc.model;

import java.util.List;

/**
 * @author Gabriel Fernandes Garcia
 */
public class DocumentRead {

    private String nameFile;
    private List<Client> clientsList;
    private List<Sale> saleList;
    private List<Salesman> salesmanList;

    public void addSalesman(Salesman salesman){
        salesmanList.add(salesman);
    }

    public void addCliente(Client client){
        clientsList.add(client);
    }

    public void addSales(Sale sale){
        saleList.add(sale);
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }
    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }

    public List<Sale> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<Sale> saleList) {
        this.saleList = saleList;
    }

    public List<Salesman> getSalesmanList() {
        return salesmanList;
    }

    public void setSalesmanList(List<Salesman> salesmanList) {
        this.salesmanList = salesmanList;
    }
}

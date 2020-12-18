package com.file.fileReader.service;

import com.file.fileReader.model.Client;
import com.file.fileReader.model.Sale;
import com.file.fileReader.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class OutputFileService {

    private final SalesmanService salesmanService;
    private final SaleService saleService;

    public OutputFileService(SalesmanService salesmanService, SaleService saleService) {
        this.salesmanService = salesmanService;
        this.saleService = saleService;
    }

    public void buildOutputFile(List<Salesman> salesmanList, List<Sale> saleList, List<Client> clientList, String fileName) throws FileNotFoundException {

        String numberOfClients = String.valueOf(clientList.size());
        String numberOfSalesman = String.valueOf(salesmanList.size());
        String highestSaleId = saleService.getIdHighestSale(saleList);
        String worstSalesman = salesmanService.getWorstSalesman(saleList, salesmanList);

        writeOutputFile(numberOfClients, numberOfSalesman, highestSaleId, worstSalesman, fileName);
    }

    private void writeOutputFile(String numberOfClients, String numberOfSalesman, String highestSale, String worstSalesman, String fileName) throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(System.getProperty("user.home")+ File.separator+"data"+File.separator+"out"+File.separator+"out_"+ fileName);

        writer.println("Quantidade de clientes: " + numberOfClients);
        writer.println("Quantidade de vendedores: " + numberOfSalesman);
        writer.println("Id da venda mais cara: " + highestSale);
        writer.println("Pior vendedor: " + worstSalesman);
        writer.close();
    }
}

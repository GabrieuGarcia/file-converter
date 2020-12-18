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

    private static final String QUANTITY_CLIENTS = "Quantidade de clientes: ";
    private static final String QUANTITY_SALESMAN = "Quantidade de vendedores: ";
    private static final String ID_HIGHEST_SCORE = "Id da venda mais cara: ";
    private static final String WORST_SALESMAN = "Pior vendedor: ";
    private static final String FILE_OUT = System.getProperty("user.home")+ File.separator+"data"+File.separator+"out"+File.separator+"out_";

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

        PrintWriter writer = new PrintWriter(FILE_OUT+fileName);

        writer.println(QUANTITY_CLIENTS + numberOfClients);
        writer.println(QUANTITY_SALESMAN + numberOfSalesman);
        writer.println(ID_HIGHEST_SCORE + highestSale);
        writer.println(WORST_SALESMAN + worstSalesman);
        writer.close();

        System.out.println(QUANTITY_CLIENTS + numberOfClients +
                "\n" +QUANTITY_SALESMAN + numberOfSalesman +
                "\n" +ID_HIGHEST_SCORE + highestSale +
                "\n" +WORST_SALESMAN + worstSalesman);
    }
}

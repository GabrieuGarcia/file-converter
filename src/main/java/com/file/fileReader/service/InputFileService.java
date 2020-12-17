package com.file.fileReader.service;

import com.file.fileReader.model.Client;
import com.file.fileReader.model.Sale;
import com.file.fileReader.model.Salesman;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class InputFileService {

    private List<Salesman> salesmanList = new ArrayList<>();
    private List<Sale> saleList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private String fileName = "";

    private final SalesmanService salesmanService;
    private final ClientService clientService;
    private final SaleService saleService;

    public InputFileService(SalesmanService salesmanService, ClientService clientService, SaleService saleService) {
        this.salesmanService = salesmanService;
        this.clientService = clientService;
        this.saleService = saleService;
    }

    public void processFiles() throws IOException {

        String docPath = System.getProperty("user.home") + "/data/in";
        File[] files = new File(docPath).listFiles();
        buildBufferedReader(files);
    }

    private void buildBufferedReader(File[] files) throws IOException {

        for (File file : files) {
            fileName = file.getName();
            Scanner fileScanner = new Scanner(new FileReader(file));
            buildFileInfos(fileScanner);
        }
    }

    private void buildFileInfos(Scanner fileScanner) throws FileNotFoundException {

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] fields = line.split("�");

            if(fields[0].equals(Salesman.SALESMAN_CODE)){
                Salesman salesman = salesmanService.buildSalesmanList(fields);
                salesmanList.add(salesman);

            } else if(fields[0].equals(Client.CLIENT_CODE)){
                Client client = clientService.buildClient(fields);
                clientList.add(client);

            } else if(fields[0].equals(Sale.SALE_CODE)){
                Sale sale = saleService.buildSales(fields);
                saleList.add(sale);
            }
        }
        buildOutputFile(salesmanList, saleList, clientList, fileName);
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

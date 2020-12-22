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

    private static final String FILE_IN = System.getProperty("user.home") + "/data/in";
    private static final String SPLIT_CHARACTER = "�";

    private List<Salesman> salesmanList = new ArrayList<>();
    private List<Sale> saleList = new ArrayList<>();
    private List<Client> clientList = new ArrayList<>();
    private String fileName = "";

    private final SalesmanService salesmanService;
    private final ClientService clientService;
    private final SaleService saleService;
    private final OutputFileService outputFileService;

    public InputFileService(SalesmanService salesmanService, ClientService clientService, SaleService saleService, OutputFileService outputFileService) {
        this.salesmanService = salesmanService;
        this.clientService = clientService;
        this.saleService = saleService;
        this.outputFileService = outputFileService;
    }

    public void processFiles() throws IOException {

        String filePath = FILE_IN;
        File[] files = new File(filePath).listFiles();
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
            String[] fields = line.split(SPLIT_CHARACTER);

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
        outputFileService.buildOutputFile(salesmanList, saleList, clientList, fileName);
    }
}

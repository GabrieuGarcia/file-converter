package com.dat.datdoc.service;


import com.dat.datdoc.model.*;

import java.io.*;

public class DocumentReadService {

    private static final String CHARACTER_DIVISOR = "ç";
    private static final String CLIENTS_QUANTITY = "Quantidade de Clientes: ";
    private static final String SALES_QUANTITY = "Quantidade de vendedores: ";
    private static final String DOCUMENT_FORMAT_OUT = ".done.dat";

    private static DocumentRead documentRead;
    private static SalesmanService salesmanService;
    private static ClientService clientService;
    private static SaleService saleService;
    private DocumentProcessService documentProcessService;

    /**
     * Method responsible for validating if it's Salesman, Client or Sale.
     *
     * @param bufferedReader document convert in to bufferedReader.
     * @throws IOException exception.
     */
    public void validateDocInfos(BufferedReader bufferedReader) throws IOException {
        String line = "";

        while ((line = bufferedReader.readLine()) != null) {

            String[] infos = line.split(CHARACTER_DIVISOR);

            if (infos[0].equals(Salesman.SALESMAN_CODE)) {
                salesmanService.setSalesman(infos);

            } else if (infos[0].equals(Client.CLIENT_CODE)) {
                clientService.setClient(infos);

            } else if (infos[0].equals(Sale.SALE_CODE)) {
                saleService.setSale(infos);
            }
        }
    }

    /**
     * Method responsable for processing the document in to format out.
     *
     * @param documentRead document that was read.
     * @throws IOException exception.
     */
    public void processOutDocumentRead(DocumentRead documentRead) throws IOException {
        File documentOut = new File("/data/out/" + documentRead.getNameFile() + DOCUMENT_FORMAT_OUT);
        FileWriter fileWriter = new FileWriter(documentOut);
        PrintWriter printDocumentOut = new PrintWriter(fileWriter);

        printDocumentOut.println(getQuantityClients(documentRead));
        printDocumentOut.println(getQuantitySalesman(documentRead));
        printDocumentOut.println(getIdHighestSale(documentRead));
        printDocumentOut.println(getWorstSalesman(documentRead));

        fileWriter.close();
    }

    private String getQuantityClients(DocumentRead documentRead) {
        return CLIENTS_QUANTITY + documentRead.getClientsList().size();
    }

    private String getQuantitySalesman(DocumentRead documentRead) {
        return SALES_QUANTITY + documentRead.getSalesmanList().size();
    }

    private String getIdHighestSale(DocumentRead documentRead) {
        return saleService.getIdHighestSale(documentRead);
    }

    private String getWorstSalesman(DocumentRead documentRead) {
        return salesmanService.getWorstSalesman(documentRead);
    }

}
package com.dat.datdoc.service;


import com.dat.datdoc.model.*;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class DocumentReadService {

    private static final String CLIENTS_QUANTITY = "Quantidade de Clientes: ";
    private static final String SALES_QUANTITY = "Quantidade de vendedores: ";
    private static final String ID_HIGHEST_SALE = "ID da Venda de valor mais alto: ";
    private static final String WORST_SALESMAN = "Nome do Vendedor que menos vendeu: ";
    private static final String DAT_DOCUMENT_PATH_OUT = "/data/out/";
    private static final String DAT_DOCUMENT = ".dat";
    private static final String DAT_DOCUMENT_NAME_FORMAT_OUT = "-out.dat";

    public void documentFormatOut(DocumentRead documentRead) throws IOException {
        File fileSaida = formatFileName(documentRead);
        FileWriter fileWriter = new FileWriter(fileSaida);
        PrintWriter gravarArq = new PrintWriter(fileWriter);

        gravarArq.println(CLIENTS_QUANTITY + documentRead.getQtdClients());
        gravarArq.println(SALES_QUANTITY + documentRead.getQtdSalesman());
        gravarArq.println(ID_HIGHEST_SALE + documentRead.getIdHighestSale());
        gravarArq.println(WORST_SALESMAN + documentRead.getWorstSalesman());

        fileWriter.close();
    }

    private File formatFileName(DocumentRead documentRead) {

        File fileSaida = new File(System.getProperty("user.home") + DAT_DOCUMENT_PATH_OUT);

        if (fileSaida.getName().endsWith(DAT_DOCUMENT)) {
            fileSaida.getName().replaceAll(DAT_DOCUMENT, "");
        }

        return new File(documentRead.getNameDocument() + DAT_DOCUMENT_NAME_FORMAT_OUT);
    }

}
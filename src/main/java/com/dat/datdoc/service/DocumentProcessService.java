package com.dat.datdoc.service;

import com.dat.datdoc.model.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Gabriel Fernandes Garcia
 */
public class DocumentProcessService {

    private static final String DAT_DOCUMENT = "dat";
    private static final String DAT_DOCUMENT_OUT = "/dados/out/";
    private static final String DOCUMENT_DIVISOR = "ç";

    private static List<DocumentRead> documentReadList;
    private static DocumentReadService documentReadService;
    private static SalesmanService salesmanService;
    private static ClientService clientService;
    private static SaleService saleService;

    /**
     * Method responsible for all the informations comming from all Docs .dat.
     *
     * @param docPath documents on path.
     * @throws IOException exception.
     */
    public static void processDocs(String docPath) throws IOException {

        List<File> docsFoundOnPath = getDatDocs(docPath);
        documentReadList = new ArrayList<DocumentRead>();
        documentReadService = new DocumentReadService();

        for(File docOnPath : docsFoundOnPath){

            DocumentRead documentRead = new DocumentRead(docOnPath.getName());
            FileReader fileReader = new FileReader(docOnPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            validateDocInfos(bufferedReader);
            documentReadList.add(documentRead);
            fileReader.close();
        }
        finishProcess();
    }

    private static void validateDocInfos(BufferedReader bufferedReader) throws IOException {
        String linha;

        while((linha = bufferedReader.readLine()) != null){

            String[] infos = linha.split(DOCUMENT_DIVISOR);

            if(infos[0].equals(Salesman.SALESMAN_CODE)){
                salesmanService.setSalesman(infos);

            }else if(infos[0].equals(Client.CLIENT_CODE)){
                clientService.setClient(infos);

            }else if(infos[0].equals(Sale.SALE_CODE)){
                saleService.setSale(infos);
            }
        }
    }

    private static List<File> getDatDocs(String pathDocs){
        File path = new File(pathDocs);
        List<File> documents = new ArrayList<File>();
        for(File file: path.listFiles()){
            String nameDocuments = file.getName();
            String documentsExtensao = nameDocuments.substring(nameDocuments.lastIndexOf(".") + 1, nameDocuments.length());
            if(documentsExtensao.toLowerCase().equals(DAT_DOCUMENT)){
                documents.add(file);
            }
        }
        return documents;
    }

    private static void finishProcess() throws IOException{
        File dirOut = new File(DAT_DOCUMENT_OUT);
        if(!dirOut.exists()){
            dirOut.mkdir();
        }
        for(DocumentRead documentRead: documentReadList){
            documentReadService.documentFormatOut(documentRead);
        }
    }
}

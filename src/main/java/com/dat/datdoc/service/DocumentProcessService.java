package com.dat.datdoc.service;

import com.dat.datdoc.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class DocumentProcessService {

    private static final String DAT_DOCUMENT = "dat";
    private static final String DAT_DOCUMENT_OUT = "/dados/out/";
    private static final String DOCUMENT_DIVISOR = "ç";

    private List<DocumentRead> documentReadList;
    private final DocumentReadService documentReadService;
    private final SalesmanService salesmanService;
    private final ClientService clientService;
    private final SaleService saleService;

    public DocumentProcessService(DocumentReadService documentReadService, SalesmanService salesmanService, ClientService clientService, SaleService saleService) {
        this.documentReadService = documentReadService;
        this.salesmanService = salesmanService;
        this.clientService = clientService;
        this.saleService = saleService;
    }


    public void processDocs() throws IOException {

        String docPath = System.getProperty("user.home") + "/data/in";

        List<File> datDocsFoundOnPath = getDatDocs(docPath);

        List<BufferedReader> bufferedReaderList = buildBufferdReaderList(datDocsFoundOnPath);

        validateDocInfos(bufferedReaderList);


//        validateDocInfos(bufferedReader);
//        documentReadList.add(documentRead);
//        fileReader.close();

//        finishProcess();
    }

    private List<BufferedReader> buildBufferdReaderList(List<File> datDocsFoundOnPath) throws IOException {

        List<BufferedReader> bufferedReaderList = new ArrayList<>();

        for(File datDocOnPath : datDocsFoundOnPath){

            FileReader fileReader = new FileReader(datDocOnPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            bufferedReaderList.add(bufferedReader);
        }
        return bufferedReaderList;
    }

    private List<File> getDatDocs(String pathDocs){

        File path = new File(pathDocs);
        List<File> filesFound = new ArrayList<>();

        for (File file : path.listFiles()) {
            if (file.getName().endsWith(DAT_DOCUMENT)) {
                filesFound.add(file);
            }
        }
        return filesFound;
    }

    private void validateDocInfos(List<BufferedReader> bufferedReaderList) throws IOException {

        for(BufferedReader bufferedReader : bufferedReaderList) {

            while(bufferedReader.readLine() != null){

                byte[] utf8Bytes = bufferedReader.readLine().getBytes();
                String value = new String(utf8Bytes, "UTF-8");

                String[] lines = value.split("[^\\w]");

                if(lines[0].equals(Salesman.SALESMAN_CODE)){
                    salesmanService.setSalesman(lines);

                }else if(lines[0].equals(Client.CLIENT_CODE)){
                    clientService.setClient(lines);

                }else if(lines[0].equals(Sale.SALE_CODE)){
                    saleService.setSale(lines);
                }
            }
        }
    }

    private void finishProcess() throws IOException{
        File dirOut = new File(DAT_DOCUMENT_OUT);
        if(!dirOut.exists()){
            dirOut.mkdir();
        }
        for(DocumentRead documentRead: documentReadList){
            documentReadService.documentFormatOut(documentRead);
        }
    }
}

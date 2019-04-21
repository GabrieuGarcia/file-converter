package com.dat.datdoc.service;

import com.dat.datdoc.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Gabriel Fernandes Garcia
 */
public class DocumentProcessService {

    private static final String DAT_DOCUMENT = "dat";
    private static final String DAT_DOCUMENT_PATH_OUT = "/data/out/";

    private static List<DocumentRead> documentReadList;
    private static SaleItemService saleItemService;
    private static DocumentReadService documentReadService;

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

            documentReadService.validateDocInfos(documentRead , bufferedReader);
            documentReadList.add(documentRead);
            finishProcess();
        }
    }

    private static List<File> getDatDocs(String docPath) {
        File path = new File(docPath);
        List<File> docsDatOnPath = new ArrayList<File>();

        for(File doc: Objects.requireNonNull(path.listFiles())){
            String docName = doc.getName();
            String docExtension = docName.substring(docName.lastIndexOf(".") + 1);

            if(docExtension.toLowerCase().equals(DAT_DOCUMENT)){
                docsDatOnPath.add(doc);
            }
        }
        return docsDatOnPath;
    }

    private static void finishProcess() throws IOException{
        File dirOut = new File(System.getProperty("user.home") + DAT_DOCUMENT_PATH_OUT);
        if(!dirOut.exists()){
            dirOut.mkdir();
        }
        for(DocumentRead documentRead: documentReadList) {
            documentReadService.processOutDocumentRead(documentRead);
        }
    }
}

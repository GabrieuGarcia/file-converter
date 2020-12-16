package com.dat.datdoc;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Gabriel Fernandes Garcia
 */
@SpringBootApplication
public class DatdocApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatdocApplication.class, args);

        System.out.println("Starting the document read!");
        DocumentProcessService documentProcessService = initializeDocumentProcessService();
        documentProcessService.processDocs();
        System.out.println("Process finished!");
    }

    private static DocumentProcessService initializeDocumentProcessService() {
        DocumentProcessService documentProcessService = new DocumentProcessService(
                new DocumentReadService(),
                new SalesmanService(new DocumentRead()),
                new ClientService(),
                new SaleService(new DocumentRead(), new SaleItemService()));

        return documentProcessService;
    }

}

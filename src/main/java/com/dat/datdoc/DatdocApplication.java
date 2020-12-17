package com.dat.datdoc;

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
        InputFileService inputFileService = buildDocumentProcessService();
        inputFileService.processDocs();
        System.out.println("Process finished!");
    }


    private static InputFileService buildDocumentProcessService() {
        return new InputFileService(new SalesmanService(), new ClientService(), new SaleService(new SaleItemService()));
    }
}

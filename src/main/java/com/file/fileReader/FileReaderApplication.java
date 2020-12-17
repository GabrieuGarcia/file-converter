package com.file.fileReader;

import com.file.fileReader.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class FileReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FileReaderApplication.class, args);

        System.out.println("Starting the file read!");
        InputFileService inputFileService = buildDocumentProcessService();
        inputFileService.processFiles();
        System.out.println("Process finished!");
    }

    private static InputFileService buildDocumentProcessService() {
        return new InputFileService(new SalesmanService(), new ClientService(), new SaleService(new SaleItemService()));
    }
}

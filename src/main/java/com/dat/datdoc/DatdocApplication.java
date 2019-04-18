package com.dat.datdoc;

import com.dat.datdoc.service.DocumentProcessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DatDocApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatDocApplication.class, args);

        System.out.println("Starting the document read!");
        DocumentProcessService.processDocs("/doc/in");
        System.out.println("Process finished!");
    }
}

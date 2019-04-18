package com.dat.datdoc;

import com.dat.datdoc.service.DocumentProcessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.IOException;

@SpringBootApplication
public class DatdocApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatdocApplication.class, args);

        System.out.println("Iniciando processamento...");
        DocumentProcessService.processDocs("/file/in");
        System.out.println("Fim de processamento!");
    }
}

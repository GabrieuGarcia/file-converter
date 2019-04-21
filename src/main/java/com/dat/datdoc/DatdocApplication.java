package com.dat.datdoc;

import com.dat.datdoc.service.DocumentProcessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author Gabriel Fernandes Garcia
 */
@SpringBootApplication
public class DatDocApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DatDocApplication.class, args);

        System.out.println("Starting the document read!");
        DocumentProcessService.processDocs(System.getProperty("user.home") + "/data/in");
        System.out.println("Process finished!");
    }
}

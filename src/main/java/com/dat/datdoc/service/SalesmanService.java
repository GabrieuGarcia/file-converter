package com.dat.datdoc.service;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.model.Sale;
import com.dat.datdoc.model.SaleItem;
import com.dat.datdoc.model.Salesman;

import java.math.BigDecimal;

/**
 * @author Gabriel Fernandes Garcia
 */
public class SalesmanService {


    private final DocumentRead documentRead;

    public SalesmanService(DocumentRead documentRead) {
        this.documentRead = documentRead;
    }

    public void setSalesman(String[] infos){
        Salesman salesman = new Salesman();
        salesman.setCpf(infos[1]);
        salesman.setName(infos[2]);
        salesman.setSalary(new BigDecimal(infos[3]));
        documentRead.addSalesman(salesman);
    }
}

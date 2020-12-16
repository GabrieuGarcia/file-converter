package com.dat.datdoc.service;

import com.dat.datdoc.model.DocumentRead;
import com.dat.datdoc.model.Salesman;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class SalesmanService {

    private final DocumentRead documentRead;

    public SalesmanService(DocumentRead documentRead) {
        this.documentRead = documentRead;
    }

    public void setSalesman(String[] infos){

        Salesman salesman = new Salesman();
        salesman.setCpf(infos[1]);
        salesman.setName(infos[2]);
        salesman.setSalary(new BigDecimal(validateSalarary(infos[3],infos[4])));

        documentRead.addSalesman(salesman);
    }


    public String validateSalarary(String salary, String cents) {

        if(!StringUtils.isEmpty(salary)) {
            if(!StringUtils.isEmpty(cents)) {
                return salary + "." + cents;
            }
        }
        return salary;
    }
}

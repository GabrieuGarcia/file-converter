package com.dat.datdoc.model;

import java.math.BigDecimal;

/**
 * @author Gabriel Fernandes Garcia
 */
public class Salesman {

    public static final String SALESMAN_CODE = "001";

    private String name;
    private String cpf;
    private BigDecimal salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salesman{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salary=" + salary +
                '}';
    }
}

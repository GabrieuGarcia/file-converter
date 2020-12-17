package com.file.fileReader.model;

import java.math.BigDecimal;

public class Salesman {

    public static final String SALESMAN_CODE = "001";

    private String name;
    private String cpf;
    private BigDecimal salary;

    private BigDecimal totalSalePrice;

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

    public BigDecimal getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(BigDecimal totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }

    public static class Builder {

        private String name;
        private String cpf;
        private BigDecimal salary;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder cpf(String cpf) {
            this.cpf = cpf;
            return this;
        }

        public Builder salary(String salary) {
            this.salary = new BigDecimal(salary);
            return this;
        }

        public Salesman build() {
            Salesman salesman = new Salesman();
            salesman.name = this.name;
            salesman.cpf = this.cpf;
            salesman.salary = this.salary;

            return salesman;
        }

    }
}

package com.file.fileReader.model;

public class Client {

    public static final String CLIENT_CODE = "002";

    private String name;
    private String cnpj;
    private String businessActivity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getBusinessActivity() {
        return businessActivity;
    }

    public void setBusinessActivity(String businessActivity) {
        this.businessActivity = businessActivity;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", businessActivity='" + businessActivity + '\'' +
                '}';
    }
}

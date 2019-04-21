package com.dat.datdoc.service;

import com.dat.datdoc.model.Client;
import com.dat.datdoc.model.DocumentRead;

/**
 * @author Gabriel Fernandes Garcia
 */
public class ClientService {

    private final DocumentRead documentRead;

    public ClientService(DocumentRead documentRead) {
        this.documentRead = documentRead;
    }

    public void setClient(DocumentRead documentRead, String[] infos) {
        Client cliente = new Client();
        cliente.setCnpj(infos[1]);
        cliente.setName(infos[2]);
        cliente.setBusinessActivity(infos[3]);
        documentRead.addCliente(cliente);
    }
}

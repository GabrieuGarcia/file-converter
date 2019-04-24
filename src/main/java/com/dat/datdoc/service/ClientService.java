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

    public void setClient(String[] infos) {
        Client client = new Client();
        client.setName(infos[1]);
        client.setCnpj(infos[2]);
        client.setBusinessActivity(infos[3]);
        documentRead.addClient(client);
    }
}

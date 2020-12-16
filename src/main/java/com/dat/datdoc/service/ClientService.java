package com.dat.datdoc.service;

import com.dat.datdoc.model.Client;
import com.dat.datdoc.model.DocumentRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Gabriel Fernandes Garcia
 */
@Service
public class ClientService {

    @Autowired
    private DocumentRead documentRead;

    public void setClient(String[] infos) {
        Client client = new Client();
        client.setName(infos[1]);
        client.setCnpj(infos[2]);
        client.setBusinessActivity(infos[3]);
        documentRead.addClient(client);
    }
}

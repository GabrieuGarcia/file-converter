package com.file.fileReader.service;

import com.file.fileReader.model.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public Client buildClient(String[] infos) {
        Client client = new Client();
        client.setName(infos[1]);
        client.setCnpj(infos[2]);
        client.setBusinessActivity(infos[3]);

        return client;
    }
}

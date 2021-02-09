package com.facens.poo.sistema.sistema.repositories;

import java.util.ArrayList;
import java.util.List;

import com.facens.poo.sistema.sistema.entities.Client;

import org.springframework.stereotype.Component;

@Component
public class ClientRepository {

    public List<Client> getClients(){
        Client c1 = new Client();
        c1.setId(1l);
        c1.setName("Glauco");
        c1.setAddress("Rua X, 99");

        Client c2 = new Client();
        c2.setId(2l);
        c2.setName("Andre");
        c2.setAddress("Rua Y, 129");

        List<Client> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);

        return list;
    }
}

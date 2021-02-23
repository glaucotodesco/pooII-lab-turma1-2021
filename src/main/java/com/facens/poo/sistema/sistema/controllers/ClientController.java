package com.facens.poo.sistema.sistema.controllers;


import java.util.List;
import com.facens.poo.sistema.sistema.dto.ClientDTO;
import com.facens.poo.sistema.sistema.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClient(){
        List <ClientDTO> list = service.getClients();
        return ResponseEntity.ok().body(list);
    }


}

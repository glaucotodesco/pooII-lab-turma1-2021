package com.facens.poo.sistema.sistema.controllers;

import java.net.URI;
import java.util.List;
import com.facens.poo.sistema.sistema.dto.ClientDTO;
import com.facens.poo.sistema.sistema.dto.ClientInsertDTO;
import com.facens.poo.sistema.sistema.dto.ClientUpdateDTO;
import com.facens.poo.sistema.sistema.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClients(){
        List <ClientDTO> list = service.getClients();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long id){
        ClientDTO dto = service.getClientById(id);
        return ResponseEntity.ok().body(dto);
    }



    @PostMapping
	public ResponseEntity<ClientDTO> insert(@RequestBody ClientInsertDTO insertDto){
		ClientDTO dto = service.insert(insertDto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}


    @DeleteMapping("{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id); 
		return ResponseEntity.noContent().build();
	}


    @PutMapping("{id}")
	public ResponseEntity<ClientDTO> update(@RequestBody ClientUpdateDTO updateDto, @PathVariable Long id){
		ClientDTO dto = service.update(id, updateDto); 
		return ResponseEntity.ok().body(dto);
	}

}

package com.facens.poo.sistema.sistema.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.facens.poo.sistema.sistema.dto.ClientDTO;
import com.facens.poo.sistema.sistema.dto.ClientInsertDTO;
import com.facens.poo.sistema.sistema.dto.ClientUpdateDTO;
import com.facens.poo.sistema.sistema.entities.Client;
import com.facens.poo.sistema.sistema.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repo;


    public Page<ClientDTO> getClients(PageRequest pageRequest, String name, String address) {
        Page<Client> list = repo.find(pageRequest, name, address);
        return list.map(c -> new ClientDTO(c));
    }

    public ClientDTO getClientById(Long id) {
        Optional<Client> op = repo.findById(id);
        Client client = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found"));
        return new ClientDTO(client);
    }

    public ClientDTO insert(ClientInsertDTO insertDTO) {
        Client entity = new Client(insertDTO);
        entity = repo.save(entity);
        return new ClientDTO(entity);
    }

    public void delete(Long id) {
        try {
            repo.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    public ClientDTO update(Long id, ClientUpdateDTO updateDTO) {
        try {
            Client entity = repo.getOne(id);
            entity.setName(updateDTO.getName());
            entity = repo.save(entity);

            return new ClientDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client not found");
        }
    }

    private List<ClientDTO> toDTOList(List<Client> list) {
        List<ClientDTO> listDTO = new ArrayList<>();

        for (Client c : list) {
            listDTO.add(new ClientDTO(c.getId(), c.getName()));
        }
        return listDTO;
    }

}

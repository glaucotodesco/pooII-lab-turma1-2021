package com.facens.poo.sistema.sistema.dto;

import com.facens.poo.sistema.sistema.entities.Client;

public class ClientDTO {
    private Long id;
    private String name;

    public ClientDTO() {
	}

    public ClientDTO(Long id, String name) {
        setId(id);
        setName(name);
	}

	public ClientDTO(Client client) {
        setId(client.getId());
        setName(client.getName());
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

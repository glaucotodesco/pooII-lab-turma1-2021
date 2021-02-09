package com.facens.poo.sistema.sistema.dto;

public class ClientDTO {
    private Long id;
    private String name;

    public ClientDTO() {
	}

    public ClientDTO(Long id, String name) {
        setId(id);
        setName(name);
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

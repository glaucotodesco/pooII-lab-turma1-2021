package com.facens.poo.sistema.sistema.repositories;

import com.facens.poo.sistema.sistema.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long> {
    
}




package com.facens.poo.sistema.sistema.repositories;

import com.facens.poo.sistema.sistema.entities.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Client,Long> {

    //Isso é uma consulta JPQL!!!!
    @Query("SELECT c FROM Client c " + 
           "WHERE " +
           "LOWER(c.name)     LIKE   LOWER(CONCAT('%', :name, '%')) AND " +
           "LOWER(c.address)  LIKE   LOWER(CONCAT('%', :address, '%'))     "
    )
    public Page<Client> find(Pageable pageRequest, String name, String address);
      
    
}




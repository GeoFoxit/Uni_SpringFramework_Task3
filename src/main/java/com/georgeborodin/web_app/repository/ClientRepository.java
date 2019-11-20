package com.georgeborodin.web_app.repository;

import com.georgeborodin.web_app.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {

    Client getById(Integer id);

}

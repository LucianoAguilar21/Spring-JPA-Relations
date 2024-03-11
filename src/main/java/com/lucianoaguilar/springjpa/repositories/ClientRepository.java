package com.lucianoaguilar.springjpa.repositories;

import com.lucianoaguilar.springjpa.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}

package com.lucianoaguilar.springjpa.repositories;

import com.lucianoaguilar.springjpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}

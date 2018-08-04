package com.spring.app.springangularjs204.repository;

import com.spring.app.springangularjs204.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {

    Departement findAllByDescription(String description);
}

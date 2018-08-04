package com.spring.app.springangularjs204.service;

import com.spring.app.springangularjs204.entity.Departement;
import com.spring.app.springangularjs204.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartementService {

    @Autowired
    private DepartementRepository departementRepository;

    public Departement save(Departement departement){
        if (departement.getId() != 0 && departementRepository.existsById(departement.getId())){
            throw new EntityExistsException("sorry id departement is exists");
        }
        return departementRepository.save(departement);
    }

    public Departement update(Departement departement){
        if (departement.getId() != 0 && !departementRepository.existsById(departement.getId())){
            throw new EntityNotFoundException("sorry id departement is not exists");
        }
        return departementRepository.save(departement);
    }

    public List<Departement> list(){
        List<Departement> departements = new ArrayList<>();
        for (Departement departement: departementRepository.findAll()){
            departements.add(departement);
        }
        return departements;
    }

    public Optional<Departement> getId(Integer id){
        return departementRepository.findById(id);
    }
}

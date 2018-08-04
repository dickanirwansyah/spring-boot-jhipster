package com.spring.app.springangularjs204.controller;

import com.spring.app.springangularjs204.entity.Departement;
import com.spring.app.springangularjs204.service.DepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityExistsException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/departement")
@CrossOrigin(origins = {"*"})
public class DepartementController {

    @Autowired
    private DepartementService departementService;

    @GetMapping
    public List<Departement> list(){
        return departementService.list();
    }

    @PostMapping
    public ResponseEntity<Departement> save(@RequestBody Departement departement) throws URISyntaxException{
        try{
            Departement callbackJSON = departementService.save(departement);
            return ResponseEntity.created(new URI("/api/departement/"+callbackJSON.getId())).body(callbackJSON);
        }catch (EntityExistsException ex){
            return new ResponseEntity<Departement>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<Departement> update(@RequestBody Departement departement) throws URISyntaxException{
        if (departement.getId() == 0){
            return new ResponseEntity<Departement>(HttpStatus.NOT_FOUND);
        }
        try{
            Departement callbackJSON = departementService.update(departement);
            return ResponseEntity.created(new URI("/api/departement/"+callbackJSON.getId())).body(callbackJSON);
        }catch (EntityExistsException ex){
            return new ResponseEntity<Departement>(HttpStatus.CONFLICT);
        }
    }
}

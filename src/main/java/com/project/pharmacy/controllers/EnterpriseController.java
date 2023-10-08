package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.EnterpriseDTO;
import com.project.pharmacy.services.impl.EnterpriseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseServiceImpl enterpriseService;

    @PostMapping
    public ResponseEntity<Void> createEnterprise(@RequestBody EnterpriseDTO enterpriseDTO){
        enterpriseService.createEnterprise(enterpriseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<EnterpriseDTO> listAllEnterprises(){
        return enterpriseService.listAllEnterprise();
    }

    @GetMapping("/{id}")
    public EnterpriseDTO getEnterpriseById(@PathVariable Long id){
        return enterpriseService.getEnterpriseById(id);
    }

    @PutMapping("/{id}")
    public EnterpriseDTO updateEnterprise(@PathVariable Long id, @RequestBody EnterpriseDTO enterpriseDTO){
        return enterpriseService.updateEnterprise(id, enterpriseDTO);
    }

    @DeleteMapping("/{id}")
    void deleteEnterprise(@PathVariable Long id){
        enterpriseService.deleteEnterprise(id);
    }
}

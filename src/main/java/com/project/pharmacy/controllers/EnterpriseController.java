package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.EnterpriseDTO;
import com.project.pharmacy.exceptions.enterprise.EnterpriseGetByIdException;
import com.project.pharmacy.exceptions.enterprise.EnterpriseUpdateByIdException;
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
    public ResponseEntity<Void> createEnterprise(@RequestBody EnterpriseDTO enterpriseDTO) {
        enterpriseService.createEnterprise(enterpriseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    public List<EnterpriseDTO> listAllEnterprises() {
        return enterpriseService.listAllEnterprise();
    }

    @GetMapping("/{id}")
    public String getEnterpriseById(@PathVariable Long id) {
        try {
            EnterpriseDTO enterpriseDTO = enterpriseService.getEnterpriseById(id);
            return enterpriseDTO.toString();
        } catch (EnterpriseGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    public String updateEnterprise(@PathVariable Long id, @RequestBody EnterpriseDTO enterpriseDTO) {
        try {
            EnterpriseDTO enterpriseDTO1 = enterpriseService.updateEnterprise(id, enterpriseDTO);
            return enterpriseDTO1.toString();
        } catch (EnterpriseUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    void deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteEnterprise(id);
    }
}

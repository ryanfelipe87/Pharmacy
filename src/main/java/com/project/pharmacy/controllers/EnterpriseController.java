package com.project.pharmacy.controllers;

import com.project.pharmacy.dtos.EnterpriseDTO;
import com.project.pharmacy.exceptions.enterprise.EnterpriseGetByIdException;
import com.project.pharmacy.exceptions.enterprise.EnterpriseUpdateByIdException;
import com.project.pharmacy.services.impl.EnterpriseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enterprise")
@Tag(name = "Enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseServiceImpl enterpriseService;

    @PostMapping
    @Operation(
            summary = "Controller for enterprises",
            description = "Endpoint for create a new enterprise")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public ResponseEntity<Void> createEnterprise(@RequestBody EnterpriseDTO enterpriseDTO) {
        enterpriseService.createEnterprise(enterpriseDTO);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping
    @Operation(
            summary = "Controller for enterprises",
            description = "Endpoint for search all enterprises")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public List<EnterpriseDTO> listAllEnterprises() {
        return enterpriseService.listAllEnterprise();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Controller for enterprises",
            description = "Endpoint for search enterprise for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String getEnterpriseById(@PathVariable Long id) {
        try {
            EnterpriseDTO enterpriseDTO = enterpriseService.getEnterpriseById(id);
            return enterpriseDTO.toString();
        } catch (EnterpriseGetByIdException exception) {
            return exception.getMessage();
        }
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Controller for enterprises",
            description = "Endpoint for update a enterprise for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    public String updateEnterprise(@PathVariable Long id, @RequestBody EnterpriseDTO enterpriseDTO) {
        try {
            EnterpriseDTO enterpriseDTO1 = enterpriseService.updateEnterprise(id, enterpriseDTO);
            return enterpriseDTO1.toString();
        } catch (EnterpriseUpdateByIdException exception) {
            return exception.getMessage();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Controller for enterprises",
            description = "Endpoint for delete a enterprise for id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful request."),
            @ApiResponse(responseCode = "400", description = "Invalid request due to pre-defined validations."),
            @ApiResponse(responseCode = "404", description = "Resource not found."),
            @ApiResponse(responseCode = "500", description = "Unidentified internal error on the server."),
    })
    void deleteEnterprise(@PathVariable Long id) {
        enterpriseService.deleteEnterprise(id);
    }
}

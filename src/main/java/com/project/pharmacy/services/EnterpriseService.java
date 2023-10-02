package com.project.pharmacy.services;

import com.project.pharmacy.dtos.EnterpriseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnterpriseService {

    EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO);

    List<EnterpriseDTO> listAllEnterprise();

    EnterpriseDTO getEnterpriseById(Long id);

    EnterpriseDTO updateEnterprise(Long id, EnterpriseDTO enterpriseDTO);

    void deleteEnterprise(Long id);
}

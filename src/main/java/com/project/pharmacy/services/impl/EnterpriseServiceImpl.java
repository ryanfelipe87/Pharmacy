package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.EnterpriseDTO;
import com.project.pharmacy.models.Enterprise;
import com.project.pharmacy.repositories.EnterpriseRepository;
import com.project.pharmacy.services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {


    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Override
    public EnterpriseDTO createEnterprise(EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = new Enterprise();
        enterprise.setName(enterpriseDTO.getName());
        enterprise.setCnpj(enterpriseDTO.getCnpj());
        enterprise.setNumberEnterprise(enterpriseDTO.getNumberEnterprise());
        enterprise.setAddress(enterpriseDTO.getAddress());
        enterprise.setNeighborhood(enterpriseDTO.getNeighborhood());
        enterprise.setCep(enterpriseDTO.getCep());

        enterprise = enterpriseRepository.save(enterprise);

        return convertToDTO(enterprise);
    }

    @Override
    public List<EnterpriseDTO> listAllEnterprise() {
        List<Enterprise> enterprises = enterpriseRepository.findAll();
        return enterprises.stream()
                .map(this :: convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EnterpriseDTO getEnterpriseById(Long id) {
        Enterprise enterprise = enterpriseRepository.findById(id).orElse(null);
        if(enterprise != null){
            return convertToDTO(enterprise);
        }
        return null;
    }

    @Override
    public EnterpriseDTO updateEnterprise(Long id, EnterpriseDTO enterpriseDTO) {
        Optional<Enterprise> enterpriseOptional = enterpriseRepository.findById(id);
        if(enterpriseOptional.isPresent()){
            Enterprise enterprise = enterpriseOptional.get();
            enterprise.setName(enterpriseDTO.getName());
            enterprise.setCnpj(enterpriseDTO.getCnpj());
            enterprise.setNumberEnterprise(enterpriseDTO.getNumberEnterprise());
            enterprise.setAddress(enterpriseDTO.getAddress());
            enterprise.setNeighborhood(enterpriseDTO.getNeighborhood());
            enterprise.setCep(enterpriseDTO.getCep());

            enterprise = enterpriseRepository.save(enterprise);

            return convertToDTO(enterprise);
        }
        return null;
    }

    @Override
    public void deleteEnterprise(Long id) {
        enterpriseRepository.deleteById(id);
    }


    public EnterpriseDTO convertToDTO(Enterprise enterprise){
        EnterpriseDTO enterpriseDTO = new EnterpriseDTO();
        enterpriseDTO.setName(enterprise.getName());
        enterpriseDTO.setCnpj(enterprise.getCnpj());
        enterpriseDTO.setNumberEnterprise(enterprise.getNumberEnterprise());
        enterpriseDTO.setAddress(enterprise.getAddress());
        enterpriseDTO.setNeighborhood(enterprise.getNeighborhood());
        enterpriseDTO.setCep(enterprise.getCep());
        return enterpriseDTO;
    }
}

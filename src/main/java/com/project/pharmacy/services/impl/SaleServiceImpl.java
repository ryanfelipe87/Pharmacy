package com.project.pharmacy.services.impl;

import com.project.pharmacy.dtos.SaleDTO;
import com.project.pharmacy.models.Sale;
import com.project.pharmacy.repositories.SaleRepository;
import com.project.pharmacy.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService{

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public SaleDTO createSale(SaleDTO saleDTO) {
        Sale sale = new Sale();
        sale.setDateSale(saleDTO.getDateSale());
        sale.setTotalSale(saleDTO.getTotalSale());

        sale = saleRepository.save(sale);

        return convertToDTO(sale);
    }

    @Override
    public List<SaleDTO> listAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales.stream()
                .map(this :: convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        Sale sale = saleRepository.findById(id).orElse(null);
        if(sale != null){
            return convertToDTO(sale);
        }
        return null;
    }

    @Override
    public SaleDTO updateSale(Long id, SaleDTO saleDTO) {
        Optional<Sale> saleOptional = saleRepository.findById(id);
        if(saleOptional.isPresent()){
            Sale sale = saleOptional.get();
            sale.setDateSale(saleDTO.getDateSale());
            sale.setTotalSale(saleDTO.getTotalSale());

            sale = saleRepository.save(sale);

            return convertToDTO(sale);
        }
        return null;
    }

    @Override
    public void deleteSale(Long id) {
        saleRepository.deleteById(id);
    }

    public SaleDTO convertToDTO(Sale sale){
        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setDateSale(sale.getDateSale());
        saleDTO.setTotalSale(sale.getTotalSale());
        return saleDTO;
    }
}

package com.kiel.dsmeta.services;

import com.kiel.dsmeta.entities.Sale;
import com.kiel.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public List<Sale> findAll() {
        return repository.findAll();
    }

}

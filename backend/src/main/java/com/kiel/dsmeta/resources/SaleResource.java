package com.kiel.dsmeta.resources;

import com.kiel.dsmeta.entities.Sale;
import com.kiel.dsmeta.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<List<Sale>> findAll() {
        List<Sale> sales = service.findAll();
        return ResponseEntity.ok().body(sales);
    }

}

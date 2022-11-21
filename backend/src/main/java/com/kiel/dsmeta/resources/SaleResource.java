package com.kiel.dsmeta.resources;

import com.kiel.dsmeta.entities.Sale;
import com.kiel.dsmeta.services.SaleService;
import com.kiel.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

    @Autowired
    private SaleService service;

    @Autowired
    private SmsService smsService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                                Pageable pageable) {
        Page<Sale> sales = service.findSales(minDate, maxDate, pageable);
        return ResponseEntity.ok().body(sales);
    }

    @GetMapping("/{id}/notification")
    public ResponseEntity<Void> notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
        return ResponseEntity.noContent().build();
    }

}

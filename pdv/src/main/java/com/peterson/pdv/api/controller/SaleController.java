package com.peterson.pdv.api.controller;

import com.peterson.pdv.api.exceptionhandler.InvalidOperationException;
import com.peterson.pdv.api.exceptionhandler.NoItemException;
import com.peterson.pdv.api.model.sale.SaleRequestDTO;
import com.peterson.pdv.domain.service.sale.SaleService;
import jdk.management.jfr.RemoteRecordingStream;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@NoArgsConstructor
@Data
@RequestMapping ("/sale")
public class SaleController {

    @Autowired
    private SaleService saleService;


    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(saleService.findAll(),HttpStatus.OK);
    }

    @GetMapping ("{id}")
    public ResponseEntity getById(@PathVariable long id) {
        try {
            return new ResponseEntity(saleService.getById(id), HttpStatus.OK);
        } catch (NoItemException | InvalidOperationException error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity post (@RequestBody SaleRequestDTO saleRequestDTO){
        try {
            long id = saleService.save(saleRequestDTO);
            return new ResponseEntity<>("Venda Realizada com sucesso: " + id, HttpStatus.CREATED);
        } catch (NoItemException | InvalidOperationException error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

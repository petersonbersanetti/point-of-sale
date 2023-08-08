package com.peterson.pdv.api.controller;

import com.peterson.pdv.api.repository.ProductRepository;
import com.peterson.pdv.domain.model.product.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public List<Product> getAll(){
        return productRepository.findAll();
        //return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody Product product){
        try {
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.CREATED);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody Product product){
        try{
            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete (@PathVariable long id){
        try{
            productRepository.deleteById(id);
            return new ResponseEntity<>("Produto removido com sucesso!", HttpStatus.OK);
        }catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

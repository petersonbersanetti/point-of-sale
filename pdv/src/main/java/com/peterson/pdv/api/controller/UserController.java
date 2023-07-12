package com.peterson.pdv.api.controller;

import com.peterson.pdv.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public ResponseEntity getAll(){
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        }

    @PostMapping()
    public ResponseEntity post (RequestBody User user){
        try{
            return new ResponseEntity(userRepository.save(user), HttpStatus.CREATED);
        }catch (Exception erro){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}


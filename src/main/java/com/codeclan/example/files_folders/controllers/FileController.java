package com.codeclan.example.files_folders.controllers;


import com.codeclan.example.files_folders.models.File;
import com.codeclan.example.files_folders.models.User;
import com.codeclan.example.files_folders.repositories.FileRepository;
import com.codeclan.example.files_folders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping(value = "/files")
    public ResponseEntity<List<File>> getAllUFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/files/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/files")
    public ResponseEntity<File> postFile(@RequestBody File file){
        File newFile = fileRepository.save(file);
        return new ResponseEntity<>(newFile, HttpStatus.CREATED);
    }
}
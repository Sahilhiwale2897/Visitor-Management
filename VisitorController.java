package com.aai.visitorcheck.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aai.visitorcheck.model.Visitor;
import com.aai.visitorcheck.repository.VisitorRepository;

import jakarta.persistence.Entity;

@RestController
@RequestMapping("/api/visitors")
@CrossOrigin(origins = "*")
public class VisitorController {

    @Autowired
    private VisitorRepository visitorRepository;


    @GetMapping
    public List<Visitor> getAllVisitors(){
        return visitorRepository.findAll();    
    }

    @PostMapping
    public Visitor addVisitor(@RequestBody Visitor visitor){
        visitor.setCheckInTime(LocalDateTime.now());
        return visitorRepository.save(visitor);
    }


    @PutMapping("/{id}/checkout")
    public Visitor checkOutVisitor(@PathVariable Long id){
        Visitor visitor = visitorRepository.findById(id).orElseThrow();
        visitor.setCheckOutTime(LocalDateTime.now());
        return visitorRepository.save(visitor);
    }


    @DeleteMapping("/{id}")
    public void deleteVisitor(@PathVariable Long id){
        visitorRepository.deleteById(id);
    }

}

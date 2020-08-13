package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    ZooService zooService;

    //GET http://localhost:2019/zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping(value = "/zoos", produces = "application/json")
    public ResponseEntity<?> listZoos()
    {
        List<Zoo> allZoos = zooService.findAll();
        return new ResponseEntity<>(allZoos, HttpStatus.OK);
    }

    //GET http://localhost:2019/zoos/zoo/{id} - returns all information related to a zoo based on its id
    @GetMapping(value = "/zoo/{zooid}", produces = "application/json")
    public ResponseEntity<?> getZooById(@PathVariable Long zooid)
    {
        Zoo z = zooService.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }
}

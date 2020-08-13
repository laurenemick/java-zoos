package com.lambdaschool.zoos.controllers;

import com.lambdaschool.zoos.models.Animal;
import com.lambdaschool.zoos.services.AnimalService;
import com.lambdaschool.zoos.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController
{
    @Autowired
    private AnimalService animalServices;

    // GET http://localhost:2019/animals/count - that returns a JSON object list listing the animals and a count of how many zoos where they can be found. Use a custom query for this.
    @GetMapping(value = "/count", produces = "application/json")
    public ResponseEntity<?> getAnimalCount()
    {
        List<AnimalCounts> myList = animalServices.getAnimalCounts();
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }
}

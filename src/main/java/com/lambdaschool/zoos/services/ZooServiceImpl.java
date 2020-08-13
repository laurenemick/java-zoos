package com.lambdaschool.zoos.services;

import com.lambdaschool.zoos.models.Zoo;
import com.lambdaschool.zoos.repository.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    ZooRepository zoorepos;

    @Override
    public List<Zoo> findAll()
    {
        List<Zoo> list = new ArrayList<>();
        zoorepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id)
    {
        return zoorepos.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Zoo id: " + id + " Not Found!"));
    }
}

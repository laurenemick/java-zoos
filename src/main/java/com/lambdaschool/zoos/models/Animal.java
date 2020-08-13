package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "animals")
public class Animal extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long animalid;

    private String animaltype;

    @ManyToOne
    @JoinColumn(name = "zooid",
        nullable = false) // primary key inside of zoo, sql handles in relational DB
    @JsonIgnoreProperties("animals")
    private Animal animal; // java handles as object

    @ManyToMany(mappedBy = "animals")
    @JsonIgnoreProperties(value = "animals")
    private Set<Zoo> zoos = new HashSet<>();

    public Animal()
    {
    }

    public Animal(
        long animalid,
        String animaltype)
    {
        this.animalid = animalid;
        this.animaltype = animaltype;
    }

    public long getAnimalid()
    {
        return animalid;
    }

    public void setAnimalid(long animalid)
    {
        this.animalid = animalid;
    }

    public String getAnimaltype()
    {
        return animaltype;
    }

    public void setAnimaltype(String animaltype)
    {
        this.animaltype = animaltype;
    }

    public Set<Zoo> getZoos()
    {
        return zoos;
    }

    public void setZoos(Set<Zoo> zoos)
    {
        this.zoos = zoos;
    }
}

package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "zooanimals")
@IdClass(Zooanimalsid.class)
public class Zooanimals extends Auditable implements Serializable
{
    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "zoos")
    @JoinColumn(name = "animalid")
    private Animal animal;

    @Id
    @ManyToOne
    @JsonIgnoreProperties(value = "animals")
    @JoinColumn(name = "zooid")
    private Zoo zoo;

    @JoinColumn(name = "incomingzoo")
    private String incomingzoo;

    public Zooanimals()
    {
    }

    public Zooanimals(
        Animal animal,
        Zoo zoo,
        String incomingzoo)
    {
        this.animal = animal;
        this.zoo = zoo;
        this.incomingzoo = incomingzoo;
    }

    public Animal getAnimal()
    {
        return animal;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }

    public String getIncomingzoo()
    {
        return incomingzoo;
    }

    public void setIncomingzoo(String incomingzoo)
    {
        this.incomingzoo = incomingzoo;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Zooanimals that = (Zooanimals) o;
        return ((this.animal == null) ? 0 : this.getAnimal().getAnimalid()) == ((that.zoo == null) ? 0 : that.getZoo().getZooid()) &&
        ((this.zoo == null) ? 0 : this.getZoo().getZooid()) == ((that.animal == null) ? 0 : that.getAnimal().getAnimalid());
    }

    @Override
    public int hashCode()
    {
        return 37;
    }
}

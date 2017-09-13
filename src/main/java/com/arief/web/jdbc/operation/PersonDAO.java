package com.arief.web.jdbc.operation;

import com.arief.web.entity.Person;

import java.util.List;

public interface PersonDAO {
    void save(Person p);
    List<Person> getAll();
    Person getOne(int kode);
    void delete(int kode);
    void update(int oldKode , Person newPerson);
}

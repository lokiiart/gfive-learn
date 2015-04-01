package com.springapp.mvc.service;

import com.springapp.mvc.model.Person;

import java.util.List;

/**
 * Created by loki on 3/31/15.
 */
public interface PersonService {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
}

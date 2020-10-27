package com.telran.repo;

import com.telran.person.model.Person;
import com.telran.person.repo.IPersonRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collection;
import java.util.Iterator;

@DataJpaTest
class IPersonRepoIntegrationTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    IPersonRepo personRepo;

    @Test
    public void testFindAllByName_onePerson_existing() {
        Person person = new Person("Vasily");
        person.setAge(20);
        person.setSecondName("Vasin");

        entityManager.persist(person);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByName("Vasily");

        assertEquals(1, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person.getAge(), personFromDb.getAge());
        assertEquals(person.getName(), personFromDb.getName());
        assertEquals(person.getSecondName(), personFromDb.getSecondName());

        assertTrue(personFromDb.getId() > 0);
    }

    @Test
    public void testFindAllBySecondNameEndingWith() {
        Person person1 = new Person("Ivan");
        person1.setAge(30);
        person1.setSecondName("Ivanov");

        Person person2 = new Person("Peter");
        person2.setAge(40);
        person2.setSecondName("Petrov");

        Person person3 = new Person("Otto");
        person3.setAge(12);
        person3.setSecondName("Ivanov");

        Person person4 = new Person("Inna");
        person4.setAge(10);
        person4.setSecondName("Putin");

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.persist(person4);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllBySecondNameEndingWith("ov");

        assertEquals(3, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();


        assertEquals(person1.getAge(), personFromDb.getAge());
        assertEquals(person1.getName(), personFromDb.getName());
        assertEquals(person1.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();

        assertEquals(person2.getAge(), personFromDb.getAge());
        assertEquals(person2.getName(), personFromDb.getName());
        assertEquals(person2.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();

        assertEquals(person3.getAge(), personFromDb.getAge());
        assertEquals(person3.getName(), personFromDb.getName());
        assertEquals(person3.getSecondName(), personFromDb.getSecondName());

        assertTrue(personFromDb.getId() > 0);
    }

    @Test
    public void findAllByAgeBetweenTwoValues() {
        Person person1 = new Person("Ivan");
        person1.setAge(30);
        person1.setSecondName("Ivanov");

        Person person2 = new Person("Peter");
        person2.setAge(40);
        person2.setSecondName("Petrov");

        Person person3 = new Person("Otto");
        person3.setAge(12);
        person3.setSecondName("Ivanov");

        Person person4 = new Person("Inna");
        person4.setAge(10);
        person4.setSecondName("Putin");

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.persist(person4);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAllByAgeBetween(12, 30);

        assertEquals(2, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person1.getAge(), personFromDb.getAge());
        assertEquals(person1.getName(), personFromDb.getName());
        assertEquals(person1.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();
        assertEquals(person3.getAge(), personFromDb.getAge());
        assertEquals(person3.getName(), personFromDb.getName());
        assertEquals(person3.getSecondName(), personFromDb.getSecondName());

        assertTrue(personFromDb.getId() > 0);

    }

    @Test
    public void testFindAll() {
        Person person1 = new Person("Ivan");
        person1.setAge(30);
        person1.setSecondName("Ivanov");

        Person person2 = new Person("Peter");
        person2.setAge(40);
        person2.setSecondName("Petrov");

        Person person3 = new Person("Otto");
        person3.setAge(12);
        person3.setSecondName("Ivanov");

        Person person4 = new Person("Inna");
        person4.setAge(10);
        person4.setSecondName("Putin");

        entityManager.persist(person1);
        entityManager.persist(person2);
        entityManager.persist(person3);
        entityManager.persist(person4);
        entityManager.flush();
        entityManager.clear();

        Collection<Person> personsFromDb = personRepo.findAll();
        assertEquals(4, personsFromDb.size());

        Iterator<Person> iterator = personsFromDb.iterator();
        Person personFromDb = iterator.next();

        assertEquals(person1.getAge(), personFromDb.getAge());
        assertEquals(person1.getName(), personFromDb.getName());
        assertEquals(person1.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();

        assertEquals(person2.getAge(), personFromDb.getAge());
        assertEquals(person2.getName(), personFromDb.getName());
        assertEquals(person2.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();

        assertEquals(person3.getAge(), personFromDb.getAge());
        assertEquals(person3.getName(), personFromDb.getName());
        assertEquals(person3.getSecondName(), personFromDb.getSecondName());

        personFromDb = iterator.next();

        assertEquals(person4.getAge(), personFromDb.getAge());
        assertEquals(person4.getName(), personFromDb.getName());
        assertEquals(person4.getSecondName(), personFromDb.getSecondName());

        assertTrue(personFromDb.getId() > 0);

    }
}
package com.telran.person.repo;

import com.telran.person.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

/**
 * An instance of the class stores Person objects
 */
public interface IPersonRepo extends CrudRepository<Person, Integer> {
    Collection<Person> findAll();

    Collection<Person> findAllByName(String name);


    Collection<Person> findAllBySecondNameEndingWith(String secondName);

    @Query("select p from Person p where p.age>=:after and p.age<=:before")
    Collection<Person> findAllByAgeBeforeTwoValues(@Param("after") int after,
                                                   @Param("before") int before);

    Collection<Person> findAllByAgeGreaterThanEqual(int from);


}


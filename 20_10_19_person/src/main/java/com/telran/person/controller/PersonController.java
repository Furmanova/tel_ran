package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import com.telran.person.service.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {

    final private PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons/{id}")
    public PersonDto get(@PathVariable int id) {
        Person person = personService.get(id);
        return new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge());
    }

    @GetMapping("/persons")
    public List<PersonDto> getAll() {
        List<Person> persons = personService.getAll();
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }

    @PostMapping("/persons")
    public PersonDto create(@RequestBody PersonDto personDto) {
        Person person = personService.create(personDto.name, personDto.secondName, personDto.age);
        personDto.id = person.getId();
        return personDto;
    }

    @PutMapping("/persons/{id}")
    public void edit(@RequestBody PersonDto personDto, @PathVariable int id) {
        personService.edit(id, personDto.name, personDto.secondName, personDto.age);
    }

    @DeleteMapping("/persons/{id}")
    public PersonDto delete(@PathVariable int id) {
        Person person = personService.remove(id);
        return new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge());
    }

    // /persons/name/Vasily
    @GetMapping("/persons/name/{name}")
    public List<PersonDto> getAllByName(@PathVariable String name) {
        List<Person> persons = personService.getAllByName(name);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }

    /*@GetMapping("/persons/age")
    public List<PersonDto> getAllByAgeOlder(@RequestParam int from) {
        List<Person> persons = personService.getAllByAgeOlder(from);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }*/

    @GetMapping("/persons/age")
    public List<Person> getAllByAgeBetween(@RequestParam(required = false, defaultValue = "0") int after,
                                           @RequestParam(required = false, defaultValue = "" + Integer.MAX_VALUE) int before) {

        return personService.getAllByAgeBetween(after, before);
    }

    @GetMapping("/persons/secondName/{secondName}")
    public List<PersonDto> getAllBySecondNameEndingWith(@PathVariable String secondName) {
        List<Person> persons = personService.getAllBySecondNameEndingWith(secondName);
        return persons.stream()
                .map(person -> new PersonDto(person.getId(), person.getName(), person.getSecondName(), person.getAge()))
                .collect(Collectors.toList());
    }
}

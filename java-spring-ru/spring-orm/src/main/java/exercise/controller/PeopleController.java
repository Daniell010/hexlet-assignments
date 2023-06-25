package exercise.controller;

import exercise.model.Person;
import exercise.dto.PersonDto;
import exercise.repository.PersonRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import lombok.RequiredArgsConstructor;

import java.util.Map;


@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {

    // Автоматически заполняем значение поля
    private final PersonRepository personRepository;

    @GetMapping(path = "/{id}")
    public Person getPerson(@PathVariable long id) {
        return personRepository.findById(id).orElseThrow();
    }

    @GetMapping(path = "")
    public Iterable<Person> getPeople() {
        return this.personRepository.findAll();
    }

    // BEGIN
    @PostMapping
    public Person createPerson(@RequestBody PersonDto personDto) {
        Person person = new Person();
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return personRepository.save(person);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);
    }

    @PatchMapping(path = "/{id}")
    public Person deletePerson(@PathVariable long id, @RequestBody PersonDto personDto) {
        Person person = new Person();
        person.setId(id);
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        return personRepository.save(person);
    }
    // END
}

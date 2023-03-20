package spring.service;

import org.springframework.stereotype.Service;
import spring.domain.Person;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> persons;

    public PersonService() {
        persons = new ArrayList<>();
        persons.add(new Person("Ivan", "Ivanov"));
        persons.add(new Person("Petr", "Petrov"));
    }

    public List<Person> findAll() {
        return persons;
    }

    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        persons.add(newPerson);
    }

    public void delete(Integer id) {
       Person deletePerson = null;
        for(Person person: persons){
            if(person.getId() == id){
                deletePerson = person;
                break;
            }
        }
        if(deletePerson != null) {
            persons.remove(deletePerson);
        }
    }

    public void update(Person person) {
        for(Person pr : persons){
            if(pr.getId() == person.getId()){
                pr.setFirstName(person.getFirstName());
                pr.setLastName(person.getLastName());
            }
        }
    }

    public Person getPersonById(Integer id) {
        return persons.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}

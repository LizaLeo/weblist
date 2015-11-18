package ee.itcollege.weblist.service;

import java.util.List;

import ee.itcollege.weblist.entity.Person;

public interface PersonService {
    
    public List<Person> getPersons();
    
    public Person save(Person p);

	public void deletePerson(Person person);
    
}

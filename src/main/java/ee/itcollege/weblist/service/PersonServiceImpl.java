package ee.itcollege.weblist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ee.itcollege.weblist.dao.PersonDao;
import ee.itcollege.weblist.entity.Person;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;
    
    @Override
    public List<Person> getPersons() {
        return personDao.getAll();
    }
    
    @Override
    @Transactional
    public Person save(Person p) {
        return personDao.persist(p);
    }

	@Override
	@Transactional
	public void deletePerson(Person person) {
		personDao.delete(person);
	}
    
}

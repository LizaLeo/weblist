package ee.itcollege.weblist.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ee.itcollege.weblist.dao.PersonDao;
import ee.itcollege.weblist.dao.PersonDaoImpl;
import ee.itcollege.weblist.service.PersonService;
import ee.itcollege.weblist.service.PersonServiceImpl;

@Configuration
public class GeneralBeans {
    
    @Bean
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }
    
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
    
}

package all.personService;

import all.personDao.PersonDao;
import all.person.Person;

public class PersonService implements PersonServiceI {
    private PersonDao dao;

    public PersonService(PersonDao dao){
        this.dao =dao;
    }

    @Override
    public Person getFindName(String name, String lastName) {
        return dao.getFindName(name, lastName);
    }
}

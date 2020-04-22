package all.personDao;

import all.person.Person;

public class PersonDao implements PersonDaoI {

    public Person getFindName(String name, String lastName){
        return new Person(name, lastName);
    }
}

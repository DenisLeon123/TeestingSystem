package all.personDao;

import all.person.Person;

public interface PersonDaoI {
    Person getFindName(String name, String lastName);
}

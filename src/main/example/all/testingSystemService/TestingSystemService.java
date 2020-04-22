package all.testingSystemService;

import all.listQuestion.ListQuestion;
import all.person.Person;
import all.testingSystem.TestingSystem;

public class TestingSystemService {
    private TestingSystem testingSystem;

    public TestingSystemService(TestingSystem testingSystem){
        this.testingSystem =testingSystem;
    }

    public TestingSystem createTestingSystem(ListQuestion lQ, Person person){
        return testingSystem.createTestingSystem(lQ, person);
    }


}

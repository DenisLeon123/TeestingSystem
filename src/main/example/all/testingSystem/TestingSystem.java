package all.testingSystem;

import all.Question.Question;
import all.person.Person;
import all.listQuestion.ListQuestion;

public class TestingSystem {
    private ListQuestion lQ;
    private Person person;
    private int result =0;
    private int indexAnswer;
    private boolean firstIt =true;

    public TestingSystem createTestingSystem(ListQuestion lQ, Person person){

        TestingSystem testingSystem =new TestingSystem();
        testingSystem.lQ =lQ;
        testingSystem.person =person;
        return testingSystem;
    }

    public String getResult() {
        String s ="Студент " +person.toString() +" ответил верно на " +result +" вопросов!";
        return s ;
    }

    public void correctAnswer(){
        result++;
    }

    public Question next(){
        if (firstIt){
            firstIt =false;
        }else {
            indexAnswer++;
        }

        if(lQ.getCount() >indexAnswer) {
             return lQ.getQuest(indexAnswer);
        }else {
            return null;
        }
    }



}

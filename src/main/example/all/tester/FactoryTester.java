package all.tester;

import all.Question.Question;
import all.listQuestion.ListQuestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

//что то добавил

public class FactoryTester {
    private static String patchTest;
    private static ListQuestion listQuestion;

    public FactoryTester createFactoryTester(String patchTest){
        FactoryTester fc =new FactoryTester();
        fc.patchTest =patchTest;
        fc.listQuestion =new ListQuestion();

        return  fc;
    }

    public void createTest(){

        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(patchTest))) {

            while ((line = br.readLine()) != null) {
                String[] test = line.split(cvsSplitBy);
                ArrayList<String> answer =new ArrayList<String>();

                for(int i =1; i<5; i++) {
                    answer.add(test[i]);
                }
                Question q =new Question(test[0], answer, test[5]);
                listQuestion.setQuest(q);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ListQuestion getListQuestion() {
        return listQuestion;
    }

}

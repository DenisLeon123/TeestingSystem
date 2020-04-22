package all;

import all.Question.Question;
import all.factoryTesterService.FactoryTesterService;
import all.person.Person;
import all.personService.PersonService;
import all.tester.FactoryTester;
import all.testingSystem.TestingSystem;
import all.testingSystemService.TestingSystemService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public  static void main(String[] argc) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));

        //1. создаем студента
        PersonService personService =context.getBean(PersonService.class);

        System.out.println("Введите имя: ");
        String  name = bf.readLine();

        System.out.println("Введите фамилию: ");
        String  lastName = bf.readLine();

        Person ps =personService.getFindName(name, lastName);
        System.out.println(ps.toString());

        //2. Создаю фабрику тестов
        FactoryTesterService factoryTesterService =context.getBean(FactoryTesterService.class);
        FactoryTester factoryTester =factoryTesterService.getFactoryTester("./src/main/resources/test.csv");
        factoryTester.createTest();

        //3. Загружаю тесты в тестировочную систему и запускаю
        TestingSystemService testingSystemService =context.getBean(TestingSystemService.class);
        TestingSystem testingSystem =testingSystemService.createTestingSystem(factoryTester.getListQuestion(), ps);

        Question question;
        while ((question =testingSystem.next()) !=null){

            System.out.println(question.getQuestion());

            ArrayList<String> lA =question.getListAnswer();

            for(int i=0; i<lA.size(); i++){
                System.out.println(lA.get(i));
            }

            System.out.println("Введите верный ответ: ");
            String ans =bf.readLine();

            if(ans.equals(question.getCorrectAnswer())){
                testingSystem.correctAnswer();
            }
        }

        //4. Вывожу результат
        System.out.println(testingSystem.getResult());


        /* old
        //1. Справшиваю имя и фамилию у студента
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите имя: ");
        String  name = bf.readLine();

        System.out.println("Введите фамилию: ");
        String  lastName = bf.readLine();

        Person ps =new Person(name, lastName);

        //2. Создаю фабрику тестов
        FactoryTester fc = new FactoryTester("./src/main/resources/test.csv");
        fc.createTest();

        //3. Запускаю тестировачную систему
        TestingSystem ts =new TestingSystem(fc.getListQuestion(), ps);

        Question question;
        while ((question =ts.next()) !=null){

            System.out.println(question.getQuestion());

            ArrayList<String> lA =question.getListAnswer();

            for(int i=0; i<lA.size(); i++){
                System.out.println(lA.get(i));
            }

            System.out.println("Введите верный ответ: ");
            String ans =bf.readLine();

            if(ans.equals(question.getCorrectAnswer())){
                ts.correctAnswer();
            }
        }

        //4. Вывожу результат
        System.out.println(ts.getResult());

         */

    }
}

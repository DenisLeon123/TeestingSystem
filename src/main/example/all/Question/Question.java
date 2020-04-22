package all.Question;

import java.util.ArrayList;

public class Question {
    //текст вопроса
    private String question;
    //правильный ответ
    private String correctAnswer;
    //список ответов
    private ArrayList<String> listAnswer =new ArrayList<String>();

    public Question(String question, ArrayList<String> listAnswer, String correctAnswer){
        this.question =question;
        this.correctAnswer =correctAnswer;
        this.listAnswer =listAnswer;

        String s ="hello";
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getListAnswer() {
        return listAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

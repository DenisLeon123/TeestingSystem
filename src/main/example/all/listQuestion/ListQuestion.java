package all.listQuestion;

import all.Question.Question;

import java.util.ArrayList;

public class ListQuestion implements ListQuestionI {
    private static ArrayList<Question> listQuest;
    private int count;

    public ListQuestion(){
        this.listQuest = new ArrayList<Question>();
    }

    public Question getQuest(int Index) {
       return listQuest.get(Index);
    }

    public void setQuest(Question q) {
        listQuest.add(q);
        this.count++;
    }

    public int getCount() {
        return count;
    }
}

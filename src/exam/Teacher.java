package exam;

import java.util.ArrayList;

public class Teacher {

    public int checkPaper(String[] answers, ArrayList<Question> paper) {
        System.out.println("老师正在阅卷,请耐性等候......");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int score = 0;
        for (int i = 0; i < paper.size(); i++) {
            Question question = paper.get(i);
            if (question.getAnswer().equalsIgnoreCase(answers[i])) {
                score += (100 / paper.size());
            }
        }
        return score;
    }

}

package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String userName;

    private String password;

    public Student(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public String[] exam(ArrayList<Question> paper) {
        String[] answers = new String[paper.size()];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < paper.size(); i++) {
            Question question = paper.get(i);
            System.out.println((i + 1) + "." + question.getTitle());
            System.out.println("请输入您认为正确的选项？");
            answers[i] = scanner.nextLine();
        }
        return answers;
    }
}

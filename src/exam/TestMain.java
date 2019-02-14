package exam;

import java.util.ArrayList;
import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        //创建考试机
        ExamMachine examMachine = new ExamMachine();
        Scanner scanner = new Scanner(System.in);
        System.out.println("欢迎进入考试系统，\n请输入用户名:");
        String userName = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        Student student = new Student(userName, password);
        //学生登录
        boolean login = examMachine.login(student.getUserName(), student.getPassword());
        if (login) {
            System.out.println("登录成功\n" + student.getUserName() + "开始考试......");
            ArrayList<Question> paper = examMachine.getPaper();
            String[] answers = student.exam(paper);
            Teacher teacher = new Teacher();
            int score = teacher.checkPaper(answers, paper);
            System.out.println("学生  " + student.getUserName() + "   最终的考试成绩为:" + score + "分");
        } else  {
            System.out.println("用户名或密码错误");
        }
    }

}

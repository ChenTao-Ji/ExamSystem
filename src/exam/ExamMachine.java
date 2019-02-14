package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ExamMachine {

    /**
     * 属性---记录学生账号及密码
     */
    private HashMap<String, String> userBox = new HashMap<>();

    //利用代码块初始化HashMap集合内的用户信息
    {
        userBox.put("student1", "password");
        userBox.put("student2", "password");
        userBox.put("student3", "password");
        userBox.put("student4", "password");
    }

    /**
     * 属性-题库  好多Question类型的对象  每一个对象是一道题目
     * 使用Set集合 如果题库进行扩充 产生重复题目可以自动去掉(重写Question类的hashCode 及 equals方法)
     */
    private HashSet<Question> questionBank = new HashSet<>();

    //利用块初始化HashSet集合内的题目对象
    {
        questionBank.add(new Question("以下选项那个是Java基本数据类型？ \n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math", "C"));
        questionBank.add(new Question("以下选项那个不是Java基本数据类型？ \n\tA.String\n\tB.int\n\tC.boolean\n\tD.double", "A"));
        questionBank.add(new Question("以下选项那个是Java引用数据类型？ \n\tA.String\n\tB.int\n\tC.boolean\n\tD.char", "A"));
    }

    /**
     * 设计一个方法  随机生成一份试卷
     * 参数 无
     * 返回 试卷ArrayList<Question>
     */
    public ArrayList<Question> getPaper() {
        System.out.println("考试机正在生成试卷,请耐心等候......");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //去除重复的题目 HashSet   无序 采用HashSet--->ArrayList
        HashSet<Question> paper = new HashSet<>();
        //随机从题库重取题目  HashSet无序 题库 ---> HashSet --->ArrayList
        ArrayList<Question> questionBank = new ArrayList<>(this.questionBank);
        while (paper.size() != 2) {
            //随机取
            int index = new Random().nextInt(this.questionBank.size());
            paper.add(questionBank.get(index));
        }
        return new ArrayList<>(paper);
    }

    /**
     * 用户登录方法
     * 参数 用户名 密码
     * 返回 是否登录成功
     */
    public boolean login(String userName, String password) {
        String realPassword = userBox.get(userName);
        if (null != realPassword && password.equals(realPassword)) {
            return true;
        }
        return false;
    }

}

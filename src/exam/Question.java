package exam;

public class Question {

    private String title;
    private String answer;

    public Question(String title, String answer) {
        this.title = title;
        this.answer = answer;
    }

    public String getTitle() {
        return title;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Question) {
            Question question = (Question) object;
            if (this.title.equals(question.getTitle())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.title.hashCode();
    }
}

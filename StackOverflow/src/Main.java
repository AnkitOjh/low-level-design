import Entity.Posts;
import Entity.Question;
import Entity.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Stack Overflow");
        User user = new User("Ankit");
        Posts posts = new Posts();
        Question question = new Question(user,"What is your name",1);
        StackOverflowMain stackOverflowMain = StackOverflowMain.getInstance(posts);
        stackOverflowMain.addQuestion(question);
        stackOverflowMain.searchQuestion("keyword","name");
        stackOverflowMain.addAnswer("Ankit is my name",user,1);
        stackOverflowMain.addVote(true,"question",1);
        stackOverflowMain.addVote(true,"question",1);
        stackOverflowMain.addVote(true,"question",1);
        System.out.println(question.getUpdateTotalUpVote());
        System.out.println("Reputation =>"+user.getReputation());
    }
}
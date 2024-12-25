import Entity.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class StackOverflowMain {
    private Posts posts;
    private static StackOverflowMain instance;

    private StackOverflowMain(Posts posts){
        this.posts = posts;
    }
    public StackOverflowMain getInstance(Posts posts){
        if(instance != null){
            return instance;
        }
        else{
            return new StackOverflowMain(posts);
        }
    }

    public void addQuestion(Question question){
        this.posts.addQuestion(question);
    }
    public void addAnswer(String ans, User user,int id){
        Question question = this.posts.searchQuestionById(id);
        if(question == null){
            System.out.println("No question found");
        }
        else{
            if(ans.isBlank()){
                System.out.println("Answer can't be blank");
            }
            else{
                System.out.println("Answer added succesfully");
                Answer answer = new Answer(ans,user,question);
                this.posts.addAnswer(answer);
            }

        }
    }

    public void addVote(boolean type, String  check, int id) {
        this.posts.addVote(type,check,id);
    }

    public List<String> searchQuestion(String searchType,String key){
        List<Question> questionList = this.posts.searchQuestion(searchType, key);
        List<String> questionName = new ArrayList<>();
        questionList.forEach(question -> {
            questionName.add(question.getQuestion());
        });
        return questionName;
    }

    public void postCommentOnAnswer(String comment, int answerId, String type){
        if(comment.isBlank()){
            System.out.println("You can't post empty comments");
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convert to string
        String formattedDateTime = now.format(formatter);
        Comment comment1 = new Comment(comment,formattedDateTime,formattedDateTime);
        if(type.equalsIgnoreCase("question")){
            this.posts.postCommentOnQuestion(comment1,answerId);
        }
        else{
            this.posts.postCommentOnAnswer(comment1,answerId);
        }
    }



}

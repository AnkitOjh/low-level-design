package Entity;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private int id;
    private User user;
    private List<Answer> answerList;

    private String question;
    private int totalUpVote;
    private int totalDownVote;
    private List<Comment> commentList;
    public Question(User user, String question){
        this.user = user;
        this.question = question;
        this.answerList = new ArrayList<>();
        this.totalUpVote = 0;
        this.totalDownVote = 0;
        this.commentList = new ArrayList<>();
    }

    public void updateTotalUpvote(){
        this.totalUpVote+=1;
        this.user.setReputation((int) (totalUpVote/2));
    }
    public void updateTotalDownVote(){
        this.totalDownVote+=1;
    }

    public int getUpdateTotalUpVote(){
        return this.totalUpVote;
    }

    public int getUpdateTotalDownVote(){
        return this.totalDownVote;
    }

    public boolean isKeyWordPresent(String keyword){
        return this.question.contains(keyword);
    }

    public boolean isUserNameMatch(String userName){
        return this.user.getUserName().equalsIgnoreCase(userName);
    }

    public int getId(){
        return this.id;
    }

    public void addComment(Comment comment){
        this.commentList.add(comment);
    }

    public String getQuestion(){
        return this.question;
    }

//    public boolean isTagMatch(){
//        return
//    }



}

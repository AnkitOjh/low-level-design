package Entity;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private int id;
    private String answer;
    private User user;
    private List<Comment> comment;
    private int totalUpVote;
    private int totalDownVote;
    private Question question;

    public Answer(String answer,User user,Question question){
        this.answer = answer;
        this.user = user;
        comment = new ArrayList<>();
        this.totalUpVote = 0;
        this.totalDownVote = 0;
        this.question = question;
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

    public void addComment(Comment comment){
        this.comment.add(comment);
    }

    public int getId(){
        return this.getId();
    }
}

package Entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Posts {
    private List<Question> questionList;
    private List<Answer> answerList;

    public Posts(){
        this.answerList = new ArrayList<>();
        this.questionList = new ArrayList<>();
    }

    public void addQuestion(Question question){
        questionList.add(question);
    }
    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }
    public void postCommentOnAnswer(Comment comment,int answerId){
        Answer answer = searchAnswerById(answerId);
        if(answer != null){
            System.out.println("Comment is added to answer");
            answer.addComment(comment);
        }
        else{
            System.out.println("No answer found to comment");
        }
    }

    public void postCommentOnQuestion(Comment comment,int questionId){
        Question question = searchQuestionById(questionId);
        if(question != null){
            System.out.println("Comment is added to question");
            question.addComment(comment);
        }
        else{
            System.out.println("No answer found to question");
        }
    }

    private Answer searchAnswerById(int answerId){
        return this.answerList.stream().filter(answer ->
                answer.getId() == answerId
        ).findFirst().orElse(null);
    }

    public Question searchQuestionById(int questionId){
        return this.questionList.stream().filter(question ->
            question.getId() == questionId
        ).findFirst().orElse(null);
    }

    public void addVote(boolean type, String  check, int id){
        if(check.equals("answer")) {
            Answer answer = searchAnswerById(id);
            if(answer != null) {
                if(type == true){
                    answer.updateTotalUpvote();
                    System.out.println("Answer Up Voted added succesfully");
                }
                else{
                    answer.getUpdateTotalDownVote();
                    System.out.println("Answer Down Voted added succesfully");
                }
            }
            else {
                System.out.println("Answer id is wrong ");
            }
        } else{
            Question question = searchQuestionById(id);
            if(question != null) {
                if(type == true){
                    question.updateTotalUpvote();
                    System.out.println("Question Up Voted added succesfully");
                }
                else{
                    question.getUpdateTotalDownVote();
                    System.out.println("Question down Voted added succesfully");
                }
            }
            else {
                System.out.println("Question id is wrong ");
            }
        }
    }

    public List<Question> searchQuestion(String searchType,String key){
        if(searchType.equals("username")){
            return this.questionList.stream().filter(question -> question.isUserNameMatch(key))
                    .collect(Collectors.toList());
        }
        else if(searchType.equalsIgnoreCase("keyword")){
            return this.questionList.stream().filter(question -> question.isKeyWordPresent(key))
                    .collect(Collectors.toList());
        }
        else{
            return new ArrayList<>();
        }
    }


}

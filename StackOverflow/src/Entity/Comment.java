package Entity;

public class Comment {
    private int id;
    private String comment;
    private String updateDate;

    private String createdDate;

    private User user;

    public Comment(String comment, String updateDate, String createdDate){
        this.comment = comment;
        this.updateDate = updateDate;
        this.createdDate = createdDate;
    }

    public void setUpdateDate(String date){
        this.updateDate = updateDate;
    }
}

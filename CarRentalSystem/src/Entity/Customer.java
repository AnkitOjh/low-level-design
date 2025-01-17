package Entity;

public class Customer {
    private String userName;
    private Long contactDetail;

    public Customer(String userName, Long contactDetail){
        this.userName = userName;
        this.contactDetail = contactDetail;
    }

    public String getUserName(){
        return this.userName;
    }
    public Long getContactDetail(){
        return this.contactDetail;
    }

}

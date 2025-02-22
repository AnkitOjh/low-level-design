package Entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private List<Transaction> transactionList;
    private PortFolia portFolia;

    public User(String userName){
        this.transactionList = new ArrayList<>();
        portFolia = new PortFolia(userName);
    }

    public PortFolia getPortFolia(){
        return this.portFolia;
    }

    public String getUserName(){
        return this.userName;
    }

    public List<Transaction> getTransactionList(){
        return this.transactionList;
    }

}

package Entity;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String userName;
    private List<Order> orderList;
    private PortFolia portFolia;

    public User(String userName){
        this.orderList = new ArrayList<>();
        portFolia = new PortFolia(userName);
    }

    public PortFolia getPortFolia(){
        return this.portFolia;
    }

}

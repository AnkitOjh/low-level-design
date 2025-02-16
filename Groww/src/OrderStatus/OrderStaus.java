package OrderStatus;

import Entity.Order;

public enum OrderStaus {
    PENDING("Pending"),PAID("Paid");
    private final String description;

    OrderStaus(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }



}

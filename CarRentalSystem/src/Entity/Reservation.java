package Entity;

import java.time.LocalDateTime;

public class Reservation {
    private String id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Car car;
    private Customer customer;

    public Reservation(LocalDateTime startDate, LocalDateTime endDate, Car car, Customer customer){
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Car getCar(){
        return this.car;
    }

    public LocalDateTime getStartDate(){
        return this.startDate;
    }

    public LocalDateTime getEndDate(){
        return this.endDate;
    }

    public void setStartDate(LocalDateTime startDate, LocalDateTime endDate){
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}

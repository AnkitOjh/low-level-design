package Entity;

public class Reservation {
    private int id;
    private String startDate;
    private String endDate;
    private Car car;
    private Customer customer;

    public Reservation(String startDate, String endDate, Car car, Customer customer){
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

    public String getStartDate(){
        return this.startDate;
    }

    public String getEndDate(){
        return this.endDate;
    }
}

package Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String company;
    private String model;
    private BigDecimal rentPrice;
    private String carType;
    private String year;

    private String numberPlate;

    private List<Reservation> reservationList;
    private List<Customer> customerList;


    public Car(String company, String model, BigDecimal rentPrice,
               String year){
        reservationList = new ArrayList<>();
        customerList = new ArrayList<>();
        this.year = year;
        this.model = model;
        this.company = company;
        this.rentPrice = rentPrice;
    }

    public List<Reservation> getResrvation(){
        return this.reservationList;
    }

    public List<Customer> getCustomerList(){
        return this.customerList;
    }

    public String getCompany(){
        return this.company;
    }

    public String getModel(){
        return this.model;
    }

    public BigDecimal getRentPrice(){
        return this.rentPrice;
    }

    public String getCarType(){
        return this.carType;
    }
}

package Service;

import Entity.Car;
import Entity.Customer;
import Entity.Reservation;
import Payment.IPayment;
import Payment.PaymentContext;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RentalSystem {

    private static RentalSystem rentalInstance = null;
    private List<Car> carList;

    private PaymentContext paymentContext;

    private RentalSystem(){
        carList = new ArrayList<>();
    }

    public static synchronized RentalSystem getRentalInstance(){
        if(rentalInstance == null){
            return new RentalSystem();
        }
        return rentalInstance;
    }
    public synchronized List<Car> searchCar(String carType, BigDecimal topPrice,BigDecimal bottomPrice){
        List<Car> filteredCar = carList.stream().filter(car -> car.getCarType().equalsIgnoreCase(carType) && car.getRentPrice().compareTo(bottomPrice)>0 && car.getRentPrice().compareTo(topPrice)<0
        ).toList();
        return filteredCar;

    }

    public boolean checkCarAvailibility(Car car, LocalDateTime date){
        return !car.getResrvation().stream().anyMatch((reservation) -> date.compareTo(reservation.getStartDate())>0 &&
                date.compareTo(reservation.getEndDate())<0
        );
    }

    public void payment(IPayment payment){
        paymentContext = new PaymentContext(payment);
        paymentContext.execute();
        System.out.println("Payment completed car is booked" );
    }

    public synchronized void addCar(Car car){
        this.carList.add(car);
    }

    public synchronized void remove(Car car){
        this.carList.remove(car);
    }

    public synchronized Reservation createReservation(Car car, LocalDateTime starTime, Customer customer){
        if(checkCarAvailibility(car,starTime) == true){
            Reservation reservation = new Reservation(starTime,starTime.plusDays(2),car,customer);
            car.getResrvation().add(reservation);
            return reservation;
        }
        else{
            System.out.println("This car is not available");
        }
        return null;
    }

    public synchronized void modifyReservation(Car car,Reservation reservation,LocalDateTime startDate,LocalDateTime endDate){
        if(checkCarAvailibility(car,startDate) == true){
            reservation.setStartDate(startDate,endDate);
            System.out.println("Reservation has been modified");
        }
        else{
            System.out.println("Modification is not possible as car is not ther");
        }
    }

    public synchronized void cancelReservation(Car car, Reservation reservation){
        if(carList.contains(car) == true){
            car.getResrvation().remove(reservation);
        }
        else{
            System.out.println("There is not car with this object");
        }
    }

    private String generateReservationId() {
        return "RES" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}

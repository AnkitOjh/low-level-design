import Entity.Car;
import Entity.Customer;
import Entity.Reservation;
import Payment.DebitCard;
import Service.RentalSystem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        RentalSystem rentalSystem = RentalSystem.getRentalInstance();
        Car car = new Car("big","Toyota","xuv",new BigDecimal(1000),"2023");
        rentalSystem.addCar(car);
        rentalSystem.addCar(new Car("small","Tata","xuv",new BigDecimal(2300),"2100"));
        List<Car> carList = rentalSystem.searchCar("big",new BigDecimal(1500),new BigDecimal(500));
        carList.stream().forEach(car1 -> {
            System.out.println(car1.getCompany()+" "+car1.getModel()+" "+car1.getCarType());
        });
        Reservation reservation = rentalSystem.createReservation(car, LocalDateTime.of(2023, 1, 1, 10, 0),
                new Customer("Ank",112112121L));
        Reservation reservation1 = rentalSystem.createReservation(car, LocalDateTime.of(2024, 1, 1, 10, 0),
                new Customer("Ank",112112121L));
        rentalSystem.payment(new DebitCard());
        rentalSystem.modifyReservation(car,reservation,LocalDateTime.of(2023, 1, 1, 10, 0),LocalDateTime.of(2023, 1, 1, 12, 0));
        car.getResrvation().stream().forEach(reservation2 -> {
            System.out.println(reservation2.getEndDate().toString()+" "+reservation2.getStartDate().toString());
        });
        rentalSystem.cancelReservation(car,reservation1);
        car.getResrvation().stream().forEach(reservation2 -> {
            System.out.println(reservation2.getEndDate().toString()+" "+reservation2.getStartDate().toString());
        });
    }
}
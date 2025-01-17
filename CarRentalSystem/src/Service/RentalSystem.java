package Service;

import Entity.Car;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RentalSystem {
    private List<Car> carList;

    public RentalSystem(){
        carList = new ArrayList<>();
    }
    public List<Car> searchCar(String carType, BigDecimal topPrice,BigDecimal bottomPrice){
        List<Car> filteredCar = carList.stream().filter(car -> {

            return car.getModel().equalsIgnoreCase(carType) && car.getRentPrice().compareTo(bottomPrice)>0 && car.getRentPrice().compareTo(topPrice)>0;
        }).toList();
        return filteredCar;

    }

    public boolean checkCarAvailibility(Car car, String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(date);
        LocalDateTime inputDate = LocalDateTime.parse(date,formatter);
        LocalDateTime startDate;
        LocalDateTime endDate;
        return !car.getResrvation().stream().anyMatch((reservation) -> inputDate.compareTo(LocalDateTime.parse(reservation.getStartDate(),formatter))>0 &&
                inputDate.compareTo(LocalDateTime.parse(reservation.getEndDate(),formatter))<0
        );
    }

    public void addCar(Car car){
        this.carList.add(car);
    }

    public void remove(Car car){
        this.carList.remove(car);
    }
}

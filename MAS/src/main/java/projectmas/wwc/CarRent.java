package projectmas.wwc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class CarRent <T extends Person> implements Serializable {
    private LocalDate startDateOfRent;
    private LocalDate endDateOfRent;
    private T renter;
    private Car rentedCar;
    private RentType type;
    private double totalCost;
    private static List<CarRent> extent = new ArrayList<>();

    public CarRent(LocalDate startDateOfRent, LocalDate endDateOfRent, T renter, Car rentedCar, RentType type) {
        this.startDateOfRent = startDateOfRent;
        this.endDateOfRent = endDateOfRent;
        this.type = type; //do przerobienia w zaleznosci od IsPerson albo IsEmployee
        this.setPerson(renter);
        this.setCar(rentedCar);
        totalCost = getTotalCost(renter, rentedCar, startDateOfRent, endDateOfRent);
    }

    private static void addCarRent(CarRent carRent){
        extent.add(carRent);
    }

    private static void removeCarRent(CarRent carRent) {
        extent.remove(carRent);
    }

    private double getTotalCost(T renter, Car car, LocalDate startDate, LocalDate endDate){
        int days = Period.between(startDate, endDate).getDays();
        if(renter.getDiscount()!=null){
            double discount = renter.getDiscount() * (car.getRentCost() * days);
            return (car.getRentCost() * days) - discount;
        }
        return  car.getRentCost() * days;
    }

    public void setPerson(T person){
        if(!(person == null)){
            if(renter != null){
                removeRenter();
            }
            this.renter = person;
            person.addCarRent(this);
        }
    }

    public void removeRenter() {
        renter.removeCarRent(this);
        renter = null;
    }

    public void setCar(Car car){
        if(!(car == null)){
            if(rentedCar != null){
                removeCar();
            }
            this.rentedCar = car;
            car.addCarRent(this);
        }
    }

    public void removeCar() {
        rentedCar.removeCarRent(this);
        rentedCar = null;
    }

    public static void showExtent() {
        System.out.println("Extent of the class CarRent");

        for (CarRent p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<CarRent>) stream.readObject();
    }
}

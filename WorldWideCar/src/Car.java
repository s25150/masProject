import java.io.Serializable;
import java.lang.foreign.SegmentAllocator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
    private int idCar;
    private Brand brand;
    private String model;
    private Engine engine;
    private int yearOfManufacture;
    private int numberOfDoors;
    private LocalDate dateOfCreation;
    private int rentCost;
    private Rental rental;
    private List<CarRent> carRents = new ArrayList<>();
    private static List<Car> extent = new ArrayList<>();


    private static void addCar(Car car){
        extent.add(car);
    }
    public static void removeCar(Car car) {
        extent.remove(car);
    }
}

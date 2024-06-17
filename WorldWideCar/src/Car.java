import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

    public static void showExtent() {
        System.out.println("Extent of the class Car");

        for (Car p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Car>) stream.readObject();
    }
}

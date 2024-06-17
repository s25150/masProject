import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRent implements Serializable {
    private LocalDate startDateOfRent;
    private LocalDate endDateOfRent;
    private Person renter;
    private Car rentedCar;
    private RentType type;
    private static List<CarRent> extent = new ArrayList<>();

    private static void addCarRent(CarRent carRent){
        extent.add(carRent);
    }

    private static void removeCarRent(CarRent carRent) {
        extent.remove(carRent);
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

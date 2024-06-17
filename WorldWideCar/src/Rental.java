import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rental implements Serializable {
    private City city;
    private String address;
    private String idRental;
    private List<Car> cars = new ArrayList<>();
    private Manager manager;
    private List<RentalEmployee> employees;
    private static List<Rental> extent = new ArrayList<>();

    private static void addRental(Rental rental) {
        extent.add(rental);
    }

    private static void removeRental(Rental rental) {
        extent.remove(rental);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Rental");

        for (Rental p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Rental>) stream.readObject();
    }
}

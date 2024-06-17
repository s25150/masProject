import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RentalEmployee implements Serializable {
    private Rental rental;
    private static List<RentalEmployee> extent = new ArrayList<>();

    private static void addRentalEmployee(RentalEmployee rentalEmployee) {
        extent.add(rentalEmployee);
    }

    private static void removeRentalEmployee(RentalEmployee rentalEmployee) {
        extent.remove(rentalEmployee);
    }

    public static void showExtent() {
        System.out.println("Extent of the class RentalEmployee");

        for (RentalEmployee p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<RentalEmployee>) stream.readObject();
    }
}

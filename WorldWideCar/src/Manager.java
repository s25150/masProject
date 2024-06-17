import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Serializable {
    private Rental rental;
    private static List<Manager> extent = new ArrayList<>();

    private static void addManager(Manager manager){
        extent.add(manager);
    }
    private static void removeManager(Manager manager) {
        extent.remove(manager);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Manager");

        for (Manager p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Manager>) stream.readObject();
    }
}

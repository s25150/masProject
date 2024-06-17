import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarWash implements Serializable {
    private LocalTime openingTime;
    private LocalTime closingTime;
    //private boolean isAlwaysOpen;
    private String address;
    private City city;
    private static List<CarWash> extent = new ArrayList<>();

    private static void addCarWash(CarWash carWash){
        extent.add(carWash);
    }

    private static void removeCarWash(CarWash carWash) {
        extent.remove(carWash);
    }

    public static void showExtent() {
        System.out.println("Extent of the class CarWash");

        for (CarWash p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<CarWash>) stream.readObject();
    }
}

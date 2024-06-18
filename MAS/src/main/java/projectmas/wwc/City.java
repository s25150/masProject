package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private List<CarWash> carWashes = new ArrayList<>();
    private static List<City> extent = new ArrayList<>();

    private static void addCity(City city){
        extent.add(city);
    }

    private static void removeCity(City city) {
        extent.remove(city);
    }

    public static void showExtent() {
        System.out.println("Extent of the class City");

        for (City p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<City>) stream.readObject();
    }
}

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

    public City(String name) {
        this.name = name;
        addCity(this);
    }

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

    public void addRental(Rental rental) {
        if(rental!=null) {
            if (!rentals.contains(rental)) {
                rentals.add(rental);
                rental.setCity(this);
            }
        }
    }

    public void removeRental(Rental rental){
        rentals.remove(rental);
        rental.removeCity();
    }

    public void addCarWash(CarWash carWash) {
        if(carWash!=null) {
            if (!carWashes.contains(carWash)) {
                carWashes.add(carWash);
                carWash.setCity(this);
            }
        }
    }

    public void removeCarWash(CarWash carWash){
        carWashes.remove(carWash);
        carWash.removeCity();
    }
}

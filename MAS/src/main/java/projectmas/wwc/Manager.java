package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Map;
import java.util.TreeMap;

public class Manager extends Employee implements Serializable {
    private Rental rental;
    private static List<Manager> extent = new ArrayList<>();
    private Map<String, Rental> rentalsQualif = new TreeMap<>();

    public Manager(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
        addManager(this);
    }

    public void addRentalsQualif(Rental newRental){
        if(!rentalsQualif.containsKey(newRental.getRentalId())){
            rentalsQualif.put(newRental.getRentalId(), newRental);
            newRental.addManager(this);
        }
    }

    public Rental findRentalQualif(String id) throws Exception{
        if(!rentalsQualif.containsKey(id)){
            throw new Exception("Unable to find Rental: " + id);
        }

        return rentalsQualif.get(id);
    }

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

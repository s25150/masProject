package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalEmployee extends Employee implements Serializable {
    private Rental rental;
    private static List<RentalEmployee> extent = new ArrayList<>();

    private RentalEmployee(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
        addRentalEmployee(this);
    }

    public static RentalEmployee createRentalEmployee(Rental rental, String name, String surname, LocalDate birthDate)
            throws Exception{
        if(rental == null){
            throw new Exception("Wypożyczalnia nie istnieje");
        }

        RentalEmployee employee = new RentalEmployee(name, surname, birthDate);
        employee.rental = rental;
        rental.addEmployee(employee);

        return employee;

    }

    private static void addRentalEmployee(RentalEmployee rentalEmployee) {
        extent.add(rentalEmployee);
    }

    /*private static void removeRentalEmployee(RentalEmployee rentalEmployee) {
        extent.remove(rentalEmployee);
    }*/

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

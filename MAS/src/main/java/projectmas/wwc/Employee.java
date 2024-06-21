package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee extends Person implements Serializable {
    private int idEmployee;
    private static int id = 0;
    private static Double discount = 0.15;
    private static List<Employee> extent = new ArrayList<>();

    public Employee(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
        super.setPersonDiscount(discount);
        idEmployee = ++id;
        addEmployee(this);
    }

    private static void addEmployee(Employee employee){
        extent.add(employee);
    }
    private static void removeEmployee(Employee employee) {
        extent.remove(employee);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Employee");

        for (Employee p : extent) {
            System.out.println(p);
        }
    }

    public static void setDiscount(double d){
        discount = d;
        for (Employee e : extent) {
            e.setPersonDiscount(d);
        }

    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Employee>) stream.readObject();
    }
}

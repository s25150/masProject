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
}

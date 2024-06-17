import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class City implements Serializable {
    private String name;
    private List<Rental> rentals = new ArrayList<>();
    private List<CarWash> carWashes = new ArrayList<>();
    private static List<City> extent = new ArrayList<>();
}

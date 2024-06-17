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
}

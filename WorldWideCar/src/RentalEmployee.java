import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RentalEmployee implements Serializable {
    private Rental rental;
    private static List<RentalEmployee> extent = new ArrayList<>();
}

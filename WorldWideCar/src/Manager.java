import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Manager implements Serializable {
    private Rental rental;
    private static List<Manager> extent = new ArrayList<>();
}

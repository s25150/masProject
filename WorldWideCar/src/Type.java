import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Type implements Serializable {
    private String Name;
    private List<Car> cars = new ArrayList<>();
    private static List<Type> extent = new ArrayList<>();
}

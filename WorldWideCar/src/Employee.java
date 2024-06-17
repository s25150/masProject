import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
    private int idEmployee;
    private static int id = 0;
    private static Double discount = 0.15;
    private static List<Employee> extent = new ArrayList<>();
}

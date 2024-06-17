import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private int idPerson;
    private String name;
    private String surname;
    private LocalDate birthDate;
    protected Double discount;
    private List<CarRent> carRents = new ArrayList<>();
    private static int id = 0;
    private static List<Person> extent = new ArrayList<>();
}

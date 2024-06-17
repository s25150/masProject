import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CarRent implements Serializable {
    private LocalDate startDateOfRent;
    private LocalDate endDateOfRent;
    private Person renter;
    private Car rentedCar;
    private RentType type;
    private static List<CarRent> extent = new ArrayList<>();
}

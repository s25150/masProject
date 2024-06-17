import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Brand implements Serializable {
    private String name;
    private static List<Brand> extent = new ArrayList<>();
}

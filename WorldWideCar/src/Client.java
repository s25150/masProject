import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private int idClient;
    private static int id = 0;
    private List<String> likedBrands = new ArrayList<>();
    private static List<Client> extent = new ArrayList<>();
}

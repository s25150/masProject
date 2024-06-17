import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Serializable {
    private int idClient;
    private static int id = 0;
    private List<Brand> likedBrands = new ArrayList<>();
    private static List<Client> extent = new ArrayList<>();

    private static void addClient(Client client){
        extent.add(client);
    }
    private static void removeClient(Client client) {
        extent.remove(client);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Client");

        for (Client p : extent) {
            System.out.println(p);
        }
    }

    public void addLikedBrands(Brand brand){
        likedBrands.add(brand);
    }

    public List<Car> showRecommendedCars(){
        if (isAddedAnyBrand()){
            //rentalgetcars
            List<Car> fakeLikedBrands = new ArrayList<>();
            return fakeLikedBrands;
        }else{
            System.out.println("No liked brands added to client's profile");
            return null;
        }
    }

    public boolean isAddedAnyBrand(){
        return !likedBrands.isEmpty();
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Client>) stream.readObject();
    }
}

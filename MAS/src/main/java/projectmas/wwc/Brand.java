package projectmas.wwc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Brand implements Serializable {
    private String name;
    private List<Car> cars = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();
    private static List<Brand> extent = new ArrayList<>();

    public Brand(String name) {
        this.name = name;
    }

    public void addCar(Car car){
        if(car!=null) {
            if (!cars.contains(car)) {
                cars.add(car);
                car.setBrand(this);
            }
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
        car.removeBrand();
    }

    private static void addBrand(Brand brand){
        extent.add(brand);
    }
    public static void removeBrand(Brand brand) {
        extent.remove(brand);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Brand");

        for (Brand p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Brand>) stream.readObject();
    }

    public void addClient(Client client){
        if(client!=null) {
            if (!clients.contains(client)) {
                clients.add(client);
                client.addLikedBrands(this);
            }
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);
        client.removeLikedBrand(this);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "name='" + name + '\'' +
                '}';
    }
}

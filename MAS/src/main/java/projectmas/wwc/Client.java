package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client extends Person implements Serializable {
    private int idClient;
    private static int id = 0;
    private List<Brand> likedBrands = new ArrayList<>();
    private static List<Client> extent = new ArrayList<>();

    private static PersonType personType = PersonType.Client;

    public Client(String name, String surname, LocalDate birthDate) {
        super(name, surname, birthDate);
        idClient = ++id;
        addClient(this);
    }

    public Client(Employee employee) {
        super(employee.getName(), employee.getSurname(), employee.getBirthDate());
        super.setPersonDiscount(Employee.getEmployeesDiscount());
        idClient = ++id;
        addClient(this);
    } //overlapping

    public static PersonType getPersonType() {
        return personType;
    }

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


    public List<Car> showRecommendedCars() throws Exception {
        List<Car> result = new ArrayList<>();
        if (isAddedAnyBrand()){
            try {
                for (Brand b : likedBrands) {
                    result.addAll(Rental.getCarsFromBrand(b));
                }
            }catch (Exception e){
                System.err.println("Caught Exception: " + e.getMessage());
            }
            return result;
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

    public void getLikedBrands() {
        if(likedBrands.isEmpty()){
            System.out.println(this.getName() + " has 0 liked brands");
        }else {
            System.out.println("Liked brands of " + this.getName() + " " + this.getSurname() + ": ");
            for (Brand s : likedBrands) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    public void addLikedBrands(Brand brand){
        if(brand != null){
            if(!(likedBrands.contains(brand))){
                likedBrands.add(brand);
                brand.addClient(this);
            }
        }
    }

    public void removeLikedBrand(Brand brand) {
        likedBrands.remove(brand);
        brand.removeClient(this);
    }
}

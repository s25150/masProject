package projectmas.wwc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Brand implements Serializable {
    private String name;
    private static List<Brand> extent = new ArrayList<>();

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
}

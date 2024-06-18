package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Type implements Serializable {
    private String Name;
    private List<Car> cars = new ArrayList<>();
    private static List<Type> extent = new ArrayList<>();

    public Type(String name) {
        Name = name;
        addType(this);
    }

    private static void addType(Type type) {
        extent.add(type);
    }

    private static void removeType(Type type) {
        extent.remove(type);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Type");

        for (Type p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Type>) stream.readObject();
    }

}

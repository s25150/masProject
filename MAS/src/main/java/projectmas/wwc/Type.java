package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Type implements Serializable {
    private String name;
    private List<Car> cars = new ArrayList<>();
    private static List<Type> extent = new ArrayList<>();

    public Type(String name) {
        this.name = name;
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

    public void addCar(Car car) {
        if(car!=null) {
            if (!cars.contains(car)) {
                cars.add(car);
                car.setTypeCar(this);
            }
        }
    }

    public void addCarType(Car car) {
        if(car!=null) {
            if (!cars.contains(car)) {
                cars.add(car);
            }
        }
    }

    public void removeCar(Car car){
        cars.remove(car);
        car.removeTypeCar();
    }

    public void removeCarType(Car car){
        cars.remove(car);
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Type>) stream.readObject();
    }

    @Override
    public String toString() {
        return name;
    }
}

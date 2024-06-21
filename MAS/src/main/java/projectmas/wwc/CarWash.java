package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CarWash implements Serializable {
    private LocalTime openingTime;
    private LocalTime closingTime;
    //private boolean isAlwaysOpen;
    private String address;
    private City city;
    private static List<CarWash> extent = new ArrayList<>();

    public CarWash(LocalTime openingTime, LocalTime closingTime, String address, City city) {
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.address = address;
        this.setCity(city);
        addCarWash(this);
    }

    private static void addCarWash(CarWash carWash){
        extent.add(carWash);
    }

    private static void removeCarWash(CarWash carWash) {
        extent.remove(carWash);
    }

    public boolean isAlwaysOpen(){
        return openingTime == closingTime;
    }

    public static void showExtent() {
        System.out.println("Extent of the class CarWash");

        for (CarWash p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<CarWash>) stream.readObject();
    }

    public void setCity(City newCity){
        if(!(newCity == null)){
            if(city != null){
                removeCity();
            }
            this.city = newCity;
            newCity.addCarWash(this);
        }
    }

    public City getCity() {
        return city;
    }

    public void removeCity() {
        city.removeCarWash(this);
        city = null;
    }

    public List<CarWash> getCarWashesInLocation(City city) throws Exception{
        List<CarWash> result = new ArrayList<>();
        for (CarWash p : extent) {
            if(p.getCity() == city){
                result.add(p);
            }
        }
        if(result.isEmpty()){
            throw new Exception("There are no supported car washes in " + city);
        }
        return result;
    }
}

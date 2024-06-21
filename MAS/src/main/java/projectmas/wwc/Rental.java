package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Rental implements Serializable {
    private City city;
    private String address;
    private String idRental;
    private List<Car> cars = new ArrayList<>();
    private List<Manager> managers = new ArrayList<>();
    private List<RentalEmployee> employees;
    private static List<Car> allCars;
    private static List<RentalEmployee> allEmployees;
    private static List<Rental> extent = new ArrayList<>();

    public Rental(String rentalId) {
        this.idRental = rentalId;
        addRental(this);
    }

    private static void addRental(Rental rental) {
        extent.add(rental);
    }


    private static void removeRental(Rental rental) {
        extent.remove(rental);
        for(RentalEmployee re: rental.employees){
            allEmployees.removeIf(allemp -> re == allemp);
            rental.removeEmployee(re);
        }
    }

    public void removeEmployee(RentalEmployee employee){
        employees.remove(employee);
        allEmployees.remove(employee);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Rental");

        for (Rental p : extent) {
            System.out.println(p);
        }
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Rental>) stream.readObject();
    }

    public String getRentalId() {
        return idRental;
    }

    public void addManager(Manager manager){
        managers.add(manager);
    }


    public void removeManager(Manager manager){
        managers.remove(manager);
    }

    public void addCar(Car car) {
        if(car!=null) {
            if (!cars.contains(car)) {
                cars.add(car);
                allCars.add(car);
                car.setRental(this);
            }
        }

    }

    public void removeCar(Car car){
        cars.remove(car);
        allCars.remove(car);
        car.removeRental();
    }

    public void setCity(City newCity){
        if(!(newCity == null)){
            if(city != null){
                removeCity();
            }
            this.city = newCity;
            newCity.addRental(this);
        }
    }

    public City getCity() {
        return city;
    }

    public void removeCity() {
        city.removeRental(this);
        city = null;
    }

    public void addEmployee(RentalEmployee employee) throws Exception{
        if(!employees.contains(employee)){
            if(allEmployees.contains(employee)){
                throw new Exception("This employee works for another rental");
            }
            employees.add(employee);
            allEmployees.add(employee);
        }
    }

    public List<Rental> getRentalsInLocation(City city) throws Exception{
        List<Rental> result = new ArrayList<>();
        for (Rental p : extent) {
            if(p.getCity() == city){
                result.add(p);
            }
        }
        if(result.isEmpty()){
            throw new Exception("There are no rentals in " + city);
        }
        return result;
    }

    public static List<Car> getCarsFromBrand(Brand brand) throws Exception {
        List<Car> result = new ArrayList<>();
        for (Car c : allCars) {
            if(c.getBrand() == brand){
                result.add(c);
            }
        }
        if(result.isEmpty()){
            throw new Exception("There are no available cars from brand " + brand);
        }
        return result;
    }

}

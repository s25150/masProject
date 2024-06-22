package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//import java.lang.foreign.SegmentAllocator;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {
    private int idCar;
    private Brand brand;
    private String model;
    private Engine engine;
    private int yearOfManufacture;
    private int numberOfDoors;
    private LocalDate dateOfCreation;
    private int rentCost;
    private Rental rental;
    private Type type;
    private static int id = 0;
    private List<CarRent> carRents = new ArrayList<>();
    private static List<Car> extent = new ArrayList<>();

    public Car(Brand brand, String model, Type type, Engine engine, int yearOfManufacture, int numberOfDoors, int rentCost) {
        this.setBrand(brand);
        this.model = model;
        this.engine = engine;
        this.yearOfManufacture = yearOfManufacture;
        this.numberOfDoors = numberOfDoors;
        this.dateOfCreation = LocalDate.now();
        this.rentCost = rentCost;
        this.setType(type);
        idCar = ++id;
        addCar(this);
    }

    public void setType(Type newType) {
        if(!(newType == null)){
            if(type != null){
                removeType();
            }
            type = newType;
            newType.addCarType(this);
        }
    }
    public void setTypeCar(Type newType) {
        if(!(newType == null)){
            if(type != null){
                removeType();
            }
            type = newType;
        }
    }

    public void removeType(){
        type.removeCarType(this);
        type = null;
    }

    public void removeTypeCar(){
        type = null;
    }



    public void setRental(Rental newRental){
        if(newRental!=null) {
            if (!(rental == null)) {
                removeRental();
            }
            rental = newRental;
            newRental.addCar(this);
        }
    }

    public void removeRental(){
        rental.removeCar(this);
        rental = null;
    }

    public void removeCarRent(CarRent carRent){
        carRents.remove(carRent);
        carRent.removeRenter();
    }


    private static void addCar(Car car){
        extent.add(car);
    }
    public static void removeCar(Car car) {
        extent.remove(car);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Car");

        for (Car p : extent) {
            System.out.println(p);
        }
    }

    public int getIdCar() {
        return idCar;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public int getRentCost() {
        return rentCost;
    }

    public Rental getRental() {
        return rental;
    }

    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Car>) stream.readObject();
    }

    public void addCarRent(CarRent carRent) {
        if(carRent!=null){
            carRents.add(carRent);
            carRent.setCar(this);
        }
    }

    public void setBrand(Brand newBrand) {
        if(newBrand!=null) {
            if (!(brand == null)) {
                removeBrand();
            }
            this.brand = newBrand;
            brand.addCarBrand(this);
        }
    }

    public void setBrandCar(Brand newBrand) {
        if(newBrand!=null) {
            if (!(brand == null)) {
                removeBrand();
            }
            this.brand = newBrand;
        }
    }

    public void removeBrand(){
        brand.removeCarBrand(this);
        brand = null;
    }

    public void removeBrandCar(Car car) {
        brand = null;
    }

    public void changeRentCost(int cost) throws Exception{
        if(cost<=0){
            throw new Exception("Illegal value, new cost must be higher than 0");
        }else{
            this.rentCost = cost;
        }
    }

    @Override
    public String toString() {
        return  brand +
                " | " + model +
                " | " + engine +
                " | " + yearOfManufacture +
                " | " + type;
    }
}

package projectmas.wwc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public abstract class Person implements Serializable {
    private int idPerson;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Double discount;
    private List<CarRent> carRents = new ArrayList<>();
    private static int id = 0;
    private static List<Person> extent = new ArrayList<>();

    public Person(String name, String surname, LocalDate birthDate) {
        idPerson = ++id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        addPerson(this);
    }

    private static void addPerson(Person person) {
        extent.add(person);
    }

    private static void removePerson(Person person) {
        extent.remove(person);
    }

    public static void showExtent() {
        System.out.println("Extent of the class Person");

        for (Person p : extent) {
            System.out.println(p);
        }
    }

    public int getAge(LocalDate birthDate){
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Double getDiscount() {
        return discount;
    }

    protected void setPersonDiscount(double disc){
        discount = disc;
    }

    public static PersonType getPersonType() {
        return null;
    }

    @Override
    public String toString() {
        return "PersonId= " + idPerson +
                ", name= " + name +
                ", surname= " + surname +
                ", age= " + getAge(birthDate);
    }
    public static void writeExtent(ObjectOutputStream stream) throws IOException {
        stream.writeObject(extent);
    }

    public static void readExtent(ObjectInputStream stream) throws IOException, ClassNotFoundException{
        extent = (ArrayList<Person>) stream.readObject();
    }

    public void addCarRent(CarRent carRent) {
        if(carRent!=null){
            carRents.add(carRent);
            carRent.setPerson(this);
        }
    }

    public void removeCarRent(CarRent carRent){
        carRents.remove(carRent);
        carRent.removeRenter();
    }
}

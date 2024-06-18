package projectmas.wwc;

import java.io.*;

public class DataBase {
    public static void readFile() {
        try {
            File f = new File("File.txt");
            if (f.exists() && !f.isDirectory()) {
                var in = new ObjectInputStream(new FileInputStream(f));
                Brand.readExtent(in);
                Car.readExtent(in);
                CarRent.readExtent(in);
                CarWash.readExtent(in);
                City.readExtent(in);
                Client.readExtent(in);
                Employee.readExtent(in);
                Manager.readExtent(in);
                Person.readExtent(in);
                Rental.readExtent(in);
                RentalEmployee.readExtent(in);
                Type.readExtent(in);
                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile(){
        try{
            var out = new ObjectOutputStream(new FileOutputStream("File.txt"));
            Brand.writeExtent(out);
            Car.writeExtent(out);
            CarRent.writeExtent(out);
            CarWash.writeExtent(out);
            City.writeExtent(out);
            Client.writeExtent(out);
            Employee.writeExtent(out);
            Manager.writeExtent(out);
            Person.writeExtent(out);
            Rental.writeExtent(out);
            RentalEmployee.writeExtent(out);
            Type.writeExtent(out);
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package projectmas.wwc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("World Wide Car - Car Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        DataBase.readFile();

        Type suv = new Type("SUV");
        Type coupe = new Type("Coupe");
        Type sedan = new Type("Sedan");
        Type hatchback = new Type("Hatchback");
        Type cabriolet = new Type("Cabriolet");
        Type crossover = new Type("Crossover");
        Type minivan = new Type("Minivan");

        Brand fiat = new Brand("Fiat");
        Brand kia= new Brand("KIA");
        Brand audi = new Brand("Audi");

        Car car1 = new Car(fiat, "Punto", hatchback, Engine.petrol, 2001, 5, 70);
        Car car2 = new Car(audi, "A3", coupe, Engine.petrol, 2008, 3, 110);
        Car car3 = new Car(kia, "Sportage", sedan, Engine.hybrid, 2020, 5, 190);
        Car car4 = new Car(audi, "Q6", suv, Engine.petrol, 2020, 5, 220);

        Client client1 = new Client("Jan", "Koziorek", LocalDate.of(1998, 2, 14), "client1");
        Client client2 = new Client("Anna", "Maneta", LocalDate.of(1987, 5, 22), "client2");

        Employee emp1 = new Employee("Andrzej", "Gotecki", LocalDate.of(1980, 1, 30));

        Client client3 = new Client(emp1, "client3");

        City warszawa = new City("Warszawa");

        Rental r1 = new Rental(warszawa, "Złota 120", "WZ120");
        Rental r2 = new Rental(warszawa, "Koszykowa 56", "WK56");

        CarWash warjer = new CarWash(LocalTime.of(8, 0), LocalTime.of(22, 0), "al. Jerozolimskie 76", warszawa);

        r1.addCar(car1);
        r1.addCar(car2);
        r1.addCar(car3);

        r2.addCar(car4);

        Manager manager1 = new Manager("Bożena", "Kowalska", LocalDate.of(1995, 10, 5));

        RentalEmployee.createRentalEmployee(r1, "Konrad", "Witecki", LocalDate.of(2000, 12, 19));

        r1.addManager(manager1);

        launch();

        client1.addLikedBrands(audi);
        client1.addLikedBrands(kia);


        //DataBase.writeFile();
    }
}
package projectmas.wwc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("World Wide Car - Car Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DataBase.readFile();

        Type suv = new Type("SUV");
        Type coupe = new Type("Coupe");
        Type sedan = new Type("Sedan");
        Type hatchback = new Type("Hatchback");
        Type cabriolet = new Type("Cabriolet");
        Type crossover = new Type("Crossover");
        Type minivan = new Type("Minivan");

        launch();
        //usunac mozliwosc duplikowania obiektow w ekstensji

        //DataBase.writeFile();
    }
}
package projectmas.wwc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.util.List;
import java.util.Objects;

public class RecommendedCarsController {
    @FXML
    private Label clientLogin;
    @FXML
    private ListView<String> recommendedCarListView;
    @FXML
    private Button mainPageButton;

    private static Rental rental;

    @FXML
    public void initialize() throws Exception {
        String userLogin = UserSession.getUserLogin();
        clientLogin.setText("Witaj " + userLogin);


        for(Car car: rental.getCars()){
            recommendedCarListView.getItems().addAll(car.toString());
        }


    }

    @FXML
    public void onGoToMainPageButtonClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("strona glowna.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) clientLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void setRental(Rental newrental) {
        rental = newrental;
    }
}

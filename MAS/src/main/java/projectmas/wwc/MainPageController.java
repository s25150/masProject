package projectmas.wwc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPageController {
    @FXML
    private Label clientLogin;

    @FXML
    private ListView<Rental> carListView;

    @FXML
    private Button showRecommendedCarsButton;



    @FXML
    public void initialize() {
        String userLogin = UserSession.getUserLogin();
        clientLogin.setText("Witaj " + userLogin);

        for(Rental r : Rental.getExtent()){
            carListView.getItems().add(r);
        }
        /*for (Car car : Rental.getAllCars()) {
            carListView.getItems().add(car.toString());
        }*/
    }

    @FXML
    public void onShowLikedBrandButtonClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("polecaneAuta.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) clientLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void onRentalClick() throws IOException {
        Rental selectedItem = carListView.getSelectionModel().getSelectedItem();
        RecommendedCarsController.setRental(selectedItem);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("polecaneAuta.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) clientLogin.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}

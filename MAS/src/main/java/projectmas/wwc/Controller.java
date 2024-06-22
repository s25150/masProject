package projectmas.wwc;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private Button SignInButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Pane SignInPane;

    @FXML
    private Pane MainPane;


    @FXML
    protected void onSignInButtonClick() {
        String login = loginField.getText();
        String password = passwordField.getText();

        if (login.equals("client1") && password.equals("password")) {
            try {
                UserSession.setUserLogin(login);

                FXMLLoader loader = new FXMLLoader(getClass().getResource("strona glowna.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) loginField.getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid login or password");
        }
    }
}
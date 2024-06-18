module projectmas.wwc {
    requires javafx.controls;
    requires javafx.fxml;


    opens projectmas.wwc to javafx.fxml;
    exports projectmas.wwc;
}
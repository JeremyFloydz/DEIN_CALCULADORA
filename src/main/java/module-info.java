module es.jeremy.demofxml {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.jeremy.demofxml to javafx.fxml;
    exports es.jeremy.demofxml;
}
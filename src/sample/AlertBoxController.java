package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBoxController {

    Main main;

    @FXML
    private Label label;

    @FXML
    private Button okayButton;

    @FXML
    void okayButtonClicked(ActionEvent event) {
        main.alertWindow.close();
    }

    public void setMain(Main main, String text) {
        label.setText(text);
        this.main = main;
    }

}

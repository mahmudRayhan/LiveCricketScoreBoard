package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SeeMatchCodeController {

    @FXML
    private Button back;

    @FXML
    void backAction(ActionEvent event) {
        try{
            main.showSelectMatchCode("Current Match");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private Main main;

    void setMain(Main main) {
        this.main = main;
    }
}

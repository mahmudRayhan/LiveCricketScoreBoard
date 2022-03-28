package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelpController {

    private Main main;

    void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private Button back;

    @FXML
    void backAction(ActionEvent event) {
        try{
            main.showHomePage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

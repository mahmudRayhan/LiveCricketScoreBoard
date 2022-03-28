package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import util.NetworkUtil;

import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;

public class SelectMatchCodeController{
    private Main main;
    NetworkUtil nc;
    static MatchInfo match;
    String name;

//    @FXML
//    private TextField matchCode_value;

//    @FXML
//    private Button matchCode;

//    @FXML
//    private Button enter;
//
//    @FXML
//    private Button reset;

    @FXML
    Label matchType;

    @FXML
    private Button returnToHomePage;

    @FXML
    ComboBox<String> selectMatch;

    @FXML
    private Button seeScore;



    @FXML
    void seeScoreAction(ActionEvent event) {
        String str;
         if((String)selectMatch.getValue()=="India VS Pakistan"){
             str="101";
             ScoreboardController.setMatchCode(str);
             nc.write(str);
         }
         else if(selectMatch.getValue()=="Australia VS England"){
             str="102";
             ScoreboardController.setMatchCode(str);
             nc.write(str);
         }
         else if(selectMatch.getValue()=="SouthAfrica VS SriLanka"){
             str="103";
             ScoreboardController.setMatchCode(str);
             nc.write(str);
         }
         else if(selectMatch.getValue()=="WestIndies VS NewZealand"){
             str="104";
             ScoreboardController.setMatchCode(str);
             nc.write(str);
         }
         else if(selectMatch.getValue()=="Bangladesh VS Zimbabwe"){
             str="105";
             ScoreboardController.setMatchCode(str);
             nc.write(str);
         }
        try{
            sleep(1000);
            main.showScoreboard(match);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @FXML
    void selectMatchAction(ActionEvent event) {

    }

    @FXML
    private void initialize(){
        selectMatch.getItems().addAll(
                "Bangladesh VS Zimbabwe",
                "WestIndies VS NewZealand",
                "India VS Pakistan",
                "Australia VS England",
                "SouthAfrica VS SriLanka"
        );
        selectMatch.setStyle("-fx-font: 22px \"Gill Sans MT\";");
        //selectMatch.setPromptText("Select Match To See Score");
    }


//    @FXML
//    void enterAction(ActionEvent event) {
//        String str=matchCode_value.getText();
//        ScoreboardController.setMatchCode(str);
//
//        if(str==null || str.isEmpty()){
//            try {
//                main.showSelectMatchCode("Select MatchCode");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        else{
//            nc.write(str);
//            try{
//                sleep(1000);
//                main.showScoreboard(match);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }

//    @FXML
//    void matchCodeAction(ActionEvent event) {
//        try{
//            main.showSeeMatchCode();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    @FXML
//    void resetAction(ActionEvent event) {
//        matchCode_value.setText(null);
//
//    }

    void setMain(Main main) {
        this.main = main;
    }

    @FXML
    void returnToHomePageAction(ActionEvent event) {
        try{
            main.showHomePage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static MatchInfo getMatch() {
        return match;
    }

    void setNc(NetworkUtil nc){
        this.nc=nc;
    }

    void setName(String name){
        this.name=name;
    }

    public static void setMatch(MatchInfo match) {
        SelectMatchCodeController.match = match;
    }

}

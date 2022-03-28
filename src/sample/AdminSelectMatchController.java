package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import util.NetworkUtil;

import static java.lang.Thread.sleep;

public class AdminSelectMatchController {

    private Main main;
    NetworkUtil nc;
    static MatchInfo match;
    String name;

    @FXML
    private ComboBox<String> selectMatch;

    @FXML
    private Button seeScore;

//    @FXML
//    private TextField matchCode_value;
//
//    @FXML
//    private Button matchCode;
//
//    @FXML
//    private Button enter;
//
//    @FXML
//    private Button reset;

    @FXML
    private Button logOut;

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

    @FXML
    void seeScoreAction(ActionEvent event) {
        String str;
        if((String)selectMatch.getValue()=="India VS Pakistan"){
            str="101";
            nc.write(str);
        }
        else if(selectMatch.getValue()=="Australia VS England"){
            str="102";
            nc.write(str);
        }
        else if(selectMatch.getValue()=="SouthAfrica VS SriLanka"){
            str="103";
            nc.write(str);
        }
        else if(selectMatch.getValue()=="WestIndies VS NewZealand"){
            str="104";
            nc.write(str);
        }
        else if(selectMatch.getValue()=="Bangladesh VS Zimbabwe"){
            str="105";
            nc.write(str);
        }
        try{
            sleep(1000);
            main.showUpdateScore(match);
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @FXML
    void logOutAction(ActionEvent event) {

        try{
            main.showHomePage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void selectMatchAction(ActionEvent event) {

    }


//    @FXML
//    void enterAction(ActionEvent event) {
//        String str=matchCode_value.getText();
//
//        if(str==null || str.isEmpty()){
//            try {
//                main.showAdminSelectMatch();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        else{
//            nc.write(str);
//            try{
//                sleep(1000);
//                main.showUpdateScore(match);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
//    }

//    @FXML
//    void matchCodeAction(ActionEvent event) {
//        try{
//            main.showAdminSeeMatchCode();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

//    @FXML
//    void resetAction(ActionEvent event) {
//        matchCode_value.setText(null);
//    }

    void setMain(Main main) {
        this.main = main;
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
        AdminSelectMatchController.match = match;
    }

}

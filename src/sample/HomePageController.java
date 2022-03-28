package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import util.NetworkUtil;



public class HomePageController {

    NetworkUtil nc;
    private Main main;
    String name;


    @FXML
    private Button internationalMatch;


//    @FXML
//    private Button domesticMatch;

    @FXML
    private Button adminLogin;

    @FXML
    private Button help;

    @FXML
    private Button ranking;

    @FXML
    void rankingAction(ActionEvent event) {

    }




    @FXML
    void helpAction(ActionEvent event) {
        try{
            main.showHelp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    private Button about;

    @FXML
    void aboutAction(ActionEvent event) {
        try{
            main.showAbout();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void internationalMatchAction(ActionEvent event) {
//        System.out.println(nc);
//        nc.write(name+" International Match");
        try{
            main.showSelectMatchCode("Current Match");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @FXML
//    void domesticMatchAction(ActionEvent event) {
//        try{
//            main.showSelectMatchCode("Domestic Match");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }


    @FXML
    void adminLoginAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    void setNc(NetworkUtil nc){
        this.nc=nc;
    }
    void setName(String name){
        this.name=name;
    }



}

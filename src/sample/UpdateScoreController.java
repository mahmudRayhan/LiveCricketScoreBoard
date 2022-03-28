package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static sample.Main.nc;

public class UpdateScoreController {

    private Main main;

    @FXML
    private Button logOut;

    @FXML
    private Button update;

    @FXML
    private Button selectMatch;

    @FXML
    TextField matchCode;

    @FXML
    TextField matchName;

    @FXML
    TextField toss;

    @FXML
    TextField team1;

    @FXML
    TextField team1_run;

    @FXML
    TextField team1_wicket;

    @FXML
    TextField team1_over;

    @FXML
    TextField team2;

    @FXML
    TextField team2_run;

    @FXML
    TextField team2_wicket;

    @FXML
    TextField team2_over;

    @FXML
    TextField target;

    @FXML
    TextField batsman1;

    @FXML
    TextField batsman1_run;

    @FXML
    TextField batsman1_ball;

    @FXML
    TextField batsman2;

    @FXML
    TextField batsman2_run;

    @FXML
    TextField batsman2_ball;

    @FXML
    TextField bowler;

    @FXML
    TextField ball_1;

    @FXML
    TextField ball_2;

    @FXML
    TextField ball_6;

    @FXML
    TextField ball_3;

    @FXML
    TextField ball_5;

    @FXML
    TextField ball_4;

    @FXML
    void editPlayerInfoButtonClicked(ActionEvent event) throws IOException {

        main.displayPlayerStatsEditWindow();
    }


    @FXML
    void selectMatchAction(ActionEvent event) {
        try{
            main.showAdminSelectMatch();
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



//    @FXML
//    void matchCodeAction(ActionEvent event) {
//
//    }

    @FXML
    void updateAction(ActionEvent event) {


        //get from scoreboard
        String MatchCode=matchCode.getText();
        String MatchName=matchName.getText();
        String Toss=toss.getText();

        String Team1=team1.getText();
        String Team1_run=team1_run.getText();
        String Team1_wicket=team1_wicket.getText();
        String Team1_over=team1_over.getText();

        String Team2=team2.getText();
        String Team2_run=team2_run.getText();
        String Team2_wicket=team2_wicket.getText();
        String Team2_over=team2_over.getText();
        String Target=target.getText();

        String Batsman1=batsman1.getText();
        String Batsman1_run=batsman1_run.getText();
        String Batsman1_ball=batsman1_ball.getText();

        String Batsman2=batsman2.getText();
        String Batsman2_run=batsman2_run.getText();
        String Batsman2_ball=batsman2_ball.getText();

        String Bowler=bowler.getText();
        String Ball_1=ball_1.getText();
        String Ball_2=ball_2.getText();
        String Ball_3=ball_3.getText();
        String Ball_4=ball_4.getText();
        String Ball_5=ball_5.getText();
        String Ball_6=ball_6.getText();




        String line=MatchCode+","+MatchName+","+Toss+","+Team1+","+Team1_run+","+Team1_wicket+","+Team1_over+","+Team2+","+Team2_run+","+Team2_wicket+","+Team2_over+","+Target+","+Batsman1+","+Batsman1_run+","+Batsman1_ball+","+Batsman2+","+Batsman2_run+","+Batsman2_ball+","+Bowler+","+Ball_1+","+Ball_2+","+Ball_3+","+Ball_4+","+Ball_5+","+Ball_6;
        MatchInfo obj=new MatchInfo(line);

        if(obj!=null){
            nc.write(obj);
        }

    }


    public void setMain(Main main){
        this.main=main;
    }

}

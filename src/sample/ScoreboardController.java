package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import util.NetworkUtil;

import java.io.IOException;

import static java.lang.Thread.sleep;

public class ScoreboardController {

    private Main main;
    NetworkUtil nc;
    static MatchInfo match;
    static String matchCode;
    String name;

    @FXML
    Label matchName_value;

    @FXML
    Label toss;

    @FXML
    Label team1;

    @FXML
    Label team1_run;

    @FXML
    Label team1_wicket;

    @FXML
    Label team1_over;

    @FXML
    Label team2;

    @FXML
    Label team2_run;

    @FXML
    Label team2_wicket;

    @FXML
    Label team2_over;

    @FXML
    Label target;

    @FXML
    Label batsman1;

    @FXML
    Label batsman1_run;

    @FXML
    Label batsman1_ball;

    @FXML
    Label batsman2;

    @FXML
    Label batsman2_run;

    @FXML
    Label batsman2_ball;

    @FXML
    Label bowler;

    @FXML
    Label ball_6;

    @FXML
    Label ball_1;

    @FXML
    Label ball_3;

    @FXML
    Label ball_5;

    @FXML
    Label ball_2;

    @FXML
    Label ball_4;



    @FXML
    private Button returnToHomePage;

    @FXML
    private Button selectMatch;

    @FXML
    private Button refresh;

    @FXML
    void refreshAction(ActionEvent event) {
        System.out.println(matchCode);
        String str=matchCode;
        if(str!=null && str!=""){
            nc.write(str);
            try{
                sleep(1000);
                main.showScoreboard(match);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    @FXML
    void selectMatchAction(ActionEvent event) {
        try{
            main.showSelectMatchCode("Select Match Code");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void viewBatsmenStatsClicked(ActionEvent event) throws IOException {

        try {
            main.displayBatsmenWindow(match);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("View Batsmen Button clicked.");
    }

    @FXML
    void viewBowlerStatsClicked(ActionEvent event) throws IOException{

        try {
            main.displayBowlerWindow(match);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("View Bowlers Button clicked.");
    }

    @FXML
    void returnToHomePageAction(ActionEvent event) {
        try{
            main.showHomePage();
        }catch (Exception e){
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

    public static String getMatchCode() {
        return matchCode;
    }

    public static void setMatchCode(String matchCode) {
        ScoreboardController.matchCode = matchCode;
    }

    public static MatchInfo getMatch() {
        return match;
    }

    public static void setMatch(MatchInfo match) {
        ScoreboardController.match = match;
    }
}
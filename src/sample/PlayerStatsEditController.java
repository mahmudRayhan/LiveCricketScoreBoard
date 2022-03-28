package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static sample.Main.nc;

public class PlayerStatsEditController {

    static MatchInfo match;
    String matchCode = match.getMatchCode();
    Main main;

    @FXML
    private Button backButton;

    @FXML
    private TextField batsmanNameTF;

    @FXML
    private TextField batsmanRunsTF;

    @FXML
    private TextField batsmanBallsTF;

    @FXML
    private TextField batsmanWicketTF;

    @FXML
    private Button saveBatsmanButton;

    @FXML
    private TextField bowlerNameTF;

    @FXML
    private TextField bowlerRunsTF;

    @FXML
    private TextField bowlerOversTF;

    @FXML
    private TextField bowlerWicketsTF;

    @FXML
    private Button setBowlerButton;

    @FXML
    private Button viewBatsmenButton;

    @FXML
    private Button viewBowlersButton;

    @FXML
    private Button resetBatsmanButton;

    @FXML
    private Button resetBowlerButton;

    @FXML
    void backButtonClicked(ActionEvent event) throws Exception {

        this.main.secondWindow.close();
        System.out.println("Back Button Clicked.");
    }

    @FXML
    boolean saveBatsmanButtonClicked(ActionEvent event) throws IOException {

        int[] a = new int[2];
        try {
            a[0] = Integer.parseInt(batsmanRunsTF.getText());
            a[1] = Integer.parseInt(batsmanBallsTF.getText());
        } catch (NumberFormatException e) {
            main.displayAlertBox("Warning! Invalid Input","Please enter proper integer values.");

            batsmanBallsTF.clear();
            batsmanRunsTF.clear();
            return true;
        }

        Player p = new Player(batsmanNameTF.getText(),batsmanRunsTF.getText(),
                batsmanBallsTF.getText(),batsmanWicketTF.getText());
        p.setMatchCode(matchCode);

        main.setNewBatsmen(p);
        match.setNewBatsmen(p);
//        String toServer = matchCode+","+batsmanNameTF.getText()+","+batsmanRunsTF+","+batsmanBallsTF+","+batsmanWicketTF;
        nc.write(p);

        batsmanNameTF.clear();
        batsmanBallsTF.clear();
        batsmanRunsTF.clear();
        batsmanWicketTF.clear();
        System.out.println("Batsman added.");
        return false;
    }

    @FXML
    boolean setBowlerButtonClicked(ActionEvent event) throws IOException {

        int[] a = new int[3];
        try {
            a[0] = Integer.parseInt(bowlerRunsTF.getText());
            a[1] = Integer.parseInt(bowlerOversTF.getText());
            a[2] = Integer.parseInt(bowlerWicketsTF.getText());
        } catch (NumberFormatException e) {
            main.displayAlertBox("Warning! Invalid Input","Please enter proper integer values.");

            bowlerOversTF.clear();
            bowlerRunsTF.clear();
            bowlerWicketsTF.clear();
            return true;
        }

        Bowler b = new Bowler(bowlerNameTF.getText(), bowlerRunsTF.getText(),
                bowlerOversTF.getText(), bowlerWicketsTF.getText());

        main.setNewBowlers(b);
        match.setNewBowlers(b);
        nc.write(b);

        bowlerNameTF.clear();
        bowlerOversTF.clear();
        bowlerRunsTF.clear();
        bowlerWicketsTF.clear();
        System.out.println("Bowler added.");
        return false;
    }

    @FXML
    void resetBatsmanButtonClicked(ActionEvent event) {

        batsmanNameTF.clear();
        batsmanBallsTF.clear();
        batsmanRunsTF.clear();
        batsmanWicketTF.clear();
    }

    @FXML
    void resetBowlerButtonClicked(ActionEvent event) {

        bowlerNameTF.clear();
        bowlerOversTF.clear();
        bowlerRunsTF.clear();
        bowlerWicketsTF.clear();
    }

    @FXML
    void viewBatsmenButtonClicked(ActionEvent event) throws IOException {

        try {
            main.displayBatsmenWindow(match);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("View Batsmen Button clicked.");
    }

    @FXML
    void viewBowlersButtonClicked(ActionEvent event) {

        try {
            main.displayBowlerWindow(match);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("View Bowlers Button clicked.");
    }

    public String getMatchCode() {
        return matchCode;
    }

    public static void setMatch(MatchInfo match) {
        PlayerStatsEditController.match = match;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

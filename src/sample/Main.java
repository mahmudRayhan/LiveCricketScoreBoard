package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;

public class Main extends Application {
    Stage stage;
    static NetworkUtil nc;
    static String name;

    //update
    Stage secondWindow;
    Stage thirdWindow;
    Stage alertWindow;

    ObservableList<Player> batsmen;
    ObservableList<Bowler> bowlers;
    public static void main(String[] args) {
        Client client = new Client("localhost",33333);
        //Main mainObj=new Main();
        Main.nc = client.getNc();
        name=client.getClientName();
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        //Stage is the GUI that is shown after running the program.
        stage = primaryStage;
        showHomePage();
    }

    public void showHomePage() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Home.fxml"));
        Parent root=loader.load();

        HomePageController controller = loader.getController();
        controller.setNc(nc);
        controller.setName(name);
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("Live Cricket Scoreboard");
        stage.setScene(new Scene(root,700,450));
        stage.show();

    }


    public void showLoginPage() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("LoginPage.fxml"));
        Parent root=loader.load();

        // Loading the controller
        LoginPageController controller = loader.getController();
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("Login Page");
        stage.setScene(new Scene(root,700,350));
        stage.show();

    }

    public void showAdminSelectMatch() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminSelectMatch.fxml"));
        Parent root=loader.load();

        // Loading the controller
        AdminSelectMatchController controller = loader.getController();
        controller.setMain(this);
        controller.setNc(nc);
        controller.setName(name);


        //set the primary stage
        stage.setTitle("Admin Select Page");
        stage.setScene(new Scene(root,700,450));
        stage.show();
    }
    public void showSelectMatchCode(String matchType) throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("SelectMatchCode.fxml"));
        Parent root=loader.load();

        // Loading the controller
        SelectMatchCodeController controller = loader.getController();
        controller.setMain(this);
        controller.setNc(nc);
        controller.setName(name);

        //set the primary stage
        stage.setTitle("Select Match Code Page");
        stage.setScene(new Scene(root,700,450));
        stage.show();

        //show match type
        controller.matchType.setText(matchType);

    }




    public void showUpdateScore(MatchInfo match) throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("UpdateScore.fxml"));
        Parent root=loader.load();

        batsmen = FXCollections.observableArrayList(match.getPlayers());
        System.out.println("Batsmen added to client");
        bowlers = FXCollections.observableArrayList(match.getBowlers());
        System.out.println("Bowlers added to client");

        // Loading the controller
        UpdateScoreController controller = loader.getController();
        controller.setMain(this);


        //set update ScoreBoard

        controller.matchCode.setText(match.getMatchCode());
        controller.matchName.setText(match.getMatchName());
        controller.toss.setText(match.getToss());

        controller.team1.setText(match.getTeam1());
        controller.team1_run.setText(match.getTeam1_run());
        controller.team1_wicket.setText(match.getTeam1_wicket());
        controller.team1_over.setText(match.getTeam1_over());

        controller.team2.setText(match.getTeam2());
        controller.team2_run.setText(match.getTeam2_run());
        controller.team2_wicket.setText(match.getTeam2_wicket());
        controller.team2_over.setText(match.getTeam2_over());
        controller.target.setText(match.getTarget());

        controller.batsman1.setText(match.getBatsman1());
        controller.batsman1_run.setText(match.getBatsman1_run());
        controller.batsman1_ball.setText(match.getBatsman1_ball());

        controller.batsman2.setText(match.getBatsman2());
        controller.batsman2_run.setText(match.getBatsman2_run());
        controller.batsman2_ball.setText(match.getBatsman2_ball());

        controller.bowler.setText(match.getBowler());
        controller.ball_1.setText(match.getBall_1());
        controller.ball_2.setText(match.getBall_2());
        controller.ball_3.setText(match.getBall_3());
        controller.ball_4.setText(match.getBall_4());
        controller.ball_5.setText(match.getBall_5());
        controller.ball_6.setText(match.getBall_6());




        controller.matchName.setEditable(false);
        controller.matchCode.setEditable(false);

        //set the primary stage
        stage.setTitle("Admin Score Update Page");
        stage.setScene(new Scene(root,850,600));
        stage.show();

    }
    public void showScoreboard(MatchInfo match) throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("Scoreboard.fxml"));
        Parent root=loader.load();

        batsmen = FXCollections.observableArrayList(match.getPlayers());
        System.out.println("Batsmen added according to client");
        bowlers = FXCollections.observableArrayList(match.getBowlers());
        System.out.println("Bowlers added according to client");


        // Loading the controller
        ScoreboardController controller = loader.getController();
        controller.setMain(this);
        controller.setNc(nc);

        //set the primary stage
        stage.setTitle("Scoreboard Page");
        stage.setScene(new Scene(root,750,550));
        stage.show();

        //Show ScoreBoard Value
        controller.matchName_value.setText(match.getMatchName());
        controller.toss.setText(match.getToss());

        controller.team1.setText(match.getTeam1());
        controller.team1_run.setText(match.getTeam1_run());
        controller.team1_wicket.setText(match.getTeam1_wicket());
        controller.team1_over.setText(match.getTeam1_over());

        controller.team2.setText(match.getTeam2());
        controller.team2_run.setText(match.getTeam2_run());
        controller.team2_wicket.setText(match.getTeam2_wicket());
        controller.team2_over.setText(match.getTeam2_over());
        controller.target.setText(match.getTarget());

        controller.batsman1.setText(match.getBatsman1());
        controller.batsman1_run.setText(match.getBatsman1_run());
        controller.batsman1_ball.setText(match.getBatsman1_ball());

        controller.batsman2.setText(match.getBatsman2());
        controller.batsman2_run.setText(match.getBatsman2_run());
        controller.batsman2_ball.setText(match.getBatsman2_ball());

        controller.bowler.setText(match.getBowler());
        controller.ball_1.setText(match.getBall_1());
        controller.ball_2.setText(match.getBall_2());
        controller.ball_3.setText(match.getBall_3());
        controller.ball_4.setText(match.getBall_4());
        controller.ball_5.setText(match.getBall_5());
        controller.ball_6.setText(match.getBall_6());

    }

    public void showSeeMatchCode() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("SeeMatchCode.fxml"));
        Parent root=loader.load();

        SeeMatchCodeController controller = loader.getController();
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("See Match Code");
        stage.setScene(new Scene(root,700,450));
        stage.show();

    }

    public void showAdminSeeMatchCode() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("AdminSeeMatchCode.fxml"));
        Parent root=loader.load();

        AdminSeeMatchCodeController controller = loader.getController();
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("See Match Code");
        stage.setScene(new Scene(root,700,450));
        stage.show();

    }

    public void showHelp() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("help.fxml"));
        Parent root=loader.load();

        HelpController controller = loader.getController();
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("Help");
        stage.setScene(new Scene(root,700,450));
        stage.show();

    }

    public void showAbout() throws Exception{
        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("About.fxml"));
        Parent root=loader.load();

        AboutController controller = loader.getController();
        controller.setMain(this);

        //set the primary stage
        stage.setTitle("Help");
        stage.setScene(new Scene(root,717,565));
        stage.show();

    }

    void displayBatsmenWindow(MatchInfo matchInfo) throws IOException {

        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("BatsmenWindow.fxml"));
        Parent root=loader.load();

        BatsmenWindowController batsmenWindowController = loader.getController();
        batsmenWindowController.setMain(this);
//        batsmenWindowController.setMatch(matchInfo);

//        batsmenWindowController.batsmen = FXCollections.observableArrayList(matchInfo.getPlayers());
//        System.out.println("Batsmen added according to client");

        //set the primary stage
        thirdWindow = new Stage();
        thirdWindow.initModality(Modality.APPLICATION_MODAL);
        thirdWindow.setTitle("Batsmen Stats");
        thirdWindow.setScene(new Scene(root,800,500));
        thirdWindow.show();
    }

    void displayBowlerWindow(MatchInfo matchInfo) throws IOException {

        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("BowlerWindow.fxml"));
        Parent root=loader.load();

        BowlerWindowController bowlerWindowController = loader.getController();
        bowlerWindowController.setMain(this);
//        bowlerWindowController.setMatch(matchInfo);

//        bowlerWindowController.bowlers = FXCollections.observableArrayList(matchInfo.getBowlers());
//        System.out.println("Bowlers added according to client");


        //set the primary stage
        thirdWindow = new Stage();
        thirdWindow.initModality(Modality.APPLICATION_MODAL);
        thirdWindow.setTitle("Bowler Stats");
        thirdWindow.setScene(new Scene(root,800,500));
        thirdWindow.show();
    }

    void displayPlayerStatsEditWindow() throws IOException {

        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("PlayerStatsEdit.fxml"));
        Parent root=loader.load();

        PlayerStatsEditController playerStatsEditController = loader.getController();
        playerStatsEditController.setMain(this);

        //set the primary stage
        secondWindow = new Stage();
        secondWindow.initModality(Modality.APPLICATION_MODAL);
        secondWindow.setTitle("Edit Player Details");
        secondWindow.setScene(new Scene(root,800,500));
        secondWindow.show();
    }

    void displayAlertBox(String title, String text) throws IOException {

        //Xml loading using FXMLLoader
        FXMLLoader loader =new FXMLLoader();
        loader.setLocation(getClass().getResource("AlertBox.fxml"));
        Parent root=loader.load();

        AlertBoxController alertBoxController = loader.getController();
        alertBoxController.setMain(this,text);

        //set the primary stage
        alertWindow = new Stage();
        alertWindow.initModality(Modality.APPLICATION_MODAL);
        alertWindow.setTitle(title);
        alertWindow.setScene(new Scene(root,300,200));
        alertWindow.show();
    }

    public ObservableList<Player> getPlayers() {

        return batsmen;
    }

    public ObservableList<Bowler> getBowlers(){

        return bowlers;
    }

    public void setNewBatsmen(Player player){

        batsmen.add(player);
        System.out.println("New batsman added.");
    }

    public void setNewBowlers(Bowler bowler){

        bowlers.add(bowler);
        System.out.println("New Bowler added.");
    }
}

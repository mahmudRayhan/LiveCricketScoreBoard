package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BatsmenWindowController {

//    ObservableList<Player> batsmen;
    static MatchInfo match;

    public static void setMatch(MatchInfo matchInfo) {
        match = matchInfo;
    }

    private Main main;

    @FXML
    private TableView<Player> tableView = new TableView<>();

    @FXML
    private TableColumn<Player, String> PlayerName = new TableColumn<>();

    @FXML
    private TableColumn<Player, String> runScored = new TableColumn<>();

    @FXML
    private TableColumn<Player, String> ballsFaced = new TableColumn<>();

    @FXML
    private TableColumn<Player, String> wicketInfo = new TableColumn<>();

    @FXML
    private Button backButton = new Button();

    @FXML
    private HBox hBox;

    @FXML
    private ImageView countryIcon;

    @FXML
    private Label countryName = new Label();

    @FXML
    void backButtonClicked() throws IOException {

        this.main.thirdWindow.close();
        System.out.println("Back button clicked.");
    }

    public void setMain(Main main) {

        PlayerName.setCellValueFactory(new PropertyValueFactory<Player, String>("name"));
        runScored.setCellValueFactory(new PropertyValueFactory<>("runs"));
        ballsFaced.setCellValueFactory(new PropertyValueFactory<>("ballsFaced"));
        wicketInfo.setCellValueFactory(new PropertyValueFactory<Player, String>("wicketInfo"));
        tableView.setItems(main.getPlayers());
//        tableView.setItems(main.getPlayers());
        tableView.getColumns().setAll(PlayerName,runScored,ballsFaced,wicketInfo);
        this.main = main;
    }

//    public ObservableList<Player> getPlayers() {
//
//        return batsmen;
//    }

//    public void setNewBatsmen(Player player){
//
//        batsmen.add(player);
//        System.out.println("New batsman added.");
//    }

}



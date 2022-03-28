package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class BowlerWindowController {

//    ObservableList<Bowler> bowlers;
    static MatchInfo match;

    public static void setMatch(MatchInfo matchInfo) {
        match = matchInfo;
    }
    Main main;

    @FXML
    private TableView<Bowler> bowlersTable;

    @FXML
    private TableColumn<Bowler, String> bowlerColumn;

    @FXML
    private TableColumn<Bowler, String> oversColumn;

    @FXML
    private TableColumn<Bowler, String> wicketsColumn;

    @FXML
    private TableColumn<Bowler, String> runsColumn;


    @FXML
    private Button backButton;


    @FXML
    private HBox hBox;

    @FXML
    private ImageView coutryIcon;

    @FXML
    private Label countryName;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {

        this.main.thirdWindow.close();
        System.out.println("Back Button Clicked.");
    }
    public void setMain(Main main) {


        bowlerColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        runsColumn.setCellValueFactory(new PropertyValueFactory<>("runsConsumed"));
        oversColumn.setCellValueFactory(new PropertyValueFactory<>("oversBowled"));
        wicketsColumn.setCellValueFactory(new PropertyValueFactory<>("wicketsTaken"));
//        bowlersTable.setItems(main.getBowlers());
        bowlersTable.setItems(main.getBowlers());
        bowlersTable.getColumns().setAll(bowlerColumn,runsColumn,oversColumn,wicketsColumn);
        this.main = main;
    }

//    public ObservableList<Bowler> getBowlers(){
//
//        return bowlers;
//    }

//    public void setNewBowlers(Bowler bowler){
//
//        bowlers.add(bowler);
//        System.out.println("New Bowler added.");
//    }
}

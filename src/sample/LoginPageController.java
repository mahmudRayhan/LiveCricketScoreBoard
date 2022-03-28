package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LoginPageController {

    private Main main;
    private static int counter=0;
    private static List<Users> userList = new ArrayList();

    private final String INPUT_FILE_NAME = "users.txt";

    @FXML
    private TextField userId;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button reset;

    @FXML
    private Button returnToHomepage;

    @FXML
    void loginAction(ActionEvent event) {
        System.out.println("Login Button is Clicked");


        if(counter==0){
            try {
                BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
                //Users user=new Users();
                String str1=new String();
                String str2=new String();

                while (true) {

                    str1 = br.readLine();
                    //user.setUserId(str1);
                    //System.out.println(user.getUserId());

                    str2 = br.readLine();
                    //user.setPassword(str2);
                    //System.out.println(user.getPassword());

                    if (str1 == null || str2 == null) {
                        break;

                    }
                    userList.add(new Users(str1, str2));
                }
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            counter++;
        }

//        for(Users obj: userList){
//            System.out.println(obj);
//        }


        String anyUserId=userId.getText();
        String anyPassword=password.getText();

        int flag=0;
        for(Users obj: userList){
            if(obj.getUserId().equals(anyUserId)  &&  obj.getPassword().equals(anyPassword)){
                //successful login
                flag=1;
                try {
                    main.showAdminSelectMatch();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        if(flag==0){
            System.out.println("Invalid UserId or Password");
            // failed login
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect Credentials");
            alert.setHeaderText("Incorrect Credentials");
            alert.setContentText("The username and password you provided is not correct.");
            alert.showAndWait();

            //automatic reset Password
            userId.setText(null);
            password.setText(null);
        }

    }

    @FXML
    void resetAction(ActionEvent event) {
        userId.setText(null);
        password.setText(null);
    }

    @FXML
    void returnToHomepageAction(ActionEvent event) {
        System.out.println("Return to Home Page Button is Clicked");
        try{
            main.showHomePage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

}

package elec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("electUi.fxml"));
        primaryStage.setTitle("Electricity Clicker");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1480 , 720));

        //Set icon
        primaryStage.getIcons().add( new Image(
                Main.class.getResourceAsStream( "icon.png" )));


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

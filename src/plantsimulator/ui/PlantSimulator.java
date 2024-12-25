package plantsimulator.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlantSimulator extends Application {

@Override
public void start(Stage primaryStage) throws Exception {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/plantsimulator/fxml/Main.fxml"));
    Parent root = loader.load(); // Load the FXML file
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Plant Simulator");
    primaryStage.show();
}

    public static void main(String[] args) {
        launch();
    }
}

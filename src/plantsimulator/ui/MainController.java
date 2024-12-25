package plantsimulator.ui;

import java.time.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import plantsimulator.decorator.FertilizingDecorator;
import plantsimulator.decorator.PlantAction;
import plantsimulator.decorator.SpecialWateringDecorator;
import plantsimulator.model.Plant;
import plantsimulator.model.HealthyState;
import plantsimulator.model.WiltedState;
import plantsimulator.model.FertilizedState;

public class MainController {

    @FXML
    private ImageView plantImage1, plantImage2, plantImage3, plantImage4, plantImage5, plantImage6;
    @FXML
    private ImageView fertilizeIcon1, fertilizeIcon2, fertilizeIcon3, fertilizeIcon4, fertilizeIcon5, fertilizeIcon6;
    @FXML
    private ImageView waterIcon1, waterIcon2, waterIcon3, waterIcon4, waterIcon5, waterIcon6;

    @FXML
    private Label plantStateLabel1, plantStateLabel2, plantStateLabel3, plantStateLabel4, plantStateLabel5, plantStateLabel6;
    
    @FXML
private Label waterActionMessage;
@FXML
private Label fertilizeActionMessage;

    private Plant plant1, plant2, plant3, plant4, plant5, plant6;

    // Initialize plants (example, assuming they are already created and initialized)
    public void initialize() {
        plant1 = new Plant("Plant 1", new HealthyState(), "/plantsimulator/resources/images/plant1.png");
        plant2 = new Plant("Plant 2", new WiltedState(), "/plantsimulator/resources/images/plant2.png");
        plant3 = new Plant("Plant 3", new FertilizedState(), "/plantsimulator/resources/images/plant3.png");
        plant4 = new Plant("Plant 4", new HealthyState(), "/plantsimulator/resources/images/plant4.png");
        plant5 = new Plant("Plant 5", new WiltedState(), "/plantsimulator/resources/images/plant5.png");
        plant6 = new Plant("Plant 6", new FertilizedState(), "/plantsimulator/resources/images/plant6.png");

        // Set images and labels to the ImageView components
        updatePlantImagesAndLabels();

        // Set fertilizing and watering icons
        setActionIcons();
    }

    private void setActionIcons() {
        Image fertilizeIcon = new Image(getClass().getResourceAsStream("/plantsimulator/resources/images/fertilizing_icon.png"));
        Image waterIcon = new Image(getClass().getResourceAsStream("/plantsimulator/resources/images/watering_icon.png"));

        fertilizeIcon1.setImage(fertilizeIcon);
        fertilizeIcon2.setImage(fertilizeIcon);
        fertilizeIcon3.setImage(fertilizeIcon);
        fertilizeIcon4.setImage(fertilizeIcon);
        fertilizeIcon5.setImage(fertilizeIcon);
        fertilizeIcon6.setImage(fertilizeIcon);

        waterIcon1.setImage(waterIcon);
        waterIcon2.setImage(waterIcon);
        waterIcon3.setImage(waterIcon);
        waterIcon4.setImage(waterIcon);
        waterIcon5.setImage(waterIcon);
        waterIcon6.setImage(waterIcon);
    }

    @FXML
    private void handleImageClick(MouseEvent event) {
        Plant selectedPlant = getSelectedPlant(event);
        if (selectedPlant != null) {
            openPlantStateDialog(selectedPlant);  // Open the dialog when an image is clicked
        }
    }

@FXML
private void handleFertilizeClick(MouseEvent event) {
    Plant selectedPlant = getSelectedPlant(event);
    if (selectedPlant != null) {
        // Wrap the action with FertilizingDecorator
        PlantAction fertilizingAction = new FertilizingDecorator((PlantAction) selectedPlant);
        fertilizingAction.performAction(); // Perform the decorated fertilizing action
        updatePlantState(selectedPlant); // Update the state and refresh the UI
        showActionMessage("Your plant is fertilized!");
    }
}

@FXML
private void handleWaterClick(MouseEvent event) {
    Plant selectedPlant = getSelectedPlant(event);
    if (selectedPlant != null) {
        // Wrap the action with SpecialWateringDecorator
        PlantAction wateringAction = new SpecialWateringDecorator((PlantAction) selectedPlant);
        wateringAction.performAction(); // Perform the decorated watering action
        updatePlantState(selectedPlant); // Update the state and refresh the UI
        showActionMessage("Your plant is watered with special care!");
    }
}
// Helper method to show the action message in an alert
private void showActionMessage(String message) {
    Alert alert = new Alert(AlertType.INFORMATION);
    alert.setTitle("Action Complete");
    alert.setHeaderText(null); // You can set a header text, or leave it null
    alert.setContentText(message); // This will show the message passed to the method

    // Show the alert and wait for the user to close it
    alert.showAndWait();
}

    private Plant getSelectedPlant(MouseEvent event) {
        if (event.getSource() == fertilizeIcon1 || event.getSource() == waterIcon1 || event.getSource() == plantImage1) {
            return plant1;
        } else if (event.getSource() == fertilizeIcon2 || event.getSource() == waterIcon2 || event.getSource() == plantImage2) {
            return plant2;
        } else if (event.getSource() == fertilizeIcon3 || event.getSource() == waterIcon3 || event.getSource() == plantImage3) {
            return plant3;
        } else if (event.getSource() == fertilizeIcon4 || event.getSource() == waterIcon4 || event.getSource() == plantImage4) {
            return plant4;
        } else if (event.getSource() == fertilizeIcon5 || event.getSource() == waterIcon5 || event.getSource() == plantImage5) {
            return plant5;
        } else if (event.getSource() == fertilizeIcon6 || event.getSource() == waterIcon6 || event.getSource() == plantImage6) {
            return plant6;
        }
        return null;
    }

    // Method to update the state of the plant (e.g., water, fertilize)
    public void updatePlantState(Plant plant) {
        // Logic to update the state of the plant
        System.out.println("Updated state for: " + plant.getName() + " to: " + plant.getState());
        updatePlantImagesAndLabels();
    }

    private void updatePlantImagesAndLabels() {
        // Update plant 1
        plantImage1.setImage(new Image(getClass().getResourceAsStream(plant1.getImagePath())));
        plantStateLabel1.setText("State: " + plant1.getStateName());

        // Update plant 2
        plantImage2.setImage(new Image(getClass().getResourceAsStream(plant2.getImagePath())));
        plantStateLabel2.setText("State: " + plant2.getStateName());

        // Update plant 3
        plantImage3.setImage(new Image(getClass().getResourceAsStream(plant3.getImagePath())));
        plantStateLabel3.setText("State: " + plant3.getStateName());

        // Update plant 4
        plantImage4.setImage(new Image(getClass().getResourceAsStream(plant4.getImagePath())));
        plantStateLabel4.setText("State: " + plant4.getStateName());

        // Update plant 5
        plantImage5.setImage(new Image(getClass().getResourceAsStream(plant5.getImagePath())));
        plantStateLabel5.setText("State: " + plant5.getStateName());

        // Update plant 6
        plantImage6.setImage(new Image(getClass().getResourceAsStream(plant6.getImagePath())));
        plantStateLabel6.setText("State: " + plant6.getStateName());
    }

    // This method opens the PlantStateDialog with the selected plant
private void openPlantStateDialog(Plant selectedPlant) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/plantsimulator/fxml/PlantStateDialog.fxml"));
        Parent root = loader.load();

        // Get the controller for the PlantStateDialog
        PlantStateDialogController dialogController = loader.getController();

        // Pass both the selected plant and the current MainController to the initialize method
        dialogController.initialize(selectedPlant, this); // 'this' refers to the current MainController

        // Create and show the dialog
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Plant State Details");
        dialogStage.setScene(new Scene(root));
        dialogStage.show();
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error opening plant state dialog.");
    }
}

}

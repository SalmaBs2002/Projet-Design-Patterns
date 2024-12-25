package plantsimulator.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import plantsimulator.model.Plant;
import plantsimulator.model.PlantState;
import plantsimulator.model.WiltedState;
import plantsimulator.model.HealthyState;
import plantsimulator.model.FertilizedState;
import plantsimulator.model.DeadState;
import plantsimulator.model.PlantMemento;

public class PlantStateDialogController {

    @FXML
    private Label currentStateLabel, selectedStateLabel;

    @FXML
    private Button state1Button, state2Button, state3Button, state4Button, saveButton, restoreButton, closeButton;

    private Plant plant;
    private PlantMemento savedState;
    private String selectedState;
    private MainController mainController; // Reference to MainController

    // Initialize the dialog with the plant details and current state
    public void initialize(Plant plant, MainController mainController) {
        this.plant = plant;
        this.savedState = plant.saveState(); // Save the initial state
        this.selectedState = plant.getStateName(); // Default selected state
        this.mainController = mainController; // Pass the MainController reference

        updateStateLabels();
        configureButtonActions();
    }

    private void configureButtonActions() {
        // Set actions for each state button
        state1Button.setOnAction(event -> selectState("Wilted"));
        state2Button.setOnAction(event -> selectState("Healthy"));
        state3Button.setOnAction(event -> selectState("Fertilized"));
        state4Button.setOnAction(event -> selectState("Dead"));

        // Save and restore actions
        saveButton.setOnAction(event -> savePlantState());
        restoreButton.setOnAction(event -> restorePlantState());

        // Close button action
        closeButton.setOnAction(event -> closeDialog());
    }

    private void selectState(String newState) {
        this.selectedState = newState;
        selectedStateLabel.setText("Selected State: " + newState);
        updateButtonStyles(); // Update button visuals
    }

    private void updateStateLabels() {
        currentStateLabel.setText("Current State: " + plant.getStateName());
        selectedStateLabel.setText("Selected State: " + selectedState);
        updateButtonStyles();
    }

    private void updateButtonStyles() {
        // Clear styles on all buttons
        resetButtonStyles();

        // Fade only the selected button
        if ("Wilted".equals(selectedState)) {
            setButtonFaded(state1Button);
        } else if ("Healthy".equals(selectedState)) {
            setButtonFaded(state2Button);
        } else if ("Fertilized".equals(selectedState)) {
            setButtonFaded(state3Button);
        } else if ("Dead".equals(selectedState)) {
            setButtonFaded(state4Button);
        }
    }

    private void resetButtonStyles() {
        Button[] buttons = {state1Button, state2Button, state3Button, state4Button};
        for (Button button : buttons) {
            button.setDisable(false);
            button.setStyle("-fx-opacity: 1.0;"); // Reset opacity
        }
    }

    private void setButtonFaded(Button button) {
        button.setDisable(true);
        button.setStyle("-fx-opacity: 0.5;"); // Faded effect
    }

    private void savePlantState() {
        PlantState newState = getStateFromString(selectedState);

        if (newState != null) {
            savedState = plant.saveState(); // Save the current state
            plant.changeState(new PlantMemento(newState)); // Change the state
            updateStateLabels();  // Update the state label in the dialog

            // Notify MainController that state has been changed
            mainController.updatePlantState(plant);
        } else {
            showError("Error", "Invalid state selected.");
        }
    }

    private void restorePlantState() {
        if (savedState != null) {
            plant.changeState(savedState); // Restore the saved state
            this.selectedState = plant.getStateName(); // Reset selected state
            updateStateLabels();
        } else {
            showError("Error", "No saved state to restore.");
        }
    }

    private PlantState getStateFromString(String stateName) {
        switch (stateName) {
            case "Wilted":
                return new WiltedState();
            case "Healthy":
                return new HealthyState();
            case "Fertilized":
                return new FertilizedState();
            case "Dead":
                return new DeadState();
            default:
                return null;
        }
    }

    private void showError(String title, String message) {
        System.out.println(title + ": " + message); // Placeholder for error handling
    }

    private void closeDialog() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}

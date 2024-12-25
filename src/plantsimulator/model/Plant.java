package plantsimulator.model;

import plantsimulator.decorator.FertilizingDecorator;
import plantsimulator.decorator.PlantAction;
import plantsimulator.decorator.PlantDecorator;
import plantsimulator.decorator.SpecialWateringDecorator;
import plantsimulator.manager.GameManager;

public class Plant {
    private String name;
    private PlantState state;
    private PlantAction action;
    private String imagePath;

    // Constructor to initialize the plant with a name and an initial state
    public Plant(String name, PlantState state,String imagePath) {
        this.name = name;
        this.state = state;
         this.imagePath = imagePath;
    }

    // Getters
    public String getName() {
        return name;
    }

    public PlantState getState() {
        return state;
    }
    
      public String getImagePath() {
        return imagePath;
    }

    public String getStateName() {
        return state.getStateName();
    }

    // Change the state of the plant using a PlantMemento
    public void changeState(PlantMemento plantMemento) {
        if (plantMemento != null) {
            this.state = plantMemento.getState(); // Restore state from the memento
        }
    }

    // Restore the state from the Memento
    public void restoreState(PlantMemento memento) {
        if (memento != null) {
            this.state = memento.getState();  // Récupérer l'état depuis le Memento
        }
    }
    // Save the current state into a Memento and store it in GameManager
   public PlantMemento saveState() {
        return new PlantMemento(this.state);  // Créer un memento avec l'état actuel
    }

    // Set a dynamic action for the plant (e.g., fertilization, special watering)
    public void setAction(PlantAction action) {
        if (this.action == null) {
            this.action = action;
        } else {
            this.action = new PlantDecorator(action) {}; // Decorate the existing action
        }
    }

    // Perform the defined action on the plant
    public void performAction() {
        if (action != null) {
            action.performAction();
        }
    }
    
   public void fertilize() {
    // Transition the state to Fertilized
    if (!(state instanceof FertilizedState)) {
        state = new FertilizedState(); // Set the plant state to Fertilized
    }
    // Optionally, notify the user
    System.out.println(name + " is fertilized.");
}


  public void water() {
    // Check if the plant is Dead or Wilted, and change state accordingly
    if (state instanceof DeadState) {
        state = new HealthyState(); // If dead, revive the plant to Healthy
    } else if (state instanceof WiltedState) {
        state = new HealthyState(); // If wilted, revive the plant to Healthy
    }
    // Optionally, notify the user
    System.out.println(name + " is watered.");
}
   

    @Override
    public String toString() {
        return name + " (" + getStateName() + ")";
    }
}

package plantsimulator.manager;

import plantsimulator.model.Plant;
import plantsimulator.model.PlantMemento;
import plantsimulator.model.CareTaker;

public class GameManager {
    private static GameManager instance;
    private CareTaker caretaker;  // Dépendance au CareTaker

    private GameManager() {
        caretaker = new CareTaker();  // Initialisation du CareTaker
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    // Sauvegarder l'état d'une plante
    public void savePlantState(Plant plant) {
        caretaker.saveState(plant);  // Utiliser le CareTaker pour sauvegarder l'état
    }

    // Restaurer un état d'une plante en fonction de l'index
    public void restorePlantState(Plant plant, int index) {
        caretaker.restoreState(plant, index);  // Utiliser le CareTaker pour restaurer l'état
    }

    // Obtenir le dernier état sauvegardé d'une plante
    public PlantMemento getSavedPlantState(Plant plant) {
        return caretaker.getSavedPlantState(plant);  // Utiliser le CareTaker pour obtenir le dernier état
    }
}

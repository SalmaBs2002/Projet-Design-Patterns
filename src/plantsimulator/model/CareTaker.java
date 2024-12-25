package plantsimulator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CareTaker {
    // Map associant chaque plante à une liste d'objets PlantMemento
    private Map<Plant, List<PlantMemento>> mementoHistory = new HashMap<>();

    // Sauvegarder l'état d'une plante
    public void saveState(Plant plant) {
        PlantMemento memento = plant.saveState();  // Créer un memento de l'état actuel de la plante
        mementoHistory.computeIfAbsent(plant, k -> new ArrayList<>()).add(memento);  // Ajouter le memento dans la liste de la plante
    }

    // Restaurer un état particulier d'une plante par index
    public void restoreState(Plant plant, int index) {
        List<PlantMemento> history = mementoHistory.get(plant);  // Récupérer l'historique des états de la plante
        if (history != null && index >= 0 && index < history.size()) {
            PlantMemento memento = history.get(index);  // Récupérer le memento correspondant à l'index
            plant.restoreState(memento);  // Restaurer l'état de la plante
        }
    }

    // Récupérer le dernier état sauvegardé pour une plante
    public PlantMemento getSavedPlantState(Plant plant) {
        List<PlantMemento> history = mementoHistory.get(plant);
        if (history != null && !history.isEmpty()) {
            return history.get(history.size() - 1);  // Retourner le dernier état sauvegardé
        }
        return null;
    }
}

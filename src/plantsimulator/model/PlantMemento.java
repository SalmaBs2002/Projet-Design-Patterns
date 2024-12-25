package plantsimulator.model;

public class PlantMemento {
    private final PlantState state;

    public PlantMemento(PlantState state) {
        this.state = state;
    }

    public PlantState getState() {
        return state;
    }
}

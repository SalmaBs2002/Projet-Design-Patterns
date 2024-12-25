package plantsimulator.model;

public abstract class PlantState {
    public abstract String getStateName();
    public abstract PlantState nextState();
}

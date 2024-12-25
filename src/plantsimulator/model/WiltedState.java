package plantsimulator.model;

public class WiltedState extends PlantState {
    @Override
    public String getStateName() {
        return "Wilted";
    }

    @Override
    public PlantState nextState() {
        return new DeadState();
    }
}

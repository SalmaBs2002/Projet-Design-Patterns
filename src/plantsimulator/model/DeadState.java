package plantsimulator.model;

public class DeadState extends PlantState {
    @Override
    public String getStateName() {
        return "Dead";
    }

    @Override
    public PlantState nextState() {
        return this; // Dead remains unchanged
    }
}

package plantsimulator.model;

public class HealthyState extends PlantState {
    @Override
    public String getStateName() {
        return "Healthy";
    }

    @Override
    public PlantState nextState() {
        return new WiltedState();
    }
}

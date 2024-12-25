/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulator.decorator;


public abstract class PlantDecorator implements PlantAction {
    protected PlantAction wrappedAction;

    public PlantDecorator(PlantAction wrappedAction) {
        this.wrappedAction = wrappedAction;
    }

    @Override
    public void performAction() {
        if (wrappedAction != null) {
            wrappedAction.performAction();
        }
    }
}

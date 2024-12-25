/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulator.decorator;


public class FertilizingDecorator extends PlantDecorator {

    public FertilizingDecorator(PlantAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Fertilizing the plant!");
    }
}

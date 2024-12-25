/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulator.decorator;


public class SpecialWateringDecorator extends PlantDecorator {

    public SpecialWateringDecorator(PlantAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public void performAction() {
        super.performAction();
        System.out.println("Special watering applied to the plant!");
    }
}

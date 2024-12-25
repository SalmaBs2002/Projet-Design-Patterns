/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plantsimulator.model;


public class FertilizedState extends PlantState {
    @Override
    public String getStateName() {
        return "Fertilized";
    }

    @Override
    public PlantState nextState() {
        return new HealthyState(); // Retour à un état sain après fertilisation
    }
}

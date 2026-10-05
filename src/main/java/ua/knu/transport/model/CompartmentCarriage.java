package ua.knu.transport.model;

public class CompartmentCarriage extends PassengerCarriage {
    public CompartmentCarriage(String id, int passengerCapacity, double baggageCapacityKg) {
        super(id, passengerCapacity, baggageCapacityKg, ComfortLevel.COMPARTMENT);
    }
}
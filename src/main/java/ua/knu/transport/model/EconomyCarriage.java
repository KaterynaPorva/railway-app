package ua.knu.transport.model;

public class EconomyCarriage extends PassengerCarriage {
    public EconomyCarriage(String id, int passengerCapacity, double baggageCapacityKg) {
        super(id, passengerCapacity, baggageCapacityKg, ComfortLevel.ECONOMY);
    }
}
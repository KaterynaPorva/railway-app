package ua.knu.transport.model;

public class SleepingCarriage extends PassengerCarriage {
    public SleepingCarriage(String id, int passengerCapacity, double baggageCapacityKg) {
        super(id, passengerCapacity, baggageCapacityKg, ComfortLevel.VIP);
    }
}
package ua.knu.transport.model;

public abstract class PassengerCarriage {
    private final String id;
    private final int passengerCapacity;
    private final double baggageCapacityKg;
    private final ComfortLevel comfortLevel;

    public PassengerCarriage(String id, int passengerCapacity, double baggageCapacityKg, ComfortLevel comfortLevel) {
        this.id = id;
        this.passengerCapacity = passengerCapacity;
        this.baggageCapacityKg = baggageCapacityKg;
        this.comfortLevel = comfortLevel;
    }

    public String getId() { return id; }
    public int getPassengerCapacity() { return passengerCapacity; }
    public double getBaggageCapacityKg() { return baggageCapacityKg; }
    public ComfortLevel getComfortLevel() { return comfortLevel; }

    @Override
    public String toString() {
        return String.format("Вагон %s (Комфорт: %s, Місць: %d, Багаж: %.1f кг)", 
                id, comfortLevel, passengerCapacity, baggageCapacityKg);
    }
}
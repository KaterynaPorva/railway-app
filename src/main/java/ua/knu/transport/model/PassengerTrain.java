package ua.knu.transport.model;

import java.util.ArrayList;
import java.util.List;

public class PassengerTrain {
    private final String trainNumber;
    private final List<PassengerCarriage> carriages;

    public PassengerTrain(String trainNumber) {
        this.trainNumber = trainNumber;
        this.carriages = new ArrayList<>(); // Створюємо порожній список для вагонів
    }

    public String getTrainNumber() { 
        return trainNumber; 
    }
    
    public List<PassengerCarriage> getCarriages() { 
        return carriages; 
    }

    // Метод для причеплення нового вагона до поїзда
    public void addCarriage(PassengerCarriage carriage) {
        this.carriages.add(carriage);
    }
}
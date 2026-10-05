package ua.knu.transport.service;

import ua.knu.transport.model.PassengerCarriage;
import ua.knu.transport.model.PassengerTrain;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TrainService {

    // 1. Підрахунок загальної кількості пасажирів у поїзді
    public int calculateTotalPassengerCapacity(PassengerTrain train) {
        return train.getCarriages().stream()
                .mapToInt(PassengerCarriage::getPassengerCapacity) // беремо кількість місць з кожного вагона
                .sum(); // додаємо їх усі
    }

    // 2. Підрахунок загальної вантажопідйомності багажу
    public double calculateTotalBaggageCapacity(PassengerTrain train) {
        return train.getCarriages().stream()
                .mapToDouble(PassengerCarriage::getBaggageCapacityKg)
                .sum();
    }

    // 3. Сортування вагонів за рівнем комфортності
    // (Порядок задано в enum: VIP буде першим, потім COMPARTMENT, потім ECONOMY)
    public List<PassengerCarriage> sortCarriagesByComfortLevel(PassengerTrain train) {
        return train.getCarriages().stream()
                .sorted(Comparator.comparing(PassengerCarriage::getComfortLevel))
                .collect(Collectors.toList());
    }

    // 4. Пошук вагонів у заданому діапазоні кількості пасажирів (наприклад, від 15 до 30 місць)
    public List<PassengerCarriage> findCarriagesByPassengerCapacityRange(PassengerTrain train, int min, int max) {
        return train.getCarriages().stream()
                .filter(c -> c.getPassengerCapacity() >= min && c.getPassengerCapacity() <= max) // фільтруємо
                .collect(Collectors.toList()); // збираємо результат у новий список
    }
}
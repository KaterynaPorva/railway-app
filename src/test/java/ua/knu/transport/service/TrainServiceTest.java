package ua.knu.transport.service;

import org.junit.jupiter.api.Test;
import ua.knu.transport.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrainServiceTest {

    @Test
    public void testAddCarriageToTrain() {
        PassengerTrain train = new PassengerTrain("Тестовий");
        train.addCarriage(new EconomyCarriage("П-01", 54, 1620.0));
        
        assertEquals(1, train.getCarriages().size(), "Поїзд повинен містити 1 вагон після додавання");
    }

    @Test
    public void testCalculateTotalPassengerCapacity() {
        PassengerTrain train = new PassengerTrain("Тестовий");
        train.addCarriage(new EconomyCarriage("П-01", 54, 1620.0));
        train.addCarriage(new CompartmentCarriage("К-01", 36, 1080.0));

        TrainService service = new TrainService();
        int totalCapacity = service.calculateTotalPassengerCapacity(train);

        assertEquals(90, totalCapacity, "Загальна місткість має бути 90 пасажирів");
    }

    @Test
    public void testCalculateTotalBaggageCapacity() {
        PassengerTrain train = new PassengerTrain("Тестовий");
        train.addCarriage(new EconomyCarriage("П-01", 54, 1620.0));
        train.addCarriage(new SleepingCarriage("СВ-01", 18, 540.0));

        TrainService service = new TrainService();
        double totalBaggage = service.calculateTotalBaggageCapacity(train);

        assertEquals(2160.0, totalBaggage, 0.01, "Загальний багаж має бути 2160.0 кг");
    }

    @Test
    public void testSortCarriagesByComfortLevel() {
        PassengerTrain train = new PassengerTrain("Тестовий");
        train.addCarriage(new EconomyCarriage("П-01", 54, 1620.0));
        train.addCarriage(new SleepingCarriage("СВ-01", 18, 540.0));

        TrainService service = new TrainService();
        List<PassengerCarriage> sorted = service.sortCarriagesByComfortLevel(train);

        assertEquals(ComfortLevel.VIP, sorted.get(0).getComfortLevel(), "Першим має йти вагон VIP");
        assertEquals(ComfortLevel.ECONOMY, sorted.get(1).getComfortLevel(), "Другим має йти вагон ECONOMY");
    }

    @Test
    public void testFindCarriagesByPassengerCapacityRange() {
        PassengerTrain train = new PassengerTrain("Тестовий");
        train.addCarriage(new SleepingCarriage("СВ-01", 18, 540.0));      // не підходить
        train.addCarriage(new CompartmentCarriage("К-01", 36, 1080.0));   // підходить
        train.addCarriage(new EconomyCarriage("П-01", 54, 1620.0));       // не підходить

        TrainService service = new TrainService();
        // Шукаємо вагони, де від 30 до 40 місць
        List<PassengerCarriage> found = service.findCarriagesByPassengerCapacityRange(train, 30, 40);

        assertEquals(1, found.size(), "Має знайтись рівно 1 вагон");
        assertTrue(found.get(0) instanceof CompartmentCarriage, "Знайдений вагон має бути купейним");
    }
}
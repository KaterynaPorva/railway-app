package ua.knu.transport;

import ua.knu.transport.model.*;
import ua.knu.transport.service.TrainService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Створюємо наш поїзд
        PassengerTrain train = new PassengerTrain("749 Київ - Трускавець");

        // 2. Створюємо вагони (СВ, Купе, Плацкарт)
        PassengerCarriage sv1 = new SleepingCarriage("СВ-01", 18, 540.0);
        PassengerCarriage coupe1 = new CompartmentCarriage("К-01", 36, 1080.0);
        PassengerCarriage coupe2 = new CompartmentCarriage("К-02", 36, 1080.0);
        PassengerCarriage economy1 = new EconomyCarriage("П-01", 54, 1620.0);

        // 3. Причіпляємо вагони до поїзда (впереміш, щоб перевірити сортування)
        train.addCarriage(economy1);
        train.addCarriage(sv1);
        train.addCarriage(coupe2);
        train.addCarriage(coupe1);

        // 4. Створюємо сервіс (нашу логіку)
        TrainService service = new TrainService();

        // --- ВИВОДИМО РЕЗУЛЬТАТИ В КОНСОЛЬ ---
        System.out.println("=== Поїзд: " + train.getTrainNumber() + " ===");
        System.out.println("Загальна місткість (пасажирів): " + service.calculateTotalPassengerCapacity(train));
        System.out.println("Загальна вантажопідйомність багажу (кг): " + service.calculateTotalBaggageCapacity(train));

        System.out.println("\n=== Вагони відсортовані за рівнем комфорту (VIP -> COMPARTMENT -> ECONOMY) ===");
        List<PassengerCarriage> sortedCarriages = service.sortCarriagesByComfortLevel(train);
        sortedCarriages.forEach(System.out::println);

        System.out.println("\n=== Вагони з місткістю від 30 до 40 пасажирів (тільки Купе) ===");
        List<PassengerCarriage> filteredCarriages = service.findCarriagesByPassengerCapacityRange(train, 30, 40);
        filteredCarriages.forEach(System.out::println);
    }
}
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

class RentalServiceTest {
    private RentalService rentalService;
    private Vehicle car;
    private Vehicle motorcycle;

    @BeforeEach
    void setUp() {
        rentalService = new RentalService();
        car = new Car("ABC-1234", "Toyota Corolla", 50.0, true);
        motorcycle = new Motorcycle("XYZ-5678", "Honda CB600", 30.0, 600);

        rentalService.addVehicle(car);
        rentalService.addVehicle(motorcycle);
    }

    @Test
    void calculatesRentalCostForCarWithAndWithoutAirConditioning() {
        Vehicle carWithAirConditioning = new Car("AAA-1111", "Car A", 50.0, true);
        Vehicle carWithoutAirConditioning = new Car("BBB-2222", "Car B", 50.0, false);

        assertEquals(165.0, carWithAirConditioning.calculateRentalCost(3), 0.001);
        assertEquals(150.0, carWithoutAirConditioning.calculateRentalCost(3), 0.001);
    }

    @Test
    void calculatesRentalCostForMotorcycleWithSmallAndLargeEngine() {
        Vehicle smallMotorcycle = new Motorcycle("CCC-3333", "Motorcycle A", 30.0, 500);
        Vehicle largeMotorcycle = new Motorcycle("DDD-4444", "Motorcycle B", 30.0, 600);

        assertEquals(90.0, smallMotorcycle.calculateRentalCost(3), 0.001);
        assertEquals(108.0, largeMotorcycle.calculateRentalCost(3), 0.001);
    }

    @Test
    void findsVehicleByLicensePlateWhenItExists() {
        assertSame(car, rentalService.findVehicleByLicensePlate("ABC-1234"));
    }

    @Test
    void returnsNullWhenLicensePlateDoesNotExist() {
        assertNull(rentalService.findVehicleByLicensePlate("NOT-FOUND"));
    }

    @Test
    void calculatesTotalIncomeForDifferentNumbersOfDays() {
        assertEquals(91.0, rentalService.calculateTotalIncome(1), 0.001);
        assertEquals(273.0, rentalService.calculateTotalIncome(3), 0.001);
        assertEquals(455.0, rentalService.calculateTotalIncome(5), 0.001);
    }
}

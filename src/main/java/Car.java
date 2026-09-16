public class Car extends Vehicle {
    private final boolean hasAirConditioning;

    public Car(String licensePlate, String model, double dailyRate, boolean hasAirConditioning) {
        super(licensePlate, model, dailyRate);
        this.hasAirConditioning = hasAirConditioning;
    }

    @Override
    public double calculateRentalCost(int days) {
        double totalCost = getDailyRate() * days;

        if (hasAirConditioning) {
            totalCost *= 1.10;
        }

        return totalCost;
    }
}

public class Motorcycle extends Vehicle {
    private final int engineCC;

    public Motorcycle(String licensePlate, String model, double dailyRate, int engineCC) {
        super(licensePlate, model, dailyRate);
        this.engineCC = engineCC;
    }

    @Override
    public double calculateRentalCost(int days) {
        double totalCost = getDailyRate() * days;

        if (engineCC > 500) {
            totalCost *= 1.20;
        }

        return totalCost;
    }
}

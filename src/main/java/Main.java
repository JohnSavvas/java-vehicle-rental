/*
 * Αντικειμενοστρεφής Προγραμματισμός - Εργασία Java
 * Ακαδημαϊκό Έτος: 2023-2024
 * Φοιτητής: John Savvas
 */
public class Main {
    public static void main(String[] args) {
        RentalService rentalService = new RentalService();

        Vehicle car = new Car("ABC-1234", "Toyota Corolla", 50.0, true);
        Vehicle motorcycle = new Motorcycle("XYZ-5678", "Honda CB600", 30.0, 600);

        rentalService.addVehicle(car);
        rentalService.addVehicle(motorcycle);

        int days = 3;

        System.out.println(car.getDetails());
        System.out.println("Rental cost for " + days + " days: " + car.calculateRentalCost(days));
        System.out.println(motorcycle.getDetails());
        System.out.println("Rental cost for " + days + " days: " + motorcycle.calculateRentalCost(days));
        System.out.println("Vehicle found: "
                + rentalService.findVehicleByLicensePlate("ABC-1234").getDetails());
        System.out.println("Total income: " + rentalService.calculateTotalIncome(days));
    }
}

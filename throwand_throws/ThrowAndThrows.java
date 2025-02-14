package Day4_Exceptions.throwand_throws;



public class ThrowAndThrows {

    //Method to calculate interest
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount and rate must be positive");
        }

        //Calculate interest
        return amount * rate * years / 100;
    }

    public static void main(String[] args) {
        //input values
        double amount = 1000.0;
        double rate = -5.0;
        int years = 10;

        try {
            //Call the calculateInterest method
            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated interest: " + interest);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }
}

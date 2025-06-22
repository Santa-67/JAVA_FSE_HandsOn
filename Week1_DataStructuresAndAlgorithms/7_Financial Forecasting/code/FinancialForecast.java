import java.util.Scanner;
public class FinancialForecast {
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, rate, years - 1) * (1 + rate);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the present value (e.g., 10000): ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (in %, e.g., 5 for 5%): ");
        double rate = scanner.nextDouble() / 100.0;

        System.out.print("Enter the number of years to forecast: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(presentValue, rate, years);

        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);

        scanner.close();
    }
}

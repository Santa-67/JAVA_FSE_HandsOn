// Main.java
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "Alice"));
        context.executePayment(250.00);

        // Switch to PayPal
        context.setPaymentStrategy(new PayPalPayment("alice@example.com"));
        context.executePayment(180.50);
    }
}

public class Main {
    public static void main(String[] args) {
        // Using PayPal through adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.00);

        // Using Stripe through adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(250.00);
    }
}
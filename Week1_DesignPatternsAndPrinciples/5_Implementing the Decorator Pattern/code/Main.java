// Main.java
public class Main {
    public static void main(String[] args) {
        // Basic email notification
        Notifier email = new EmailNotifier();

        // Email + SMS notification
        Notifier emailAndSMS = new SMSNotifierDecorator(email);

        // Email + SMS + Slack notification
        Notifier fullNotifier = new SlackNotifierDecorator(emailAndSMS);

        // Send notification
        System.out.println("=== Sending Notification ===");
        fullNotifier.send("Server is down!");
    }
}

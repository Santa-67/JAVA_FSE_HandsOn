// Main.java
public class Main {
    public static void main(String[] args) {
        // Inject repository into service
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repository);

        // Use service to find customer
        Customer customer = service.findCustomerById("C001");

        if (customer != null) {
            System.out.println("Customer found: " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}

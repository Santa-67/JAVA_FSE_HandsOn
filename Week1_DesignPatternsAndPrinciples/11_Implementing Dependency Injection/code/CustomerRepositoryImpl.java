// CustomerRepositoryImpl.java
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Sample data
        database.put("C001", new Customer("C001", "Alice Johnson"));
        database.put("C002", new Customer("C002", "Bob Smith"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return database.get(id);
    }
}

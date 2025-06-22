// MobileApp.java
public class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(double stockPrice) {
        System.out.println(name + " (Mobile App) received stock update: $" + stockPrice);
    }
}

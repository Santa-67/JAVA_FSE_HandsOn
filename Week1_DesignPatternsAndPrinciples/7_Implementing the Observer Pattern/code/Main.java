// Main.java
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("ClientA");
        Observer webApp = new WebApp("ClientB");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setStockPrice(150.75);
        stockMarket.setStockPrice(158.20);

        stockMarket.removeObserver(mobileApp);

        stockMarket.setStockPrice(162.00);
    }
}

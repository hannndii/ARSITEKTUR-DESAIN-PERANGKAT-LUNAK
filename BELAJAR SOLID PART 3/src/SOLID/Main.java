package SOLID;
import java.util.*;

interface CashPaymentMethod {
    void pay(double amount);
}

interface EwalletPaymentMethod {
    void pay(String phoneNumber, double amount);
}

class CashPayment implements CashPaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Pembayaran tunai sebesar: Rp" + amount);
    }
}

class EwalletPayment implements EwalletPaymentMethod {
    @Override
    public void pay(String phoneNumber, double amount) {
        System.out.println("Pembayaran e-wallet sebesar Rp" + amount + " dari nomor: " + phoneNumber);
    }
}

class CartItem {
    private String name;
    private int qty;
    private double price;

    public CartItem(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQty() {
        return qty;
    }

    public double getPrice() {
        return price;
    }

    public double getSubtotal() {
        return price * qty;
    }
}

class MenuCatalog {
    private Map<String, Double> menuItems = new HashMap<>();

    public MenuCatalog() {
        menuItems.put("Nasi Goreng", 15000.0);
        menuItems.put("Mie Ayam", 12000.0);
        menuItems.put("Sate", 20000.0);
    }

    public void displayMenu() {
        System.out.println("Daftar Menu:");
        for (Map.Entry<String, Double> item : menuItems.entrySet()) {
            System.out.println("- " + item.getKey() + " (Rp" + item.getValue() + ")");
        }
    }

    public boolean hasItem(String itemName) {
        return menuItems.containsKey(itemName);
    }

    public double getPrice(String itemName) {
        return menuItems.getOrDefault(itemName, 0.0);
    }

    public void addMenuItem(String name, double price) {
        menuItems.put(name, price);
    }
}

class ShoppingCart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(String name, int qty, double price) {
        items.add(new CartItem(name, qty, price));
        System.out.println(qty + " " + name + " ditambahkan ke keranjang.");
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items);
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public void clear() {
        items.clear();
    }
}

class ReceiptPrinter {
    public void printReceipt(List<CartItem> items, double total) {
        System.out.println("=== Struk Pembelian ===");
        for (CartItem item : items) {
            System.out.println(item.getName() + " x" + item.getQty() + " = Rp" + item.getSubtotal());
        }
        System.out.println("Total: Rp" + total);
    }
}

class TransactionLogger {
    private List<String> logs = new ArrayList<>();

    public void logTransaction(List<CartItem> items, double total) {
        logs.add("Transaksi baru:");
        for (CartItem item : items) {
            logs.add(item.getName() + " x" + item.getQty());
        }
        logs.add("Total: Rp" + total);
        logs.add("------------");
    }

    public void showLogs() {
        System.out.println("=== Log Transaksi ===");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}

interface PaymentStrategy {
    boolean processPayment(double amount, double total);
}

class CashPaymentStrategy implements PaymentStrategy {
    private CashPaymentMethod cashPayment;

    public CashPaymentStrategy(CashPaymentMethod cashPayment) {
        this.cashPayment = cashPayment;
    }

    @Override
    public boolean processPayment(double amount, double total) {
        if (amount < total) {
            System.out.println("Jumlah tidak mencukupi. Total: Rp" + total);
            return false;
        }

        cashPayment.pay(amount);
        System.out.println("Kembalian: Rp" + (amount - total));
        return true;
    }
}

class EwalletPaymentStrategy implements PaymentStrategy {
    private EwalletPaymentMethod ewalletPayment;
    private String phoneNumber;

    public EwalletPaymentStrategy(EwalletPaymentMethod ewalletPayment, String phoneNumber) {
        this.ewalletPayment = ewalletPayment;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean processPayment(double amount, double total) {
        if (amount < total) {
            System.out.println("Saldo tidak mencukupi. Total: Rp" + total);
            return false;
        }

        ewalletPayment.pay(phoneNumber, total);
        return true;
    }
}

class OrderService {
    private MenuCatalog menuCatalog;
    private ShoppingCart cart;
    private ReceiptPrinter receiptPrinter;
    private TransactionLogger logger;

    public OrderService(MenuCatalog menuCatalog, ShoppingCart cart, 
                        ReceiptPrinter receiptPrinter, TransactionLogger logger) {
        this.menuCatalog = menuCatalog;
        this.cart = cart;
        this.receiptPrinter = receiptPrinter;
        this.logger = logger;
    }

    public void displayMenu() {
        menuCatalog.displayMenu();
    }

    public void addItemToCart(String name, int qty) {
        if (menuCatalog.hasItem(name)) {
            double price = menuCatalog.getPrice(name);
            cart.addItem(name, qty, price);
        } else {
            System.out.println("Menu tidak tersedia: " + name);
        }
    }

    public double getTotal() {
        return cart.calculateTotal();
    }

    public void processOrder(PaymentStrategy paymentStrategy) {
        double total = cart.calculateTotal();
        
        if (paymentStrategy.processPayment(total, total)) {
            receiptPrinter.printReceipt(cart.getItems(), total);
            logger.logTransaction(cart.getItems(), total);
            cart.clear();
        }
    }
    
    public void showTransactionLogs() {
        logger.showLogs();
    }
}

public class Main {
    public static void main(String[] args) {
        MenuCatalog menuCatalog = new MenuCatalog();
        ShoppingCart cart = new ShoppingCart();
        ReceiptPrinter receiptPrinter = new ReceiptPrinter();
        TransactionLogger logger = new TransactionLogger();
        
        OrderService orderService = new OrderService(menuCatalog, cart, receiptPrinter, logger);
        
        orderService.displayMenu();
        
        orderService.addItemToCart("Nasi Goreng", 2);
        orderService.addItemToCart("Sate", 1);
        
        double total = orderService.getTotal();
        System.out.println("Total yang harus dibayar: Rp" + total);
        
        CashPaymentMethod cashPayment = new CashPayment();
        PaymentStrategy cashStrategy = new CashPaymentStrategy(cashPayment);
        orderService.processOrder(cashStrategy);
        
        orderService.showTransactionLogs();
        
        orderService.addItemToCart("Mie Ayam", 1);
        
        EwalletPaymentMethod ewalletPayment = new EwalletPayment();
        PaymentStrategy ewalletStrategy = new EwalletPaymentStrategy(ewalletPayment, "081234567890");
        orderService.processOrder(ewalletStrategy);
        
        orderService.showTransactionLogs();
    }
}
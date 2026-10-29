package lk.kaushalya.long_method;

// BadCode: Long Method Anti-Pattern
class Checkout {
    void processOrder(String customerName, String productName, int productQuantity, double productPrice) {

        // 1. Validate customer name inline
        if (customerName == null || customerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }

        // 2. Validate product name inline
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }

        // 3. Validate product quantity inline
        if (productQuantity <= 0) {
            throw new IllegalArgumentException("Product quantity must be greater than zero");
        }

        // 4. Validate product price inline
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }

        // 5. Calculate total price
        double totalPrice = productQuantity * productPrice;

        // 6. Process payment inline
        System.out.println("Processing payment for: " + customerName);
        System.out.println("Amount to deduct: $" + totalPrice);
        // (More payment gateway logic would go here, making the method even longer)

        // 7. Generate invoice inline
        System.out.println("----- INVOICE -----");
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + productQuantity);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("-------------------");
    }
}

// Anti-Pattern: Long Method

class CheckoutWithLongMethod {
    void processOrder(String customerName, String productName, int productQuantity, double productPrice) {

        // Validate customer name
        if(!isValidCustomerName(customerName)) {
            throw new IllegalArgumentException("Invalid customer name");
        }
        // Validate product name
        if(!isValidProductName(productName)) {
            throw new IllegalArgumentException("Invalid product name");
        }
        // Validate product quantity
        if(!isValidProductQuantity(productQuantity)) {
            throw new IllegalArgumentException("Invalid product quantity");
        }

        // Validate product price
        if(!isValidProductPrice(productPrice)) {
            throw new IllegalArgumentException("Invalid product price");
        }

        // Calculate total price
        double totalPrice = productQuantity * productPrice;

        // Process payment
        processPayment(customerName, totalPrice);

        // Generate invoice
        generateInvoice(customerName, productName, productQuantity, totalPrice);
    }

    private boolean isValidCustomerName(String customerName) {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Customer name cannot be null or empty");
        }
        return true;
    }
    private  boolean isValidProductName(String productName) {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be null or empty");
        }
        return true;
    }
    private  boolean  isValidProductQuantity(int productQuantity) {
        if (productQuantity <= 0) {
            throw new IllegalArgumentException("Product quantity must be greater than zero");
        }
        return true;
    }
    private  boolean isValidProductPrice(double productPrice) {
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        return true;
    }
    private void processPayment(String customerName, double totalPrice) {
        System.out.println("Processing payment for: " + customerName);
        System.out.println("Amount to deduct: $" + totalPrice);
    }

    private void generateInvoice(String customerName, String productName, int productQuantity, double totalPrice) {
        System.out.println("----- INVOICE -----");
        System.out.println("Customer: " + customerName);
        System.out.println("Product: " + productName);
        System.out.println("Quantity: " + productQuantity);
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("-------------------");
    }
}

public class Test {
    public static void main(String[] args) {

        // Test the Checkout class with long method
        Checkout checkout = new Checkout();
        checkout.processOrder("John Doe", "Laptop", 2, 1200.00);

        // Test the CheckoutWithLongMethod class with refactored methods
        CheckoutWithLongMethod checkoutWithLongMethod = new CheckoutWithLongMethod();
        checkoutWithLongMethod.processOrder("Jane Smith", "Smartphone", 1, 800.00);
    }
}

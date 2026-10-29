package lk.kaushalya.copy_paste_programming;

// BadCode
class DiscountService {
    void calculateRegularDiscount(double price) {
        double discount = price * 0.10;
        double finalPrice = price - discount;

        System.out.println("Regular customer discount: " + discount);
        System.out.println("Regular customer final price: " + finalPrice);
    }

    void calculatePremiumDiscount(double price) {
        // Duplicated calculation logic
        double discount = price * 0.10;
        double finalPrice = price - discount;

        System.out.println("Premium customer discount: " + discount);
        System.out.println("Premium customer final price: " + finalPrice);
    }
}

// Anti-Pattern
class DiscountServiceImproved {
    void calculateDiscount(String customerType, double price, double discountRate) {

        double discount = price * discountRate;
        double finalPrice = price - discount;

        System.out.println(customerType + " customer discount: " + discount);
        System.out.println(customerType + " customer final price: " + finalPrice);
    }
}

public class Test {
    public static void main(String[] args) {

        // Bad Code
        DiscountService discountService = new DiscountService();
        discountService.calculateRegularDiscount(1000);
        discountService.calculatePremiumDiscount(1000);

        // Anti-Pattern Code
        DiscountServiceImproved discountServiceImproved = new DiscountServiceImproved();
        discountServiceImproved.calculateDiscount("Regular", 1000, 0.10);
        discountServiceImproved.calculateDiscount("Premium", 1000, 0.20);
    }
}

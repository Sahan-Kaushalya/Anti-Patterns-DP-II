package lk.kaushalya.primitive_obsession;

import java.math.BigDecimal;
import java.util.Currency;

// ==========================================
// Bad Code: Primitive Obsession Anti-Pattern
// ==========================================
class PaymentProcessor {
    // Using primitives (double, String) for complex domain concepts like Money
    void processPayment(double amount, String currencyCode) {

        // Validation logic is scattered everywhere
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (currencyCode == null || (!currencyCode.equals("USD") && !currencyCode.equals("LKR"))) {
            throw new IllegalArgumentException("Invalid currency");
        }

        // Floating-point arithmetic error risk!
        // e.g., 0.1 + 0.2 in double equals 0.30000000000000004
        double tax = amount * 0.15;
        double total = amount + tax;

        System.out.println("Processed payment of: " + total + " " + currencyCode);
    }
}

// ==========================================
// Good Code: Refactored with Domain Objects
// ==========================================

// 1. Create a "Value Object" to represent Money
class Money {
    private final BigDecimal amount;
    private final Currency currency;

    public Money(BigDecimal amount, Currency currency) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money addTax(double percentage) {
        BigDecimal taxRate = BigDecimal.valueOf(percentage);
        BigDecimal taxAmount = this.amount.multiply(taxRate);
        BigDecimal newTotal = this.amount.add(taxAmount);
        return new Money(newTotal, this.currency);
    }

    public String getFormattedAmount() {
        return currency.getSymbol() + " " + amount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}

// 2. The Service class now uses the Object, not primitives
class CleanPaymentProcessor {
    void processPayment(Money money) {
        // No validation needed here! The Money object guarantees its own validity.
        Money totalWithTax = money.addTax(0.15);
        System.out.println("Processed payment of: " + totalWithTax.getFormattedAmount());
    }
}


public class Test {
    public static void main(String[] args) {
        // --- Testing Bad Code ---
        PaymentProcessor badProcessor = new PaymentProcessor();
        badProcessor.processPayment(100.50, "LKR");
        System.out.println("--------------------------------");

        // --- Testing Good Code ---
        CleanPaymentProcessor goodProcessor = new CleanPaymentProcessor();

        // Using BigDecimal ensures 100% precision for financial calculations
        Money myMoney = new Money(new BigDecimal("100.50"), Currency.getInstance("LKR"));
        goodProcessor.processPayment(myMoney);
    }
}
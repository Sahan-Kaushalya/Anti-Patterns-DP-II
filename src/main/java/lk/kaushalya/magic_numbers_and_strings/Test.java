package lk.kaushalya.magic_numbers_and_strings;

// ==========================================
// Bad Code: Magic Numbers and Strings Anti-Pattern
// ==========================================
class StudentGraderBad {
    void evaluateStudent(int marks, String paymentStatus) {

        // Magic Numbers (75, 65, 50) - මෙහි 75 යනු කුමක්දැයි පැහැදිලි කිරීමක් නැත
        if (marks >= 75) {
            System.out.println("Grade: A");
        } else if (marks >= 65) {
            System.out.println("Grade: B");
        } else if (marks >= 50) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        // Magic String ("PAID") - වැරදි අකුරු ටයිප් වීමේ අවදානමක් ඇත (උදා: "PIAD")
        if (paymentStatus.equals("PAID")) {
            System.out.println("Student can register.");
        }
    }
}

// ==========================================
// Good Code: Refactored with Constants and Enums
// ==========================================

// String වෙනුවට Type-safe Enum එකක් භාවිතා කිරීම
enum PaymentStatus {
    PENDING,
    PAID,
    FAILED
}

class StudentGraderGood {

    // Magic Numbers වෙනුවට Named Constants (නියතයන්) භාවිතා කිරීම
    private static final int GRADE_A_MIN = 75;
    private static final int GRADE_B_MIN = 65;
    private static final int GRADE_C_MIN = 50;

    void evaluateStudent(int marks, PaymentStatus paymentStatus) {

        // අගයන් වල අර්ථය දැන් ඉතා පැහැදිලිය
        if (marks >= GRADE_A_MIN) {
            System.out.println("Grade: A");
        } else if (marks >= GRADE_B_MIN) {
            System.out.println("Grade: B");
        } else if (marks >= GRADE_C_MIN) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }

        // Enum මගින් Type Safety තහවුරු කර ඇත
        if (paymentStatus == PaymentStatus.PAID) {
            System.out.println("Student can register.");
        }
    }
}

public class Test {
    public static void main(String[] args) {

        System.out.println("--- Bad Code Execution ---");
        StudentGraderBad badGrader = new StudentGraderBad();
        // මෙහි "PAID" යන්න String එකක් ලෙස යවයි
        badGrader.evaluateStudent(78, "PAID");

        System.out.println("\n--- Good Code (Refactored) Execution ---");
        StudentGraderGood goodGrader = new StudentGraderGood();
        // මෙහිදී Enum අගය භාවිතා කරයි, එබැවින් වැරදීම් සිදු නොවේ
        goodGrader.evaluateStudent(78, PaymentStatus.PAID);
    }
}
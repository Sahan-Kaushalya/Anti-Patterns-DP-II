package lk.kaushalya.god_object;

// BadCode
class UniversitySystem {
   void registerStudent(String name){
       System.out.println("Student registered."+name);
   }

    void calculateFees(int subjects){
       double fees = subjects * 1000;
        System.out.println("Total Fees calculated: "+fees);
    }

    void recordExamResult(String subject ,int marks){
        System.out.println("Exam result recorded for subject: "+subject+" with marks: "+marks);
    }

    void generateReport(String name,int marks){
        System.out.println("Report generated for student: "+name);
        System.out.println("Marks: "+marks);
        System.out.println("Result: "+(marks>=50?"Pass":"Fail"));
    }
}

// AntiPattern
class StudentService {
    void registerStudent(String name){
        System.out.println("Student registered."+name);
    }
}

class FeeService {
    void calculateFees(int subjects){
        double fees = subjects * 1000;
        System.out.println("Total Fees calculated: "+fees);
    }
}

class ExamService {
    void recordExamResult(String subject ,int marks){
        System.out.println("Exam result recorded for subject: "+subject+" with marks: "+marks);
    }
}

class ReportService {
    void generateReport(String name,int marks){
        System.out.println("Report generated for student: "+name);
        System.out.println("Marks: "+marks);
        System.out.println("Result: "+(marks>=50?"Pass":"Fail"));
    }
}

public class Test {
    public static void main(String[] args) {
        // Bad Code
        UniversitySystem universitySystem = new UniversitySystem();
        universitySystem.registerStudent("John Doe");
        universitySystem.calculateFees(5);
        universitySystem.recordExamResult("Math", 85);
        universitySystem.generateReport("John Doe", 85);

        // Anti Pattern
        StudentService studentService = new StudentService();
        studentService.registerStudent("Jane Doe");

        FeeService feeService = new FeeService();
        feeService.calculateFees(4);

        ExamService examService = new ExamService();
        examService.recordExamResult("Science", 75);

        ReportService reportService = new ReportService();
        reportService.generateReport("Jane Doe", 75);

    }
}
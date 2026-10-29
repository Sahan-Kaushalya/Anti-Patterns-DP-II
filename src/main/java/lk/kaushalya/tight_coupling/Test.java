package lk.kaushalya.tight_coupling;

// BadCode: Tight Coupling
class SmsSender{
    public void sendSms(String message){
        System.out.println("Sending SMS: " + message);
    }
}

class StudentNotification{
    private SmsSender smsSender = new SmsSender(); // Tight coupling with SmsSender

    public void notifyStudent(String message){
        smsSender.sendSms(message);
    }
}

// Anti-Pattern: Tight Coupling
interface MessageSender {
    void sendMessage(String message);
}

class SmsSenderV2 implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class EmailSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("Sending Email: " + message);
    }
}

class WhatsappSender implements MessageSender {
    public void sendMessage(String message) {
        System.out.println("Sending WhatsApp message: " + message);
    }
}

class StudentNotificationV2 {

    private MessageSender messageSender;

    public StudentNotificationV2(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void notifyStudent(String message) {
        messageSender.sendMessage(message);
    }

    public void setMessageSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }
}
public class Test {
    public static void main(String[] args) {
        // BadCode: Tight Coupling
        StudentNotification notification = new StudentNotification();
        notification.notifyStudent("You have a new message!");
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();

        // Anti-Pattern: Loose Coupling
        StudentNotificationV2 notificationV2 = new StudentNotificationV2(new SmsSenderV2());
        notificationV2.notifyStudent("You have a new message via SMS!");
        notificationV2.setMessageSender(new EmailSender());
        notificationV2.notifyStudent("You have a new message via Email!");
        notificationV2.setMessageSender(new WhatsappSender());
        notificationV2.notifyStudent("You have a new message via WhatsApp!");
    }
}

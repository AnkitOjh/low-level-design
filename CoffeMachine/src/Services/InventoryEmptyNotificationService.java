package Services;

public class InventoryEmptyNotificationService implements NotificationService {
    @Override
    public void sendMessage() {
        System.out.println("Message has been sent");
    }
}

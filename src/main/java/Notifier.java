import java.util.ArrayList;
import java.util.List;

//public class Notification {
//    public void notify(String msg) {
//        System.out.println(msg);
//    }
//}

public class Notifier {
    List<User> subscribers;

    public Notifier() {
        this.subscribers = new ArrayList<>();
    }

    void addSubscriber(User user) {
        this.subscribers.add(user);
    }

    void notifyObservers(boolean isParkingAvailable) {
        for (User user: this.subscribers) {
            user.notify(isParkingAvailable);
        }
    }
}
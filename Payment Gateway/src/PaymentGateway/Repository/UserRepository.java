package PaymentGateway.Repository;

import PaymentGateway.Instrument.Instrument;
import PaymentGateway.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance;
    Map<String, User> userData;

    private UserRepository() {
        this.userData = new HashMap<>();
    }

    public static UserRepository getInstance() {
        if(UserRepository.instance == null) {
            UserRepository.instance = new UserRepository();
        }
        return UserRepository.instance;
    }

    public void addUser(User user) {
        this.userData.put(user.getId(), user);
    }

    public User getUser(String userId) {
        if(userData.containsKey(userId)) return userData.get(userId);
        return null;
    }
}


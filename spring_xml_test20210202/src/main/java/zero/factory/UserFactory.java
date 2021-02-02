package zero.factory;

import zero.model.User;

public class UserFactory {

    public static User sCreateUser() {
        User user = new User(5, "李白");
        return user;
    }

    public User iCreateUser() {
        User user = new User(6, "杜甫");
        return user;
    }
}

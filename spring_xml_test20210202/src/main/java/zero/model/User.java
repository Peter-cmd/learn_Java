package zero.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
public class User {

    public User() {}

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    private User boyFriend;

    private List<User> focus;

    private Set<User> followers;

    private Integer id;

    private String name;

}

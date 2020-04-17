package Zero.ioc;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class DuckShop {
    private String name;
    private List<Duck> ducks;
}

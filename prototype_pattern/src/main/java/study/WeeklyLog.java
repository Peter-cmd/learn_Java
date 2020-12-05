package study;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@EqualsAndHashCode
public class WeeklyLog implements Cloneable {

    private String name;

    private String date;

    private String content;

    @Override
    public Object clone() {
        Object object;

        try {
            object = super.clone();
            return object;
        }catch(CloneNotSupportedException e) {
            System.out.println("不能复制!");
            return null;
        }
    }

}

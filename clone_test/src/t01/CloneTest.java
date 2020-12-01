package t01;

public class CloneTest implements Cloneable {
    private Integer i = 0;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


}

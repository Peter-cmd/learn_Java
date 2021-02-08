package child;

import java.io.Serializable;

class Parent {
    public Parent(){}
}

public class Child implements Serializable {

    private static final long serialVersionUID = 100000L;

    public static int a = 2;

    public transient int b = 4;

    public Child(){}

}

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayout {
    public static void main(String[] args){
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        String s = new String();
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
        s.hashCode();
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
    }
}

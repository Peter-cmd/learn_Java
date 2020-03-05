package demo0002;
class Person{
    private String name = "Person";
    private int age = 0;

}

public class Student extends Person{

    private String grade;
    public static void main(String[] args){
        Person person = new Student();
        System.out.println((((Student) person).grade));
    }
}

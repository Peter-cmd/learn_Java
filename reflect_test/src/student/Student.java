package student;

public class Student {
    public String name = null;
    public Integer age = null;
    public String sex = null;
    private Student() {

    }



    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void eat(String food) {
        System.out.println(this.name + "喜欢吃" + food + ".");
    }

    @Override
    public String toString() {
        return "Student{name:" + name
                + " age:" + age + " sex:" + sex + "}";
    }
}

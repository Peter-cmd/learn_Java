public class Employee {
    private String name;
    private Integer age;
    private Status status;

    public Employee() {

    }

    public Employee(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Employee(String name, Integer age, Status status) {
        this.name = name;
        this.age = age;
        this.status = status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return  false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }else if (!name.equals(other.name))
            return false;
        return true;
    }


    public Employee(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", status=" + status +
                '}';
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION;
    }

    public Status getStatus() {
        return status;
    }

}

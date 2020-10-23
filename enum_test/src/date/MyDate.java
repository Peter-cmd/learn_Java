package date;


public enum MyDate {

    SUNDAY("SUNDAY", 0),
    MONDAY("MONDAY", 1),
    TUESDAY("TUESDAY", 2),
    WEDNESDAY("WEDNESDAY", 3),
    THURSDAY("TUESDAY", 4),
    FRIDAY("FRIDAY", 5),
    SATURDAY("SATURDAY", 6);


    private String name = null;
    private int index = 0;

    MyDate(String name, int index){
        this.name = name;
        this.index = index;
    }

    public static void selectAll(){
        for (MyDate date : MyDate.values()){
            System.out.println(date.toString());
        }
    }

    @Override
    public String toString(){
        return "name = " + name + " index = " + index;
    }

    }

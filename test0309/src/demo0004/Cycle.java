package demo0004;

public class Cycle extends Shape {
    @Override
    public void draw(){
        System.out.println("画了一个圆");
    }

    public static void main(String[] args){
        Cycle cycle = new Cycle();
        cycle.draw();
    }
}

package demo0004;

public class Rectangle extends Shape{
    @Override
    public void draw(){
        System.out.println("画了一个长方形");
    }

    public static void main(String[] args){
        Rectangle rectangle = new Rectangle();
        rectangle.draw();
    }
}

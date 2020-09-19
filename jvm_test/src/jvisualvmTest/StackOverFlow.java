package jvisualvmTest;

public class StackOverFlow {

    private int length = 0;

    public int getLength(){
        return length;
    }

    public void addLength(){
       this.length++;
       try{
           Thread.sleep(300);
       }catch(InterruptedException e){
           e.printStackTrace();
        }
       addLength();
    }

    public static void main(String[] args){
        StackOverFlow stackOverFlow = new StackOverFlow();


        try{
            stackOverFlow.addLength();
        }catch(Throwable ex){
            System.out.println(stackOverFlow.getLength());
           ex.printStackTrace();
        }
    }
}

package test0126.demo0001;

public class ThreadState {
    public static void main(String[] args){
        for (Thread.State state : Thread.State.values()){
            System.out.println(state);
        }
    }
}

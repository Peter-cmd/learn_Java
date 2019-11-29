package processes;
import process.MyProcess;
import java.util.HashMap;

public class MyProcesses {
    HashMap<String, MyProcess> processes = new HashMap<>();  //保存录入的进程
    private int size = 0;  //待完成进程个数
    //加入进程
    public void insertIntoTail(MyProcess process){
        processes.put(process.getTag(),process);
        size++;
        System.out.println("进程完成录入!");
    }
    //移除进程
    public void removeProcess(MyProcess process){
        processes.remove(process.getTag());
        size--;
        System.out.println("进程完成移除!");
    }
    //打印进程的信息
    public void disPlay(MyProcess process){
        System.out.println("---------------------");
        process.toString();
        System.out.println("---------------------");
    }
    //打印所有待完成进程信息
    public void disPlayAll(){
        for (MyProcess process: processes.values()){
            System.out.println(process.toString());
        }
    }
}

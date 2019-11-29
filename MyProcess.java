package process;

public class MyProcess {
    private String tag;
    private int priority;
    private float enterTime;
    private float serverTime;
    public float startTime;
    public float finishTime;
    public float cycleTime;
    public float authCycleTime;
    public float avgCycleTime;
    public float avgAuthCycleTime;
    //默认构造方法
    public MyProcess() {

        this.tag = null;
        this.priority = 0;
        this.enterTime = 0;
        this.serverTime = 0;
        this.startTime = 0;
        this.finishTime = 0;
        this.cycleTime = 0;
        this.authCycleTime = 0;
        this.avgCycleTime = 0;
        this.avgAuthCycleTime = 0;
    }
    //带参构造方法
    public MyProcess(String tag, int priority, float enterTime,
                     float serverTime, float startTime){
        this.tag = tag;
        this.priority = priority;
        this.enterTime = enterTime;
        this.serverTime = serverTime;
        this.startTime = startTime;
    }
    //获取进程标识符
    public String getTag() {
        return tag;
    }
    //获取进程优先级
    public int getPriority(){
        return priority;
    }
    //获取进程进入时间
    public float getEnterTime() {
        return enterTime;
    }
    //获取进程服务时间
    public float getServerTime() {
        return serverTime;
    }

    @Override
    public String toString() {
        return "MyProcess{" +
                "tag='" + tag + '\'' +
                ", priority=" + priority +
                ", enterTime=" + enterTime +
                ", serverTime=" + serverTime +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", cycleTime=" + cycleTime +
                ", authCycleTime=" + authCycleTime +
                ", avgCycleTime=" + avgCycleTime +
                ", avgAuthCycleTime=" + avgAuthCycleTime +
                '}';
    }
}

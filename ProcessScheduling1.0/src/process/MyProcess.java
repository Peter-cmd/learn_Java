package process;

public class MyProcess {
    private String tag;
    private int priority;
    private float arriveTime;
    private float serverTime;
    public float restOfServerTime;
    public float startTime;
    public float finishTime;
    public float cycleTime;
    public float authCycleTime;
    public static float avgCycleTime = 0;
    public static float avgAuthCycleTime = 0;

    //默认构造方法
    public MyProcess() {
        this.tag = null;
        this.priority = 0;
        this.arriveTime = 0;
        this.serverTime = 0;
        this.restOfServerTime = 0;
        this.startTime = 0;
        this.finishTime = 0;
        this.cycleTime = 0;
        this.authCycleTime = 0;
    }
    //带参构造方法
    public MyProcess(String tag, int priority,
                     float arriveTime, float serverTime){
        this.tag = tag;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.serverTime = serverTime;
        this.restOfServerTime = serverTime;
        this.startTime = 0;
        this.finishTime = 0;
        this.cycleTime = 0;
        this.authCycleTime = 0;
    }

    public MyProcess(String tag, int priority,
                     float arriveTime, float serverTime,
                     float restOfServerTime, float startTime,
                     float finishTime, float cycleTime,
                     float authCycleTime) {
        this.tag = tag;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.serverTime = serverTime;
        this.restOfServerTime = restOfServerTime;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.cycleTime = cycleTime;
        this.authCycleTime = authCycleTime;
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
    public float getArriveTime() {
        return arriveTime;
    }
    //获取进程服务时间
    public float getServerTime() {
        return serverTime;
    }
    //设置进程开始时间
    public void setStartTime(float startTime) {
        this.startTime = startTime;
    }
    //设置进程结束时间
    public void setFinishTime(float finishTime) {
        this.finishTime = finishTime;
    }
    //设置进程周转时间
    public void setCycleTime(float cycleTime) {
        this.cycleTime = cycleTime;
    }
    //设置进程带权周转时间
    public void setAuthCycleTime(float authCycleTime) {
        this.authCycleTime = authCycleTime;
    }

    public static void display(){
        System.out.println("avgCycleTime=" + avgCycleTime);
        System.out.println("avgAuthCycleTime=" + avgAuthCycleTime);
        System.out.println("-------------------------------------------------------------");
    }
    @Override
    public String toString() {
        return "MyProcess{" +
                "tag='" + tag + '\'' +
                ", priority=" + priority +
                ", arriveTime=" + arriveTime +
                ", serverTime=" + serverTime +
                ", startTime=" + startTime +
                ", finishTime=" + finishTime +
                ", cycleTime=" + cycleTime +
                ", authCycleTime=" + authCycleTime;
    }
}

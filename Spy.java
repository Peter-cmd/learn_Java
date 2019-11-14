package test01;

public class Spy extends Thread {
    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;

    //间谍只要知道监控谁,汇报给谁,以及汇报内容即可
    public Spy(HanFeiZi _hanFeiZi, LiSi _liSi,String _type){
        this.hanFeiZi = _hanFeiZi;
        this.liSi = _liSi;
        this.type = _type;
    }

    @Override
    public void run(){
        while(true){
            if (this.type.equals("breakfast")){
                if (hanFeiZi.isHaveBreakfast()) {
                    this.liSi.update("韩非子在吃饭.");
                    //重置状态,继续监控
                    this.hanFeiZi.setHaveBreakfast(false);
                }
            }else{
                if (hanFeiZi.isHaveFun()){
                    this.liSi.update("韩非子在娱乐");
                    this.hanFeiZi.setHaveFun(false);
                }
            }
        }
    }
}

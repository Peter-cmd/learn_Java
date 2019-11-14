package test02;
import test01.IHanFeiZi;
import test01.LiSi;
import test01.ILiSi;

public class HanFeiZi2 implements IHanFeiZi {

    //声明李斯
    private ILiSi lisi = new LiSi();

    //韩非子要吃饭了
    public void haveBreakfast(){
        System.out.println("韩非子:开始吃饭了……");
        //通知李斯
        this.lisi.update("韩非子在吃饭.");
    }

    //韩非子要娱乐了
    public void haveFun(){
        System.out.println("韩非子:开始娱乐了……");
        this.lisi.update("韩非子在娱乐");
    }
}

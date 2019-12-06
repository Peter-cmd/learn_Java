package Algorithm;
import ZoningChain.ZoningChain;
public interface Algorithm {
    //分配内存
    public void malloc(ZoningChain zoningChain);
    //回收内存
    public void free(ZoningChain zoningChain);
}

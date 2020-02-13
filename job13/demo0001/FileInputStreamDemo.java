package job13.demo0001;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream fin = new FileInputStream("E:\\bit\\timg.jpg");
        FileOutputStream fout = new FileOutputStream("E:\\bite\\copytimg.jpg");
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = fin.read(buff)) != -1){
            fout.write(buff, 0, len);
        }
        fin.close();
        fout.close();
    }
}

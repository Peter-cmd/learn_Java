package deserializable;

import child.Child;

import java.io.*;

public class MyDeserializable<T extends Serializable> {

    public void deserializable(String basePath, String fileName, T t) throws IOException {
        // 获取文件的完整路径
        String fullName = basePath + fileName;
        File f = new File(fullName);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        // 若文件不存在, 创建文件
        if (!f.exists()) {
            f.createNewFile();
        }

        // 打开流
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
        // 写入序列化对象
        oos.writeObject(t);

        // 关闭流
        oos.close();
        fos.close();

    }
}

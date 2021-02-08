package serializable;

import java.io.*;

public class MySerializable<T extends Serializable> {
    public T serializable(String baseName, String fileName, T t) throws IOException, ClassNotFoundException {
        String fullName = baseName + fileName;
        File f = new File(fullName);
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        if (!f.exists()) {
            f.createNewFile();
        }

        fis = new FileInputStream(f);
        ois = new ObjectInputStream(fis);
        T t1 = (T)ois.readObject();
        ois.close();
        fis.close();

        return t1;
    }
}

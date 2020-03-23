package org.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class JSONUtil {

    //序列化操作: 将一个java对象状变为Json类型的字符串
    public static String serialize(Object obj){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATA_PATTERN));

        try {
           return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON序列化失败!" + obj, e);
        }
    }

    //从输入流读取数据, 反序列化一个指定的java类
    public static <T> T deserialize(InputStream in, Class<T> clazz){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setDateFormat(new SimpleDateFormat(Constant.DATA_PATTERN));
        try {
            return objectMapper.readValue(in, clazz);
        } catch (IOException e) {
            throw new RuntimeException("JSON反 序列化失败!", e);
        }
    }
}

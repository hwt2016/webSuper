package com.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**与json相关的接口
 * Created by sa on 2017-08-05.
 */
public class JsonConvert {

    private static ObjectMapper mapper = new ObjectMapper();
    private static ObjectMapper objectMapper = new ObjectMapper();
    public static <T> List<T> jsonToObjectList(String json,Class<?> clazz) throws IOException {
        TypeFactory t = TypeFactory.defaultInstance();
        // 指定容器结构和类型（这里是ArrayList和clazz）
        List<T> list = objectMapper.readValue(json,t.constructCollectionType(ArrayList.class,clazz));
        // 如果T确定的情况下可以使用下面的方法：
//         List<T> list = objectMapper.readValue(json, new TypeReference<List<T>>() {});
        return list;
    }

    public static <T> T  jsonToObject(String json,Class<T> clazz){
        JSONObject jsonObject=JSONObject.fromObject(json);
        T t= (T) JSONObject.toBean(jsonObject, clazz);
        return t;
    }

}

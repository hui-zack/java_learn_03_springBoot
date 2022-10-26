package com.hui.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 判断是否符合json格式
     *
     * @param jsonStr json字符串
     * @return boolean
     */
    public static Boolean isJson(String jsonStr) {
        if (null == jsonStr || jsonStr.equals("")){
            return false;
        }
        try {
            objectMapper.readTree(jsonStr);
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    public static ArrayList<Object> getList(){
        return new ArrayList<Object>();
    }



    /**
     * 获取json用的HashMap
     *
     * @return HashMap
     */
    public static HashMap<String, Object> getMap() {
        return new HashMap<>();
    }

    public static <T> String getJsonString(T bean) {
        String jsonString = "{}";
        try {
            jsonString = objectMapper.writeValueAsString(bean);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String getJsonString(List<Object> objectList){
        String jsonString = "{}";
        try {
            jsonString = objectMapper.writeValueAsString(objectList);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    public static String getJsonString(HashMap<String, Object> hashMap) {
        String jsonString = "{}";
        try {
            jsonString =  objectMapper.writeValueAsString(hashMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    public static HashMap<String, Object> getMap(String jsonString) {
        HashMap<String, Object> map = null;
        try {
            map = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            log.error("jsonString to hashMap failed, error = {}", e.getMessage());
        }
        return map;
    }


    public static <T> HashMap<String, Object> getMap(T bean) {
        String jsonString = getJsonString(bean);
        HashMap<String, Object> hashMap = new HashMap<>();
        try {
            hashMap = objectMapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static <T> T getBean(String jsonString, Class<T> clazz){
        HashMap<String, Object> jsonMap = getMap(jsonString);
        return getBean(jsonMap, clazz);
    }

    public static <T> T getBean(Map<String, ?> map, Class<T> clazz) {
        String jsonString = getJsonString(map);
        log.error("test = {}", jsonString);
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

//    public static <T> ArrayList<T> getList(Object listObject, Class<T> clazz){
//        {
//            ArrayList<T> result = new ArrayList<T>();
//            if(listObject instanceof List<?>)
//            {
//                for (Object o : (List<?>) listObject)
//                {
//                    result.add(clazz.cast(o));
//                }
//                return result;
//            }
//            return null;
//        }
//    }

    public static <T> ArrayList<T> getList(Object listObject, Class<T> clazz){
        if (!(listObject instanceof List)){
            throw new ClassCastException("can't cast " + listObject.getClass().getTypeName() + " as " + List.class.getTypeName());
        }

        ArrayList<T> result = new ArrayList<T>();

        for (Object o : (List<?>) listObject)
        {
            result.add(clazz.cast(o));
        }
        return result;
    }

    public static <T> ArrayList<HashMap<String, Object>> getList(List<T> objList) {
        ArrayList<HashMap<String, Object>> list = new ArrayList<>();
        if (objList != null && objList.size() > 0) {
            HashMap<String, Object> map = null;
            T bean = null;
            for (T t : objList) {
                bean = t;
                map = getMap(bean);
                list.add(map);
            }
        }
        return list;
    }

    public static <T> ArrayList<T> getList(List<Map<String, ?>> maps, Class<T> clazz) throws InstantiationException, IllegalAccessException {
        ArrayList<T> list = new ArrayList<>();
        if (maps != null && maps.size() > 0) {
            Map<String, ?> map = null;
            for (Map<String, ?> stringMap : maps) {
                map = stringMap;
                T bean = getBean(map, clazz);
                list.add(bean);
            }
        }
        return list;
    }
}

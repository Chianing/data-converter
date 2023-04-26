package com.chianing.plugin.dataconverter.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

/**
 * json序列化工具类
 *
 * @author chianing
 * @description json序列化工具类
 * @date 2023/04/24 16:04
 */
public class JsonUtil {

    /**
     * 对象转换为json字符串
     *
     * @param obj 对象
     * @return json字符串
     */
    public static String convertObj2Json(Object obj) {
        return convertObj2Json(obj, false);
    }

    /**
     * 对象转换为json字符串
     *
     * @param obj    对象
     * @param pretty 是否美化
     * @return json字符串
     */
    public static String convertObj2Json(Object obj, boolean pretty) {
        if (CheckEmptyUtil.isEmpty(obj)) {
            return null;
        }

        if (obj instanceof JSONObject) {
            return pretty ? JSONObject.toJSONString(obj, JSONWriter.Feature.PrettyFormat) : JSONObject.toJSONString(obj);
        } else if (obj instanceof JSONArray) {
            return pretty ? JSONArray.toJSONString(obj, JSONWriter.Feature.PrettyFormat) : JSONArray.toJSONString(obj);
        }

        return obj.toString();

    }

    /**
     * json字符串转换为对象
     *
     * @param json  json字符串
     * @param clazz 目标类型
     * @param <T>   目标类型
     * @return 对象
     */
    public static <T> T convertJson2Obj(String json, Class<T> clazz) {
        if (CheckEmptyUtil.isEmpty(json) || CheckEmptyUtil.isEmpty(clazz)) {
            return null;
        }

        return JSONObject.parseObject(json, clazz);
    }

    /**
     * json字符串格式化
     *
     * @param json json字符串
     * @return 格式化后结果
     */
    public static String prettifyJson(String json) {
        if (CheckEmptyUtil.isEmpty(json)) {
            return null;
        }

        Object parsedJson = JSON.parse(json);

        return convertObj2Json(parsedJson, true);
    }

}

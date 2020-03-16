package com.edu.cgbd.pojo;

import com.edu.cgbd.data.CgbdResultStatus;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.util.List;

/**
 * 响应结构
 */
@Data
public class CgbdResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应描述
    private String desc;
    // 响应代码
    private int code;

    // 响应数据
    private Object data;

    public CgbdResult() {

    }

    public CgbdResult(CgbdResultStatus status) {
        this.desc = status.toString();
        this.code = status.getCode();
        this.data = null;
    }

    public CgbdResult(CgbdResultStatus status, Object data) {
        this.desc = status.toString();
        this.code = status.getCode();
        this.data = data;
    }

    public static CgbdResult ok(Object data) {
        return new CgbdResult(data);
    }

    public static CgbdResult ok() {
        return new CgbdResult(CgbdResultStatus.Ok);
    }

    public CgbdResult(Object data) {
        this.desc = CgbdResultStatus.Ok.toString();
        this.code = CgbdResultStatus.Ok.getCode();
        this.data = data;
    }

    public static CgbdResult build(CgbdResultStatus status) {
        return new CgbdResult(status);
    }

    public static CgbdResult build(CgbdResultStatus status, Object data) {
        return new CgbdResult(status, data);
    }

    /**
     * 将json结果集转化为CgbdResult对象
     *
     * @param jsonData json数据
     * @param clazz    CgbdResult中的object类型
     * @return
     */
    public static CgbdResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, CgbdResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (clazz != null) {
                if (data.isObject()) {
                    obj = MAPPER.readValue(data.traverse(), clazz);
                } else if (data.isTextual()) {
                    obj = MAPPER.readValue(data.asText(), clazz);
                }
            }

            return build(CgbdResultStatus.valueOf(jsonNode.get("desc").asText()), obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static CgbdResult format(String json) {
        try {
            return MAPPER.readValue(json, CgbdResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz    集合中的类型
     * @return
     */
    public static CgbdResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(CgbdResultStatus.valueOf(jsonNode.get("desc").asText()), obj);
        } catch (Exception e) {
            return null;
        }
    }
}

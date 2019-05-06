package com.example.result;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

/**
 *	 自定义响应数据结构
 *		200：表示成功
 * 		500：表示错误，错误信息在msg字段中
 */
@Data
@Component
public class ResponseResult {
	
	
	private Integer code;
	
	private String msg;
	
	private Object data;
	
	 // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    
    public ResponseResult(){};
	
	public ResponseResult(Integer code,String msg,Object data){
		this.code = code;
		this.msg = msg;
		this.data = data;
	};
	
	
	/**
	 *	 自定义异常
	 * @param code
	 * @param msg
	 * @return
	 */
	public static ResponseResult resultError(Integer code, String msg) {
		return result(code,msg,null);
	}
	
	
	/**
	 * 	自定义信息异常
	 * @param msg
	 * @return
	 */
	public static ResponseResult resultError(String msg) {
		return result(500,msg,null);
	}
	
	
	
	/**
	 * 	成功
	 * @return
	 */
	public static ResponseResult resultSuccess() {
		return result(200,"succes",null);
	}
	
	
	/**
	 * 	自定义信息成功
	 * @param msg
	 * @return
	 */
	public static ResponseResult resultSuccess(String msg) {
		return result(200,msg,null);
	}
	
	
	/**
	 * 	成功并返回对象
	 * @param data
	 * @return
	 */
	public static ResponseResult resultSuccess(Object data) {
		return result(200,"succes",data);
	}
	
	
	/**
	 * 	通用封裝
	 * @param code
	 * @param msg
	 * @param data
	 * @return
	 */
	public static ResponseResult result(Integer code, String msg, Object data) {
		return new ResponseResult(code,msg,data);
	}
	
	
	
	 /**
     * @Description: json转化对象
     * @param jsonData
     * @param clazz
     * @return
     */
    public static ResponseResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResponseResult.class);
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
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }

    
    /**
     * @Description: 没有object对象的转化
     * @param json
     * @return
     */
    public static ResponseResult format(String json) {
        try {
            return MAPPER.readValue(json, ResponseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Description: Object是集合转化需要转换的对象是一个list
     * @param jsonData
     * @param clazz
     * @return
     */
    public static ResponseResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("code").intValue(), jsonNode.get("msg").asText(), obj);
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public static ResponseResult build(Integer code,String msg,Object data){
		return new ResponseResult(code,msg,data);
	};
	
	
}

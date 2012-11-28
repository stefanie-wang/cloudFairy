/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: Jsonparse.java
 * @Package com.ucap.cloud.builder.util
*/
package com.ucap.cloud.builder.util;

import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.webservice.RequestParames;

/**
 * @author yxk
 *<p>将任意一个JSON生成为JSON字符串，将JSON信息转为RequestParames对象</p>            
 */
public class Jsonparse {
	
	static private Logger logger = Logger.getLogger(Jsonparse.class);
	
	/**
	 * 
	 */
	public Jsonparse() {
		// TODO Auto-generated constructor stub
		logger.info(Jsonparse.class+"loader..");
	}

	
	/**
	 * <P>
	 * 将任意一个JSON生成为JSON字符串
	 * </P>
	 * 
	 * @param obj
	 * @return
	 */
	public String getJSON(Object obj) {
		return JSONObject.fromObject(obj).toString();
	}
	/**
	 * <P>将josn对象生成java对象</P>
	 * @param clazz
	 * @param jsonstr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Object getJSON_OBJ(Class  clazz,String jsonstr)
	{
		Object obj = JSONObject.toBean(JSONObject
				.fromObject(jsonstr), clazz);
		return obj;
	}

	/**
	 * <P>修改json转化的指定类</P>
	 * @param json
	 * @param clazz
	 * @param classMap
	 * @return
	 */
	@SuppressWarnings("static-access")
	public Object json_object(String json,Class<?> clazz,Map<String,Class<?>> classMap)
	{
		JSONObject jobj = JSONObject.fromObject(json);
		Object obj  = jobj.toBean(jobj, clazz, classMap);
		return obj;
	}
	/**
	 * <P>
	 * 将JSON信息转为RequestParames对象
	 * </P>
	 * 
	 * @param jsonstr
	 * @return
	 */
	public RequestParames getRequestObject(String jsonstr) {
		RequestParames rq = (RequestParames) JSONObject.toBean(JSONObject
				.fromObject(jsonstr), RequestParames.class);
		return rq;
	}

}

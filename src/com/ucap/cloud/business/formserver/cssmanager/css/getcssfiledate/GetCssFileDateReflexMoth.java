/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateReflexMoth.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

/**
 * @ClassName GetCssFileDateReflexMoth
 * @Description TODO <P>解析idf中所有的reflex控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateReflexMoth {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public GetCssFileDateReflexMoth() {

	}

	/**
	 * 
	 * @param dataType
	 *            要解析的节点名称
	 * @param methodname
	 *            方法名 与控件名相同（input button）
	 * @param obj
	 *            解析验证信息的类对象
	 * @param ee
	 *            xml节点
	 * @return 控件集合
	 * @throws ClassNotFoundException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	@SuppressWarnings("unchecked")
	public Map<String, List<Map<String, String>>> getMethod(String dataType,
			String methodname, Object obj, Element ee)
			throws ClassNotFoundException, SecurityException,
			NoSuchMethodException, IllegalArgumentException,
			IllegalAccessException, InvocationTargetException {
		Class[] paramTypes = { Class.forName("java.lang.String"),
				Class.forName("org.dom4j.Element") };
		Method method = obj.getClass()
				.getMethod("get" + methodname, paramTypes); // 方法名称
		Object[] paramValues = { dataType, ee };
		Map<String, List<Map<String, String>>> map = (Map<String, List<Map<String, String>>>) method
				.invoke(obj, paramValues);

		return map;
	}
}

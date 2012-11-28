/**
 * <br>
 * java - javaScript 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: JsEngineTool .java
 * @Package com.ucap.cloud.builder.jsengine
*/
package com.ucap.cloud.builder.jsengine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author yxk
 * <P>处理后台计算</P>
 */
public class JsEngineTool {

	/**
	 * 
	 */
	public JsEngineTool() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * <P>进行后台的js运算</P>
	 * @param js
	 * @return
	 * @throws ScriptException 
	 */
	public String getJsResult(String js) throws ScriptException
	{
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		String result;
//		try {
			//执行js中的内容
			result =  engine.eval(js)+"";
			return result;
//		} catch (ScriptException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
	}

}

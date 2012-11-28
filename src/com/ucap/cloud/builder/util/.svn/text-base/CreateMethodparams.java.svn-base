/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CreateMethodparams.java
 * @Package com.ucap.cloud.builder.util
*/
package com.ucap.cloud.builder.util;


import com.ucap.cloud.builder.model.webservice.MethodParams;
import com.ucap.cloud.builder.model.webservice.RequestParames;



/**
 * @author yxk
 *<p>通过字符串获取参数对象，通过字符串获取RequestParames 对象</p>              
 */
public class CreateMethodparams {

	/**
	 * 
	 */
	public CreateMethodparams() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 通过字符串获取RequestParames 对象
	 * @param request
	 * @return
	 */
	static public RequestParames createRequestParames(String request)
	{
		Jsonparse jp = new Jsonparse();
		RequestParames  requestparame = jp.getRequestObject(request);
		return requestparame;
	}
	
	/**
	 * 通过字符串获取参数对象
	 * @param param
	 * @return
	 */
	static public MethodParams createMethodParams(String param)
	{
		MethodParams  mp = new MethodParams();
		return mp;
	}
}

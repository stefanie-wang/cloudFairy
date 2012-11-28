/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: MainServices.java
 * @Package com.ucap.cloud.builder.webservice.service
*/
package com.ucap.cloud.builder.webservice.service;

/**
 * 
 * @author yxk
 * @discrptioin <P>定义整个系统的唯一的对外的webservice接口 </P>
 */
public interface MainServices {

	/**
	 * @discription <P>系统唯一向外界发布的service接口</P>
	 * @param str
	 * @des 参数格式 传递的参数为json形式的 。其中有一项为用户名具体格式如下
	 * {userid:userid,objectid:objectid,methodname:methodnam,params:json}
	 * @return string 也是一个json字符串形式
	 * 具体结构为处理结果的一个json串
	 */
	String service(String str);
}
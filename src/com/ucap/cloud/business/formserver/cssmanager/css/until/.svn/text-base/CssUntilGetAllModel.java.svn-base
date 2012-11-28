/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssUntilGetAllModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
*/
package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.Map;

import org.dom4j.Element;

/**
 * @ClassName CssUntilGetAllModel
 * @Description TODO  所有解析的模型
 * @author pzg
 * @date 2012-8-10
 */
public  interface CssUntilGetAllModel {

	

	   /**
	    * 获取解析的值
	    * @param e 处理节点
	    * @return 所有模型
	    * @throws Exception
	    */
		  Map<String, Object> getModel(Element e) throws Exception;
	   /**
	    *  处理重复表的控件
	    * @param e 处理节点
	    * @param i 重复表的行数
	    * @param tableName  重复表名称
	    * @return css样式
	    * @throws Exception 异常
	    */
		  String getStringCss(Element e,int i,String tableName) throws Exception;
		/**
		 * 处理正常控件
		 * @param e 处理节点
		 * @return css样式
		 * @throws Exception异常
		 */
		  String getStringCss(Element e ) throws Exception;
}

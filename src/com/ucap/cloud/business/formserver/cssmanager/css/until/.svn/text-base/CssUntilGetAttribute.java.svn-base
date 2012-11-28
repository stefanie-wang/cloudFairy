package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.Map;

import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.InputModel;
import com.ucap.cloud.business.formserver.validate.ValidataLoader;
/**
 /**
 * @Description TODO 解析idf文件中控件的属性 
 * @author pzg
 * @date 2012-8-31
 */
public interface CssUntilGetAttribute {

	/**
	 * 处理控件的属性
	 * @param controlsson 节点
	 * @return  input控件模型
	 */
	public InputModel getinput(Element controlsson,ValidataLoader vl);
	
	
	/**
     * 
     * @param controlsson  要处理的节点 此处是js的事件
     * @return 返回类型和内容
     */
	 public Map<String,String> getEventEl(Element controlsson);
	 
	 
	 /**
		 * 
		 * @param e  需要处理的控件节点 此处是 formate
		 * @return   返回类型和内容
		 */
	  public Map<String,String> getFormate(Element formate);
}

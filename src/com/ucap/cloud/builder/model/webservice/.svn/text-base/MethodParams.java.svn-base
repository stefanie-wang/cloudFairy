/**
 * <br>
 * webservice Model
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: MethodParams.java
 * @Package com.ucap.cloud.builder.model.webservice
*/
package com.ucap.cloud.builder.model.webservice;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @author yxk
 * <P>封装方法请求参数模型</P>
 */
@SuppressWarnings("serial")
public class MethodParams implements ModelRoot {

	
	private static Logger log = Logger.getLogger(MethodParams.class);
	
	public MethodParams()
	{
		log.info(MethodParams.class+"loader..");
	}
	
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 请求参数
	 * 使用List是为了确定参数次序和内容
	 */
	private List<Object> param = new ArrayList<Object>();

	public List<Object> getParam() {
		return param;
	}

	public void setParam(List<Object> param) {
		this.param = param;
	}

	/**
	 * 获取要进行请求的service的方法类型
	 * 
	 * @return
	 */
	//返回请求参数类的数组
	@SuppressWarnings("unchecked")
	public Class[] getClazz() {
		if (param.size() == 0) {
			return null;
		} else {
			Class[] clazz = new Class[this.param.size()];
			for (int i = 0; i < this.param.size(); i++) {
				clazz[i] = this.param.get(i).getClass();
			}
			return clazz;
		}
	}

	/**
	 * 获取要进行调用的service的方法的参数
	 * 
	 * @return
	 */
	//返回请求参数对象的数组
	public Object[] getObject() {
		if (this.param.size() == 0) {
			return null;
		} else {
			Object[] obj = new Object[this.param.size()];
			for (int i = 0; i < this.param.size(); i++) {
				obj[i] = this.param.get(i);
			}
			return obj;
		}
	}

}

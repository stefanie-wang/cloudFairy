/**
 * <br>
 * webservice 
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: MainServicesImpl.java
 * @Package com.ucap.cloud.builder.webservice.serviceImpl
*/
package com.ucap.cloud.builder.webservice.serviceImpl;



import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.annotation.ClassAuthority;
import com.ucap.cloud.builder.annotation.MethodAuthority;
import com.ucap.cloud.builder.model.webservice.MethodParams;
import com.ucap.cloud.builder.model.webservice.MethodResponse;
import com.ucap.cloud.builder.model.webservice.RequestParames;
import com.ucap.cloud.builder.util.CreateMethodparams;
import com.ucap.cloud.builder.util.Jsonparse;
import com.ucap.cloud.builder.webservice.service.MainServices;


/**
 * @author yxk
 *<>实现系统对外的webservice接口</p>
 */
public class MainServicesImpl implements MainServices {

	private static Logger log = Logger.getLogger(MainServicesImpl.class);
	/**
	 * 
	 */
	public MainServicesImpl() {
		// TODO Auto-generated constructor stub
		log.info(MainServicesImpl.class+"loader...");
	}
	/*
	 * (non-Javadoc)
	 * @see t.MainServices#service(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	
	public String service(String str) {
		// TODO Auto-generated method stub
//		将请求的json参数转换为RequestParames对象
		RequestParames params = CreateMethodparams.createRequestParames(str);
		//通过请求方法ID判断Spring环境中是否有该方法,并获得
		Object obj = SPRINGCONTEXT.getBean(params.getObjectid());
		@SuppressWarnings("unused")
		ClassAuthority ca = obj.getClass().getAnnotation(ClassAuthority.class);
//		获取相应的请求方法名
		String methodname = params.getMethodname();
//		获取请求的参数并且将请求的参数的json转为MethodParam对象
		MethodParams mp = params.getMethodparams();
//		构建应答对象
		MethodResponse response = new MethodResponse();
		String result = "";
		try
		{
			Class clazz = obj.getClass();
			//获得请求要调用的方法名
			Method mname = clazz.getDeclaredMethod(methodname, mp.getClazz());
			@SuppressWarnings("unused")
			MethodAuthority ma = mname.getAnnotation(MethodAuthority.class);
			//通过反射机制执行请求调用的方法
			Object robj = mname.invoke(obj, mp.getObject());
			//将结果 放入应答对象中
			response.setResponseObj(robj);
			//构建json对象
			Jsonparse jp = new Jsonparse();
			//将返回结果转换成字符串
			result = jp.getJSON(robj);
			log.info(result);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		//将返回结果转换为字符串
		return response.toString();
	}
	

}

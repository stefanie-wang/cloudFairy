/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataoutputStream.java
 * @Package com.ucap.cloud.business.formserver.data.outin
 */

package com.ucap.cloud.business.formserver.data.outin;


/**
 * @ClassName DataoutputStream
 * @Description TODO  序列化业务类
 * @author zhanglj
 * @date 2012-7-27
 */
public class DataoutputStream {
	
	//引用序列化接口
	private IDataInputOutput idio ;


	/** 
	* @Title: init 
	* @Description: TODO 项目启动时加载缓存文件
	* @param      
	* @return void     
	* @throws 
	*/
	public void init() {
		
		
		this.idio.readerObject();
	}

	public void destroy() {

		this.idio.writeObject();
	}

	public IDataInputOutput getIdio() {
		return idio;
	}

	public void setIdio(IDataInputOutput idio) {
		this.idio = idio;
	}
	
	

}

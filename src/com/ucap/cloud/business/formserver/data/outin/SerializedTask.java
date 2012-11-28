/**
 * @Title: SerializedTask.java 
 * @Package com.ucap.cloud.business.formserver.data.outin
 * @Description: TODO 
 * @author zhanglj
 * @date 2012-7-27 上午11:13:04 
 * @version V1.0 */ 

package com.ucap.cloud.business.formserver.data.outin;

import java.util.TimerTask;

/**
 * @ClassName SerializedTask 定时器
 * @Description TODO 定时向序列化文件中写入缓存中的数据
 * @author zhanglj
 * @date 2012-7-27
 */
public class SerializedTask extends TimerTask {
	//引用DataoutputStream
	private DataoutputStream dos;

	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p>  
	 */
	public SerializedTask() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.util.TimerTask#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.dos.destroy();
		
	}

	public DataoutputStream getDos() {
		return dos;
	}

	public void setDos(DataoutputStream dos) {
		this.dos = dos;
	}

}

/**  
* @Project: cloudFairy
* @Title: NiMingIdfModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-24 上午10:14:04
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.List;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfMessage;

/**
 * @ClassName NiMingIdfModel
 * @Description <p>保存匿名表单的idf模型</p>
 * @author sunjq
 * @date 2012-9-24
 */

@SuppressWarnings("serial")
public class NiMingIdfModel implements ModelRoot{

	/** 
	 * <p>Title:NiMingIdfModel </p>
	 * <p>Description:保存发布匿名表单的idf文件模型 </p> 
	 */

	public NiMingIdfModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields dataList : 保存匿名表单的数据，一份idf文件对应多份数据
	*/
	private List<DataModel> dataList = new ArrayList<DataModel>();
	
	/** 
	* @Fields idfmesg : 保存匿名表单的原始数据
	*/
	private IdfMessage idfmesg ;

	/* (非 Javadoc) 
	* <p>Title: compareTo</p>
	* <p>Description: </p>
	* @param o
	* @return 
	* @see java.lang.Comparable#compareTo(java.lang.Object) 
	*/
	
	public List<DataModel> getDataList() {
		return dataList;
	}

	public void setDataList(List<DataModel> dataList) {
		this.dataList = dataList;
	}
	public void setDataList(DataModel datamodel) {
		this.dataList.add(datamodel);
	}

	public IdfMessage getIdfmesg() {
		return idfmesg;
	}

	public void setIdfmesg(IdfMessage idfmesg) {
		this.idfmesg = idfmesg;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}

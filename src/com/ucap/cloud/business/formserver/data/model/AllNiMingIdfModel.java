/**  
* @Project: cloudFairy
* @Title: AllNiMingIdfModel.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-26 上午11:06:04
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.HashMap;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName AllNiMingIdfModel
 * @Description TODO
 * @author sunjq
 * @date 2012-9-26
 */

@SuppressWarnings("serial")
public class AllNiMingIdfModel implements ModelRoot{

	/** 
	 * <p>Title: AllNiMingIdfModel</p>
	 * <p>Description:存放所有匿名表单的模型 </p> 
	 */

	public AllNiMingIdfModel() {
		// TODO Auto-generated constructor stub
	}

	/** 
	* @Fields allIdf : 记录所有匿名发布的idf文件,key为表单名，NiMingIdfModel为记录该表单的数据信息及填报的数据信息
	*/
	private Map<String,NiMingIdfModel> allIdf = new HashMap<String, NiMingIdfModel>();
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, NiMingIdfModel> getAllIdf() {
		return allIdf;
	}
	public NiMingIdfModel getAllIdf(String key) {
		return allIdf.get(key);
	}

	public void setAllIdf(Map<String, NiMingIdfModel> allIdf) {
		this.allIdf = allIdf;
	}
	public void setAllIdf(String key, NiMingIdfModel allIdf) {
		this.allIdf.put(key, allIdf);
	}











	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

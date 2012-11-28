/**  
* @Project: cloudFairy
* @Title: DMJson.java
* @Package com.ucap.cloud.business.formserver.data.model
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-25 上午11:52:08
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.business.formserver.compute.model.ComputeModel;

/**
 * @ClassName DMJson
 * @Description TODO
 * @author sunjq
 * @date 2012-10-25
 */

public class DMJson implements ModelRoot{

	/** 
	 * <p>Title: </p>
	 * <p>Description: </p> 
	 */

	public DMJson() {
		// TODO Auto-generated constructor stub
	}

	/* (非 Javadoc) 
	* <p>Title: compareTo</p>
	* <p>Description: </p>
	* @param o
	* @return 
	* @see java.lang.Comparable#compareTo(java.lang.Object) 
	*/
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/** 
	* @Fields repeatBlock : 保存重复块属性
	*/
	private Map<String,RepeatBlockModel> repeatBlock = new HashMap<String, RepeatBlockModel>();
	
	/** 
	* @Fields barcodes : 
	* 保存条形码控件的属性
	*/
	private List<BarCodeModel> barcodes = new ArrayList<BarCodeModel>();
	
	private Map<String,RepeateTable> repeattable = new HashMap<String, RepeateTable>();
	/** 
	* @Fields inputs : TODO
	* 保存表单的可输入项信息
	* 以控件ID做KEY
	*/
	private Map<String, InputModel> inputs = new HashMap<String, InputModel>();
	
	/** 
	* @Fields compMap : TODO
	* 保存表单的计算公式
	*/
	private Map<String, ComputeModel> compMap = new HashMap<String, ComputeModel>();

	public Map<String, RepeatBlockModel> getRepeatBlock() {
		return repeatBlock;
	}

	public void setRepeatBlock(Map<String, RepeatBlockModel> repeatBlock) {
		this.repeatBlock = repeatBlock;
	}

	public List<BarCodeModel> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<BarCodeModel> barcodes) {
		this.barcodes = barcodes;
	}

	public Map<String, RepeateTable> getRepeattable() {
		return repeattable;
	}

	public void setRepeattable(Map<String, RepeateTable> repeattable) {
		this.repeattable = repeattable;
	}

	public Map<String, InputModel> getInputs() {
		return inputs;
	}

	public void setInputs(Map<String, InputModel> inputs) {
		this.inputs = inputs;
	}

	public Map<String, ComputeModel> getCompMap() {
		return compMap;
	}

	public void setCompMap(Map<String, ComputeModel> compMap) {
		this.compMap = compMap;
	}
	
	

}

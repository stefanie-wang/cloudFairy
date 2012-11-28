/**
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.business.formserver.compute.model.ComputeModel;
import com.ucap.cloud.business.formserver.validate.ValidataModel;

/**
 * @ClassName DataModel
 * @Description TODO
 *              <P>
 *              用来存储idf文件原始的数据信息
 *              </P>
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class DataModel implements ModelRoot {

	/**
	 * 
	 */
	public DataModel() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Fields globalCheck : 用来记录全局校验的不正确的id
	*/
	private Map<String,List<String>> globalCheck = new HashMap<String, List<String>>();
	
	private Map<String,String> gcErrMsg = new HashMap<String, String>();
	

	/** 
	* @Fields checkBoxGroup : 保存表单中的多选控件，以组来保存
	*/
	private Map<String,List<String>> checkBoxGroup = new HashMap<String, List<String>>();
	
	/** 
	* @Fields tabIndex : 保存表单的tabIndex属性集合
	*/
	private Map<String,String> tabIndex = new HashMap<String, String>();
	
	public Map<String, String> getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Map<String, String> tabIndex) {
		this.tabIndex = tabIndex;
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
	/** 
	* @Fields cssname : TODO
	* 保存表单链接的css文件名称
	*/
	private Map<String ,List<String>> cssname = new HashMap<String, List<String>>();
	/** 
	* @Fields repeattable : TODO
	* 保存表单中重复表的信息，以重复表控件ID做KEY，RepeateTable做值
	*/
	private Map<String,RepeateTable> repeattable = new HashMap<String, RepeateTable>();

	/** 
	* @Fields FormJavaScript : TODO
	* 保存表单的全局函数
	*/
	private String FormJavaScript = "";

	/** 
	* @Fields events : TODO
	* 保存控件的自定义JS事件
	*/
	private Map<String, EventsModel> events = new HashMap<String, EventsModel>();

	/** 
	* @Fields inputs : TODO
	* 保存表单的可输入项信息
	* 以控件ID做KEY
	*/
	private Map<String, InputModel> inputs = new HashMap<String, InputModel>();

	/** 
	* @Fields xpathinput : TODO
	* 保存表单的可输入项信息，以控件的namepath做KEY
	*/
	private Map<String, InputModel> xpathinput = new HashMap<String, InputModel>();

	/** 
	* @Fields compMap : TODO
	* 保存表单的计算公式
	*/
	private Map<String, ComputeModel> compMap = new HashMap<String, ComputeModel>();

	/** 
	* @Fields validata : TODO
	* 保存表单的校验公式，验证公式
	*/
	private Map<String, List<ValidataModel>> validata = new HashMap<String, List<ValidataModel>>();

	/*private List<String> checkboxs = new ArrayList<String>();

	private List<String> readios = new ArrayList<String>();*/

	public Map<String, ComputeModel> getCompMap() {
		return compMap;
	}

	public void setComMap(String key, ComputeModel value) {
		this.compMap.put(key, value);
	}

	public void setCompMap(Map<String, ComputeModel> compMap) {
		this.compMap = compMap;
	}

	public void setInputs(InputModel im) {
		this.inputs.put(im.getName(), im);
	}

	// 将输入项所影响的公式绑定到DM中
	public void bindCalculate() {
		// 获取所有的输入项到的key值
		Set<String> inputset = this.inputs.keySet();

		for (String key : inputset) { // 循环获取每个输入项
			InputModel input = this.inputs.get(key);
			// 获取输入项的名字
			String ref = input.getName();
			// 获取所有计算公式
			Set<String> comset = this.compMap.keySet();

			for (String comkey : comset) { // 循环遍历每个公式，判断该公式所涉及的公式是否包含当前输入项
				boolean b = this.compMap.get(comkey).getComputeelement()
						.contains(ref);
				if (b) { // 如果包含，说明当前输入项影响到该公式，将该公式ID绑定到当前输入项calculate中
					input.setCalculate(comkey);
					continue;
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/*static public void main(String arg[]) throws CloneNotSupportedException
	{
		DataModel dm = new DataModel();
		dm.setFormJavaScript("sdfsdfsdfds");
		DataModel x = (DataModel) dm.clone();
		System.out.println(x.getFormJavaScript());
		
	}*/

	/* (非 Javadoc) 
	* <p>Title: clone</p>
	* <p>Description: </p>
	* @return
	* @throws CloneNotSupportedException 
	* @see java.lang.Object#clone() 
	*/
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		DataModel dm =null;
		
		ByteArrayOutputStream ba = new ByteArrayOutputStream(1024);
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(ba);
			output.writeObject(this);
			byte[] k = ba.toByteArray();
			ba.close();
			output.close();
			ByteArrayInputStream bain = new ByteArrayInputStream(k);
			ObjectInputStream input = new ObjectInputStream(bain);
			dm = (DataModel) input.readObject();
			input.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Map<String, InputModel> map = new HashMap<String, InputModel>();
//		for (String key : this.inputs.keySet()) {
//			map.put(key, (InputModel) this.inputs.get(key).clone());
//		}
//		dm.setInputs(map);
//		Map<String, ComputeModel> comp = new HashMap<String, ComputeModel>();
//		for (String key : this.compMap.keySet()) {
//			comp.put(key, (ComputeModel) this.compMap.get(key).clone());
//		}
//		dm.setCompMap(comp);
//		Map<String, List<ValidataModel>> val = new HashMap<String, List<ValidataModel>>();
//		for (String key : this.validata.keySet()) {
//			List<ValidataModel> a = new ArrayList<ValidataModel>();
//			for (ValidataModel v : this.validata.get(key)) {
//				a.add((ValidataModel) v.clone());
//			}
//			val.put(key, a);
//		}
//		dm.setValidata(val);
		return dm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inputs == null) ? 0 : inputs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataModel other = (DataModel) obj;
		if (inputs == null) {
			if (other.inputs != null)
				return false;
		} else if (!inputs.equals(other.inputs))
			return false;
		return true;
	}

	public Map<String, InputModel> getInputs() {
		return inputs;
	}

	public void setInputs(Map<String, InputModel> inputs) {
		this.inputs = inputs;
	}

	@Override
	public String toString() {
		Set<String> keyset = this.inputs.keySet();
		StringBuilder sb = new StringBuilder();
		for (String s : keyset) {
			sb.append(s);
			sb.append(this.inputs.get(s));
			sb.append("|");
		}
		sb.append("validate:");
		Set<String> vset = this.validata.keySet();
		for (String k : vset) {
			sb.append(this.validata.get(k));
		}
		return sb.toString();
	}

	public List<ValidataModel> getValidata(String key) {
		return this.validata.get(key);
	}

	public Map<String, List<ValidataModel>> getValidata() {
		return this.validata;
	}

	public void setValidata(String key, List<ValidataModel> value) {
		this.validata.put(key, value);
	}

	public void setValidate(String key, ValidataModel value) {
		List<ValidataModel> list = this.validata.get(key);
		if (null == list) {
			list = new ArrayList<ValidataModel>();
		}
		list.add(value);
		this.validata.put(key, list);
	}

	public void setValidata(Map<String, List<ValidataModel>> validate) {
		this.validata = validate;
	}

	/*public List<String> getCheckboxs() {
		return checkboxs;
	}

	public void setCheckboxs(List<String> checkboxs) {
		this.checkboxs = checkboxs;
	}

	public void setCheckboxs(String key) {
		this.checkboxs.add(key);
	}

	public List<String> getReadios() {
		return readios;
	}

	public void setReadios(List<String> readios) {
		this.readios = readios;
	}

	public void setReadios(String readios) {
		this.readios.add(readios);
	}*/

	public Map<String, List<String>> getCheckBoxGroup() {
		return checkBoxGroup;
	}

	public void setCheckBoxGroup(Map<String, List<String>> checkBoxGroup) {
		this.checkBoxGroup = checkBoxGroup;
	}
	
	public void setCheckBoxGroup(String key, List<String> checkBoxGroup) {
		this.checkBoxGroup.put(key, checkBoxGroup);
	}
	public Map<String, InputModel> getXpathinput() {
		return xpathinput;
	}

	/**
	 * 根据指定的xpth获取相应的input模型
	 * 
	 * @param xpath
	 * @return
	 */
	public InputModel getXpathinput(String xpath) {
		return this.xpathinput.get(xpath);
	}

	public void setXpathinput(String xpath, InputModel inpu) {
		this.xpathinput.put(xpath, inpu);
	}

	public void setXpathinput(Map<String, InputModel> xpathinput) {
		this.xpathinput = xpathinput;
	}

	public Map<String, EventsModel> getEvents() {
		return events;
	}

	public void setEvents(Map<String, EventsModel> events1) {
		this.events = events1;
	}

	public void setEvents(EventsModel e) {

		this.events.put(e.getId(), e);
	}

	public String getFormJavaScript() {
		return FormJavaScript;
	}

	public void setFormJavaScript(String formJavaScript) {
		FormJavaScript = formJavaScript;
	}


	public Map<String, RepeateTable> getRepeattable() {
		return repeattable;
	}
	public  RepeateTable getRepeattable(String key) {
		return repeattable.get(key);
	}

	@SuppressWarnings("unchecked")
	public void setRepeattable(Map repeattable) {
		this.repeattable = repeattable;
	}
	public void setRepeattable(String repname,RepeateTable rep) {
		this.repeattable.put(repname, rep);
	}

	public Map<String, List<String>> getCssname() {
		return cssname;
	}

	public void setCssname(String idfname, List<String> cssname) {
		this.cssname.put(idfname, cssname);
	}

	public List<BarCodeModel> getBarcodes() {
		return barcodes;
	}

	public void setBarcodes(List<BarCodeModel> barcodes) {
		this.barcodes = barcodes;
	}
	public void setBarcodes(BarCodeModel barcode) {
		this.barcodes.add(barcode);
	}

	public Map<String, RepeatBlockModel> getRepeatBlock() {
		return repeatBlock;
	}
	public RepeatBlockModel getRepeatBlock(String key) {
		return repeatBlock.get(key);
	}

	public void setRepeatBlock(Map<String, RepeatBlockModel> repeatBlock) {
		this.repeatBlock = repeatBlock;
	}
	public void setRepeatBlock(String name, RepeatBlockModel repeatBlock) {
		this.repeatBlock.put(name, repeatBlock);
	}

	public Map<String, List<String>> getGlobalCheck() {
		return globalCheck;
	}

	public void setGlobalCheck(Map<String, List<String>> globalCheck) {
		this.globalCheck = globalCheck;
	}

	public Map<String, String> getGcErrMsg() {
		return gcErrMsg;
	}

	public void setGcErrMsg(Map<String, String> gcErrMsg) {
		this.gcErrMsg = gcErrMsg;
	}

	

}

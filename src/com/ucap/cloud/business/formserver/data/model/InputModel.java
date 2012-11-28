/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: InputModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */

package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;

import com.ucap.cloud.builder.model.ModelRoot;
/**
 * @ClassName InputModel
 * @Description TODO
 *              <P>
 *              记录所有可以输入项
 *              </P>
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class InputModel implements ModelRoot {

	/**
	 * 保存可输入项的信息
	 */
	public InputModel() {
		// TODO Auto-generated constructor stub
	}

	public InputModel(Element controlsson){
		if(controlsson!=null){
			//tabindex属性
			if(null!=controlsson.attributeValue("tabIndex")){
				String tabIndex = controlsson.attributeValue("tabIndex");
				this.tabIndex = tabIndex;
			}
			//控件路径
			String namepath = controlsson.attributeValue("namepath");
			this.namepath = namepath;
			// 是否隐藏
			String hidden = controlsson.attributeValue("hidden"); 
			this.hidden = hidden;
			//是否必填
			String required = controlsson.attributeValue("required");
			this.required = required;
			//是否无效
			String disable = controlsson.attributeValue("disable");
			this.disable = disable;
			// 名称
			String name = controlsson.attributeValue("name");
			this.name = name;
			// 控件值
			String value = controlsson.attributeValue("value");
			this.value = value;
			//是否只读
		    String readOnly=controlsson.attributeValue("readOnly");
		    this.readOnly = readOnly;
		    //是否默认选中
			String checked = controlsson.attributeValue("checked");
			this.checked = checked;
			//下拉框
			String selected = controlsson.attributeValue("selected");
			//描述信息
			String describe = controlsson.attributeValue("Describe");
			if(describe!=null&&describe.trim().length()>0){
				this.describe = describe;
			}
			this.selected = selected;
			String contype = controlsson.getName();
			if (contype.equals("button")) {// 如果控件为button
				//按钮显示名
				value = controlsson.attributeValue("text");
				this.value = value;
				//事件
				Element elem = controlsson.element("action");// 找到action节点
				String actionType = elem.attributeValue("actionType");// 获取action事件类型
				this.acT = actionType;// 将事件类型放到inputmodel中
				// 超连接类型
				if (actionType.equals("HyperLink")) {
					String HyperLink = elem.element("HyperLink").getText();
					this.link = HyperLink;
				}// Submit类型
				if (actionType.equals("Submit")) {
					String action = elem.element("submit").getText();
					this.link = action;
				}
			}
			if(contype.equals("radioBox")||contype.equals("checkBox")){
				this.groupName = controlsson.attributeValue("groupName");
			}
			String helpMessage = "";
			Element apperance = controlsson.element("appearance");
			// 获取帮助信息
			if (null != apperance && null != apperance.element("hints")) {
				helpMessage = controlsson.element("appearance")
				.element("hints").attributeValue("helpMessage");
				this.helpMessage = helpMessage;
			}
			String tips = "";
			// 获取提示信息
			if (null != apperance && null != apperance.element("hints")) {
				tips = controlsson.element("appearance").element("hints")
				.attributeValue("tips");
				this.tips = tips;
			}
		}
	}
	private String groupName ="";
    private String controlType = "";
	private String src ="";
	private String tabIndex = "";
	/**
	 * 描述信息
	 */
	private String describe = "";

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	private String movSrc="";
	/** 
	* @Fields acT : TODO
	* 控件的事件类型
	*/
	private String acT = "";
	/** 
	* @Fields link : TODO
	* 控件的超链接地址
	*/
	private String link = "";
	/**
	 * @return the movSrc
	 */
	public String getMovSrc() {
		return movSrc;
	}

	/**
	 * @param movSrc the movSrc to set
	 */
	public void setMovSrc(String movSrc) {
		this.movSrc = movSrc;
	}
	/** 
	* @Fields hidden : TODO
	* 控件的隐藏属性
	*/
	private String hidden = "";
	/** 
	* @Fields required : TODO
	* 控件的是否必输属性
	*/
	private String required = "";
	/** 
	* @Fields disable : TODO
	* 控件的是否无效属性
	*/
	private String disable = "";
	/** 
	* @Fields readOnly : TODO
	* 控件的只读属性
	*/
	private String readOnly = "";
	/** 
	* @Fields tips : TODO
	* 控件的提示信息
	*/
	private String tips = "";
	/** 
	* @Fields helpMessage : TODO
	* 控件的帮助信息
	*/
	private String helpMessage = "";
	/** 
	* @Fields contype : TODO
	* 控件的类型属性
	*//*
	private String contype = "";*/
	/** 
	* @Fields droplm : TODO
	* 下拉框，下拉列表的模型
	*/
	private DropListModel droplm;
    private EventsModel ev = new EventsModel();
	public EventsModel getEv() {
		return ev;
	}

	public void setEv(EventsModel ev) {
		this.ev = ev;
	}

	public DropListModel getDroplm() {
		return droplm;
	}

	public void setDroplm(DropListModel droplm) {
		this.droplm = droplm;
	}
	/** 
	* @Fields selected : TODO
	* 表示下拉框，下拉列表是否被选中
	*/
	private String selected;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}
	/** 
	* @Fields checked : TODO
	* 表示单选框，多选框是否被选中
	*/
	private String checked;

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	/**
	 * xpath
	 */
	/** 
	* @Fields namepath : TODO
	* 控件的唯一节点信息，对应初始化数据文件的节点
	*/
	private String namepath;
	
	/** 
	* @Fields name : TODO
	* 控件的ID，名称
	*/
	private String name;
	/** 
	* @Fields value : TODO
	* 控件的值
	*/
	private String value = "";
	
	/** 
	* @Fields attribute : TODO
	* 控件的属性信息
	*/
	private Map<String, String> attribute = new HashMap<String, String>();
	/** 
	* @Fields calculate : TODO
	* 当前组件涉及到的计算公式
	*/
	private List<String> calculate = new ArrayList<String>();

	public Object clone() {
		InputModel im = new InputModel();
		Map<String, String> att = new HashMap<String, String>();
		Set<String> attset = this.attribute.keySet();
		List<String> cal = new ArrayList<String>();
		for (String s : this.calculate) {
			cal.add(s);
		}
		for (String s : attset) {
			att.put(s, att.get(s));
		}
		im.setAttribute(att);
		im.setName(this.name);
		im.setNamepath(this.namepath);
		im.setCalculate(cal);
		return im;
	}

	public void setCalculate(String c) {
		this.calculate.add(c);
	}

	public List<String> getCalculate() {
		return this.calculate;
	}

	public String getNamepath() {
		return namepath;
	}

	public void setNamepath(String namepath) {
		this.namepath = namepath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Map<String, String> getAttribute() {
		return attribute;
	}

	public void setAttribute(String key, String value) {
		this.attribute.put(key, value);
	}

	public void setAttribute(Map<String, String> attribute) {
		this.attribute = attribute;
	}

	public void setCalculate(List<String> calculate) {
		this.calculate = calculate;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public String getHelpMessage() {
		return helpMessage;
	}

	public void setHelpMessage(String helpMessage) {
		this.helpMessage = helpMessage;
	}

	public String getReadOnly() {
		return readOnly;
	}

	public void setReadOnly(String readOnly) {
		this.readOnly = readOnly;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	/*public String getContype() {
		return contype;
	}

	public void setContype(String contype) {
		this.contype = contype;
	}*/

	public String getActionType() {
		return this.acT;
	}

	public void setActionType(String actionType) {
		this.acT = actionType;
	}

	/**
	 * @return the src
	 */
	public String getSrc() {
		return src;
	}

	/**
	 * @param src the src to set
	 */
	public void setSrc(String src) {
		this.src = src;
	}

	public String getControlType() {
		return controlType;
	}

	public void setControlType(String controlType) {
		this.controlType = controlType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}

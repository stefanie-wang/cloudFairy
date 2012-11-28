/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DropListModel.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName DropListModel
 * @Description TODO 专门存储droplist属性的模型
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("serial")
public class DropListModel implements ModelRoot {
	/**
	 * <p>
	 * Title:DropListModel
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public DropListModel() {
		// TODO Auto-generated constructor stub
	}
    public DropListModel(Element controlsson){
    	// 控件名称
		String dropname = controlsson.attributeValue("name");
		this.name = dropname;
    }
	/** 
	* @Fields name : TODO
	* 下拉框的名字
	*/
	private String name;
	/** 
	* @Fields options : TODO
	* 保存下拉框选项的信息
	*/
	private List<OptionModel> options = new ArrayList<OptionModel>();

	public List<OptionModel> getOptions() {
		return options;
	}

	/** 
	* @Title: getOptions_str 
	* @Description: TODO
	* 依据选项的信息生成
	* @return String     
	* @throws 
	*/
	public String getOptions_str() {
		StringBuilder sb = new StringBuilder();
		for (OptionModel op : this.options) {
			sb.append("<option  value='");
			sb.append(op.getValue());
			sb.append("' ");
			if (null != op.getSelected() && op.getSelected().equals("-1")) {
				sb.append("selected=\"selected\">");
			} else {
				sb.append(">");
			}
			sb.append(op.getText());
			sb.append("</option>");
		}
		return sb.toString();
	}

	public void setOptions(List<OptionModel> options) {
		this.options = options;
	}

	public void setOptions(OptionModel model) {
		this.options.add(model);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}

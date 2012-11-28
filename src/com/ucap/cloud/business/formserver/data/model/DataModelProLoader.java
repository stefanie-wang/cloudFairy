/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataModelProLoader.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @ClassName DataModelProLoader
 * @Description TODO 获取要进行匹配的控件属性
 * @author sunjq
 * @date 2012-8-10
 */
public class DataModelProLoader {

	static private Logger logger = Logger.getLogger(DataModelProLoader.class);

	/**
	 * 获取要进行匹配的控件属性
	 */
	public DataModelProLoader() {
		// TODO Auto-generated constructor stub

	}

	/** 
	* @Fields contextpath : TODO
	*  需要进行解析的控件的配置文件路径
	*/
	private String contextpath;

	/** 
	* @Fields prop : TODO
	* 保存控件的名称和每个控件需要的属性
	*/
	private Map<String, DataModelProp> prop = new HashMap<String, DataModelProp>();

	/** 
	* @Title: init 
	* @Description: TODO
	* <p>
	* 在类加载的时候根据控件类型预加载一个模型
	* </p>
	* @param      
	* @return void    
	* @throws 
	*/
	public void init() {
		logger.info("加载属性");
		SAXReader reader = new SAXReader();
		try {
			String filepath = this.getClass().getClassLoader().getResource("")
					+ this.contextpath;//获取配置文件的路径

			filepath = filepath.substring(filepath.indexOf("/"));
			Document d = reader.read(new File(filepath));//解析配置文件XML
			Element root = d.getRootElement();//获取根节点
			List<Element> models = root.elements();
			for (Element e : models) {//循环处理每个节点
				DataModelProp dp = new DataModelProp();
				String id = e.attributeValue("id");//读取配置文件中每个节点的ID属性
				List<Element> ps = e.elements();//读取每个节点下面的具体每个控件需要的属性
				for (Element x : ps) {
					dp.setProps(x.getText(), "");//循环读取每个节点，控件的具体需要的属性
				}
				dp.setId(id);//将控件的类型放入模型中
				prop.put(id, dp);//将控件的属性放入模型中
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getContextpath() {
		return contextpath;
	}

	public void setContextpath(String contextpath) {
		this.contextpath = contextpath;
	}

	public Map<String, DataModelProp> getProp() {
		return prop;
	}

	public void setProp(Map<String, DataModelProp> prop) {
		this.prop = prop;
	}

}

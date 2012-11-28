/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataEventLoader.java
 * @Package com.ucap.cloud.business.formserver.data.model
 */
package com.ucap.cloud.business.formserver.data.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @ClassName DataEventLoader
 * @Description TODO
 * <p>
 * 获取控件的事件，依据eventmodel.xml获取不同控件的自定义事件
 * </p>
 * @author sunjq
 * @date 2012-8-10
 */
public class DataEventLoader {

	/**
	 * 获取控件的自定触发事件
	 */
	public DataEventLoader() {
		// TODO Auto-generated constructor stub
	}

	/** 
	* @Fields contextpath : TODO
	* 配置文件的路径
	*/
	private String contextpath;

	/** 
	* @Fields evns : TODO
	* 保存控件的自定义JS事件，以控件ID做KEY，EventModel做值
	*/
	private Map<String, EventsModel> evns = new HashMap<String, EventsModel>();

	/** 
	* @Title: init 
	* @Description: TODO
	* 当类加载的时候读取配置文件，预加载每个控件的JS自定义事件
	* @param      
	* @return void     
	* @throws 
	*/
	public void init() {

		SAXReader reader = new SAXReader();
		try {//读取配置文件的位置
			String filepath = this.getClass().getClassLoader().getResource("")
					+ this.contextpath;

			filepath = filepath.substring(filepath.indexOf("/"));
            //解析配置文件
			Document d = reader.read(new File(filepath));
			Element root = d.getRootElement();//找到XML根节点
			List<Element> models = root.elements();
			for (Element e : models) {//循环配置文件中的每个节点
				EventsModel em = new EventsModel();
				String id = e.attributeValue("id");//读取ID
				List<Element> ps = e.elements();
				for (Element x : ps) {//预先为每种类型的控件预加载一个model
					em.setEventC(x.getText(), "");
				}
				em.setId(id);
				evns.put(id, em);
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

	public Map<String, EventsModel> getEvns() {
		return evns;
	}

	public void setEvns(Map<String, EventsModel> evns) {
		this.evns = evns;
	}

}

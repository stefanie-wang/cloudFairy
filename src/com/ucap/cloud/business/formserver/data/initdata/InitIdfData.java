/**  
* @Project: cloudFairy
* @Title: InitIdfData.java
* @Package com.ucap.cloud.business.formserver.data.initdata
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-9-6 下午03:16:26
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.initdata;


import java.util.List;
import java.util.Set;
import org.dom4j.Document;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataModel;

/**
 * @ClassName InitIdfData
 * @Description <p>处理离线工具填报后表单的初始化</p>
 * @author sunjq
 * @date 2012-9-6
 */

public class InitIdfData {

	/** 
	 * <p>Title:InitIdfData </p>
	 * <p>Description: 处理离线工具填报之后带数据的表单的初始化</p> 
	 */

	public InitIdfData() {
		// TODO Auto-generated constructor stub
	}
	
	private DataModel dm;
	
	@SuppressWarnings("unchecked")
	public void getData(Document doc){
		List<Element> elementlist = (List<Element>) doc.selectNodes("/uformdoc/formdoc/datadoc/data"); //获取idf文件中data节点
		if(elementlist!=null && elementlist.size()>0){
			
		
		Element el =elementlist.get(0); //获取data节点
		if(el!=null && el.elements().size()>0){ //判断data节点下是否有数据，经过离线工具只有填报数据过后的节点才有数据
			@SuppressWarnings("unused")
			List<Element> elements = el.elements(); //获取data节点下面的数据节点
			Set<String> set = dm.getInputs().keySet();//获取输入项信息
			for(String key:set){//循环每一个输入项
				String namepath = dm.getInputs().get(key).getNamepath();
				namepath = namepath.replaceAll("/ucapform", "");
				if(null!=namepath && !namepath.equals("")){
//					namepath = namepath.substring(namepath.indexOf("/")+1);
//					namepath = namepath.substring(namepath.indexOf("/")+1);
//					 Map map = new HashMap();
//				        map.put("x","http://www.chinatax.gov.cn/gt3nf/sbb/"); 
//				        XPath x = doc.createXPath(namepath); //创建list-property查询
//				        x.setNamespaceURIs(map); // 设置命名空间
//				        List nodelist = x.selectNodes(doc); 
//				        Element et = (Element)nodelist.get(0);
//				        List<Element> elis = et.elements(namepath);
//				        System.out.println(et.elements().size()+"--------------");
					List<Element> elementl = (List<Element>) doc.selectNodes("/uformdoc/formdoc/datadoc/data"+namepath);
					if(elementl!=null && elementl.size()>0){
						Element element = elementl.get(0);
						dm.getInputs().get(key).setValue(element.getText()) ;
//						List l = element.selectNodes("//");
//						if(null!=l&&l.size()>0)
//						{
//							Node n = (Node) l.get(0);
//							System.out.println(n.getText()+"--------------");
//						}
					}
					
					
				}
				
//				if(dm.getRepeattable().size()>0 && dm.getRepeattable()!=null){//单独处理重复表
//					//Set<String> tableSet =dm.getRepeattable().keySet();
//					
//				}
//				for(Element e:elements){
//					if(e.getName().equals(key)){//如果节点名字和输入项相同
//						dm.getInputs().get(key).setValue(e.getText()) ;//对该输入项完成赋值
//					}
//				}
			}
		}
		}
	}


	
	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}
	
	

}

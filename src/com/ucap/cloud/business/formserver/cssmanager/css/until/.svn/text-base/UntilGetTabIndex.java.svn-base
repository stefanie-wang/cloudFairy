/**  
* @Project: cloudFairy
* @Title: UntilGetTabIndex.java
* @Package com.ucap.cloud.business.formserver.cssmanager.css.until
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-15 下午04:53:38
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.List;
import java.util.Set;

import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.InputModel;
/**
 * @ClassName UntilGetTabIndex
 * @Description 解析控件的tabIndex属性
 * @author sunjq
 * @date 2012-10-15
 */

public class UntilGetTabIndex {

	/** 
	 * <p>Title:UntilGetTabIndex </p>
	 * <p>Description:解析控件的tabIndex属性 </p> 
	 */
	public UntilGetTabIndex() {
		// TODO Auto-generated constructor stub
	}
	
	/** 
	* @Title: getTabIndex 
	* @Description: 解析控件的tabIndex属性
	* @param @return   节点信息  
	* @return Map<String,String> tabIndex的集合，key为tabindex顺序，value为控件的id   
	* @throws 
	*/
	public DataModel getTabIndex(List<Element> listpage,DataModel dm){
//		if(listpage.size()>0){//循环处理每一页
//			for (int i = 0; i < listpage.size(); i++) {
//				/* xml中controls节点 */
//				Element controlselement = listpage.get(i);
//				// controls节点下面的子节点集合
//				List<Element> listcontrols = controlselement.elements();
//				int n = listcontrols.size();
//				for (int j = 0; j < n ; j++) {
//					// 根controls节点下面的子节点(控件是正常位置的)
//					Element controlsson = listcontrols.get(j);
//					String name = "";
//					if(controlsson.getName().equals("table")){
//						name = controlsson.element("name").getText();
//						List<Element> listrepeatUnitcontrols = controlsson.elements("columns/column/controls");
//						if(listrepeatUnitcontrols.size()>0&&listrepeatUnitcontrols!=null){
//							for(Element ee:listrepeatUnitcontrols){
//								String conname = ee.attributeValue("name");
//								String contabindex = ee.attributeValue("tabIndex");
//								dm.getTabIndex().put(contabindex, conname);
//							}
//						}
//						
//					}
//					if(controlsson.getName().equals("repeatUnit")){
//						name = controlsson.attributeValue("name");
//						List<Element> listrepeatUnitcontrols = controlsson.elements("repeatAreas/repeatArea/controls");
//						if(listrepeatUnitcontrols.size()>0&&listrepeatUnitcontrols!=null){
//							for(Element ee:listrepeatUnitcontrols){
//								String conname = ee.attributeValue("name");
//								String contabindex = ee.attributeValue("tabIndex");
//								dm.getTabIndex().put(contabindex, conname);
//							}
//						}
//						
//					}
////					if(controlsson.getName().equals("grid")){
////						name = controlsson.element("name").getText();
////						List<Element> listrepeatUnitcontrols = controlsson.elements();
////						if(listrepeatUnitcontrols.size()>0&&listrepeatUnitcontrols!=null){
////							for(Element ee:listrepeatUnitcontrols){
////								String conname = ee.attributeValue("name");
////								String contabindex = ee.attributeValue("tabIndex");
////								dm.getTabIndex().put(contabindex, conname);
////							}
////						}
////						
////					}
//					String tabindex = controlsson.attributeValue("tabIndex");
//				    name = controlsson.attributeValue("name");
//				    dm.getTabIndex().put(tabindex, name);
//					
//				}
//			}
//		}
		Set<String> keyset = dm.getInputs().keySet();
		for(String key:keyset){
			InputModel in = dm.getInputs().get(key);
			String tabindex = in.getTabIndex();
			String name = in.getName();
			if(!tabindex.equals("") && null!=tabindex){
				dm.getTabIndex().put(tabindex, name);
			}
		}
		return dm;
	}

}

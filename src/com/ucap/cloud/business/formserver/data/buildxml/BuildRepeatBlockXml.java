/**  
* @Project: cloudFairy
* @Title: BuildRepeatBlockXml.java
* @Package com.ucap.cloud.business.formserver.data.buildxml
* @Description: TODO
* @authorshenyanghong ahong2011@gmail.com
* @date 2012-10-17 下午04:51:58
* @Copyright: 2012 
* @version V1.0  
*/

package com.ucap.cloud.business.formserver.data.buildxml;

import java.util.List;
import java.util.Set;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.RepeatBlockModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

/**
 * @ClassName BuildRepeatBlockXml
 * @Description 依据DM对象中的重复块信息生成Dom对象
 * @author sunjq
 * @date 2012-10-17
 */

public class BuildRepeatBlockXml {

	/** 
	 * <p>Title:BuildRepeatBlockXml </p>
	 * <p>Description:依据DM对象中的重复块信息生成Dom对象 </p> 
	 */

	public BuildRepeatBlockXml() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public void build(Document doc,DataModel dm){
		if(dm.getRepeatBlock().size()>0 && null!=dm.getRepeatBlock()){//判断表单中是否含有重复表
			Set<String> repset = dm.getRepeatBlock().keySet();//获取表单中重复表的控件ID
			for(String keyy:repset){  //循环处理每个重复表
				RepeatBlockModel repblock = dm.getRepeatBlock(keyy); //通过控件ID获取重复表信息
				String repnamepath = repblock.getNamepath(); //获取重复表的namepath
				List<Element> elementlist = (List<Element>) doc.selectNodes("/data"+ repnamepath);//依据namepath获取doc的节点信息							
				if(null!=elementlist && elementlist.size()>0){ //判断节点是否存在
					Element eledata = elementlist.get(0); //得到原始idf节点或者数据文件第一个节点用于复制
					Element parent = eledata.getParent(); //得到数据节点的父节点
					Attribute att = eledata.attribute("sys_uform_repeat_type");//XML文件中表示控件重复块类型的属性
					if(att==null){
						eledata.addAttribute("sys_uform_repeat_type", "repeat");
					}
					Attribute attribute = eledata.attribute("sys_uform_index");//XML文件中表示数据行号的属性
					if(null==attribute){
						eledata.addAttribute("sys_uform_index","data" );
					}
					for(int z=0;z<repblock.getPageControl().size();z++){  //依据重复表的行数做循环
						Element el = (Element)eledata.clone();//复制原始
						//Element el = eledata.createCopy();
						el.attribute("sys_uform_index").setValue(z+1+"");
						parent.add(el);
						List<Element> ellist = el.elements();//获取数据节点，代表每一列的值
						if(ellist.size()>0 && ellist!=null){
							for(int i=0;i<ellist.size();i++){//循环处理每一列
								Element value = ellist.get(i);//获取列的节点
								String elName = value.getName();
								if(repblock.getPageControl().get(z+"").getInsideControl().get(elName)!=null){
									String text = repblock.getPageControl().get(z+"").getInsideControl().get(elName).getValue();
									value.setText(text);//将数据模型中值赋予列节点	
								}
							}
						}
					}
					List<Element> elements = (List<Element>) doc.selectNodes("/data"+ repnamepath);//依据namepath获取doc的节点信息
					for(Element e:elements){
						String v = e.attribute("sys_uform_index").getValue();
						if(v.equals("data")){							
							parent.remove(e);
						}
					}
				}
			}
		}
	}
}

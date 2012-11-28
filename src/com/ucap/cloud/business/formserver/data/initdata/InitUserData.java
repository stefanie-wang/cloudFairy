/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: InitUserData.java
 * @Package com.ucap.cloud.business.formserver.data.initdata
 */
package com.ucap.cloud.business.formserver.data.initdata;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.InputModel;
import com.ucap.cloud.business.formserver.data.model.RepeatBlockModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

/**
 * @ClassName InitUserData
 * @Description TODO 初始化用户信息
 * @author sunjq
 * @date 2012-8-10
 */
public class InitUserData {

	/** 
	 * <p>InitUserData </p> 
	 * <p>依据初始化数据文件，完成用户的初始赋值 </p>  
	 */
	public InitUserData() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * <p>Title:InitUserData </p>
	 * <p>Description:依据初始化数据文件，完成用户的初始赋值 </p>
	 * @param dm 
	 */
	public InitUserData(DataModel dm) {
		this.dm = dm;
	}


	/** 
	 * @Fields dm : 数据模型DM
	 */
	private DataModel dm;

	/**
	 * 加载dataMoedl
	 * 
	 * @param e
	 *            数据文件的dom对象
	 */
	@SuppressWarnings("unchecked")
	public DataModel initdm(Document doc) {
		//重复块的处理
		if(null!=dm.getRepeatBlock() && dm.getRepeatBlock().size()>0){
			Set <String> keyset = dm.getRepeatBlock().keySet();
			for(String key:keyset){
				RepeatBlockModel rbm = dm.getRepeatBlock(key);
				String namepath = rbm.getNamepath();
				List<Element> elementlist = (List<Element>) doc.selectNodes("/data"+namepath);//根据namepath获取数据文件中的节点，有可能是多个
				if(null!=elementlist && elementlist.size()>0){
					
				}
			}
		}

		//重复表处理
		if(null!=dm.getRepeattable() && dm.getRepeattable().size()>0){//判断DM对象中是否含有重复表
			
			Set<String> keyset = dm.getRepeattable().keySet();//获取每个重复表的名字
			for(String key:keyset){//循环处理每个重复表
				RepeateTable reptable = dm.getRepeattable(key);//通过ID获取重复表
				String namepath = reptable.getNamepath();//获取重复表的namepath
				List<Element> elementlist = (List<Element>) doc.selectNodes("/data"+namepath);//根据namepath获取数据文件中的节点，有可能是多个
				if(null!=elementlist && elementlist.size()>0){
					String ind ="";
					reptable.setRowsNum(elementlist.size()+1);
					for(int i=0;i<elementlist.size();i++){//循环每个节点
						Element element = elementlist.get(i);//此时获取的节点对应的是重复表中的一行数据
					    ind = element.attributeValue("sys_uform_index");//获取节点的index属性，代表行号
						if(null!=ind){
							int index = Integer.parseInt(ind)-1;
							List<Element> values = element.elements();//获取初始化数据的节点
							List<String> controlsindex = new ArrayList<String>();//用于保存重复表中控件的顺序
							for(Element e:values){
								controlsindex.add(e.getName());//循环节点，节点的顺序就是控件的顺序
							}
							reptable.setConindex(controlsindex);
							List<String> valuelist = new ArrayList<String>();//新建一个List用于保存数据
							for(int z=0;z<values.size();z++){//循环数据节点
								if(null!=values.get(z).getText()){//得到该节点下面的值
									valuelist.add(values.get(z).getText());//将值添加到List中
								}else{ 
									valuelist.add(""); //如果此节点没有数据，就放个默认值
								}
							}
							reptable.getRep().put(index+"", valuelist);//将初始化数据重新放回重复表信息中
						}
						
					}
				}

			}
		}
	
	// 得到所有的可输入项
	Map ints = dm.getInputs();
	//得到每个控件的名称
	Set<String> keyset = ints.keySet();
	//循环处理每个控件
	for (String key : keyset) {
		//根据KEY获得可输入项信息
		InputModel in = (InputModel) ints.get(key);
		//获取控件的NamePath
		String namepath = in.getNamepath();		
		//依据NamePath获取节点信息
		List<Element> el = (List<Element>) doc.selectNodes("/data"
				+ namepath);
		//如果节点不为空，说明此控件有初始化信息
		if (null != el && el.size() > 0 && !namepath.equals("")) {
			//对应NamePath的节点应该是唯一
			Element ell = el.get(0);
			if (!ell.getPath().equals("/")) {
				//完成对此控件的赋值
				in.setValue(ell.getText());
			}
		}
	}
	return dm;
}

public void setDm(DataModel dm) {
	this.dm = dm;
}

public DataModel getDm() {
	return dm;
}

}

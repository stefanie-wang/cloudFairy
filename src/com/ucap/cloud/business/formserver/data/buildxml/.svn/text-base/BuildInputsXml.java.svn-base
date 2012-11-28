/**  
 * @Project: cloudFairy
 * @Title: BuildInputsXml.java
 * @Package com.ucap.cloud.business.formserver.data.buildxml
 * @Description: TODO
 * @authorshenyanghong ahong2011@gmail.com
 * @date 2012-10-17 下午04:24:10
 * @Copyright: 2012 
 * @version V1.0  
 */

package com.ucap.cloud.business.formserver.data.buildxml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.InputModel;

/**
 * @ClassName BuildInputsXml
 * @Description 处理DM对象中inputs信息，构建Dom节点
 * @author sunjq
 * @date 2012-10-17
 */

public class BuildInputsXml {

	/** 
	 * <p>Title:BuildInputsXml </p>
	 * <p>Description:依据inputs信息，处理基础控件构建Dom节点信息 </p> 
	 */

	public BuildInputsXml() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("unchecked")
	public void build(Document doc,DataModel dm){
		//获取DM对象中的可输入项信息
		Map <String,InputModel>ints = dm.getInputs();
		Map<String,List<String>> checkboxs = dm.getCheckBoxGroup();
		if(checkboxs!=null && checkboxs.size()>0){
			Set<String>keyset = checkboxs.keySet();
			for(String key:keyset){
				List<String> values = new ArrayList<String>();
				List<String> checkbox = checkboxs.get(key);
				for(String op:checkbox){
					if(ints.get(op).getChecked().equals("-1")){
						if(values.size()>0){
							values.add(";"+ints.get(op).getValue());
						}else{
							values.add(ints.get(op).getValue());
						}
					}
					
				}
				String namepath = ints.get(checkbox.get(0)).getNamepath();
				List<Element> el = (List<Element>) doc.selectNodes("/data"
						+ namepath);
				//如果获取的节点不为空，说明此控件有初始化信息
				if (null != namepath && null != el && el.size() > 0
						&& !namepath.equals("")) {
					//根据NamePath获取的节点应该是唯一的，所以获取第一个就可以了
					Element ell = el.get(0);
					if (!ell.getPath().equals("/")) {
						String vv = values.toString().replaceAll(",", "");
						vv = vv.replaceAll("\\[","");
						vv = vv.replaceAll("\\]","");
						ell.setText(vv);
					}
				}
			}
		}
		//得到每个可输入项代表的控件名称
		Set<String> keyset = ints.keySet();
		//循环读取每个可输入项
		for (String key : keyset) {
			if(dm.getRepeattable()!=null &&dm.getRepeattable().size()>0){
				Set<String> tableset = dm.getRepeattable().keySet();
				for(String tableKey:tableset){
					List<String> contlist = dm.getRepeattable(tableKey).getConindex();
					int i = contlist.indexOf(key);
					if(i==-1){
						//根据key获取控件
						InputModel in = (InputModel) ints.get(key);
						String conType = in.getControlType();
						//获取控件的NamePath
						String namepath = in.getNamepath();
						//根据Namepath在XML文件中获取节点
						List<Element> el = (List<Element>) doc.selectNodes("/data"
								+ namepath);
						//如果获取的节点不为空，说明此控件有初始化信息
						if (null != namepath && null != el && el.size() > 0
								&& !namepath.equals("")) {
							//根据NamePath获取的节点应该是唯一的，所以获取第一个就可以了
							Element ell = el.get(0);
							if (!ell.getPath().equals("/")) {
								//将控件的值写入到对应的节点中
								if(conType.equals("radioBox")){//处理单选框
									if(in.getSelected().equals("-1")){
										ell.setText(in.getValue());
									}
								}else if(conType.equals("dropList")||conType.equals("list")){//处理下拉列表或者列表框
									StringBuilder sb = new StringBuilder("");
									if(in.getDroplm().getOptions()!=null && in.getDroplm().getOptions().size()>0){
										for(int p=0;p<in.getDroplm().getOptions().size();p++){
											if(in.getDroplm().getOptions().get(p).getSelected().equals("-1")){
												sb.append(in.getDroplm().getOptions().get(p).getValue());
											}
										}
										ell.setText(sb.toString());
									}
								}else if(conType.equals("checkBox")){
									
								}
								else{
									ell.setText(in.getValue());
								}
							}
						}
					}
				}
			}else{
				//根据key获取控件
				InputModel in = (InputModel) ints.get(key);
				String conType = in.getControlType();
				//获取控件的NamePath
				String namepath = in.getNamepath();
				//根据Namepath在XML文件中获取节点
				List<Element> el = (List<Element>) doc.selectNodes("/data"
						+ namepath);
				//如果获取的节点不为空，说明此控件有初始化信息
				if (null != namepath && null != el && el.size() > 0
						&& !namepath.equals("")) {
					//根据NamePath获取的节点应该是唯一的，所以获取第一个就可以了
					Element ell = el.get(0);
					if (!ell.getPath().equals("/")) {
						if(conType.equals("radioBox")){
							if(in.getSelected().equals("-1")){
								ell.setText(in.getValue());
							}
						}
						else if(conType.equals("dropList")||conType.equals("list")){//处理下拉列表或者列表框
							StringBuilder sb = new StringBuilder("");
							if(in.getDroplm().getOptions()!=null && in.getDroplm().getOptions().size()>0){
								for(int p=0;p<in.getDroplm().getOptions().size();p++){
									if(in.getDroplm().getOptions().get(p).getSelected().equals("-1")){
										sb.append(in.getDroplm().getOptions().get(p).getValue());
									}
								}
								ell.setText(sb.toString());
							}
						}else if(conType.equals("checkBox")){
							
						}
						else{
							ell.setText(in.getValue());
						}
					}
				}
			}
		}

	}

}

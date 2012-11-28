package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.DataEventLoader;
import com.ucap.cloud.business.formserver.data.model.DataModelProLoader;
import com.ucap.cloud.business.formserver.data.model.DataModelProp;
import com.ucap.cloud.business.formserver.data.model.DropListModel;
import com.ucap.cloud.business.formserver.data.model.EventsModel;
import com.ucap.cloud.business.formserver.data.model.InputModel;
import com.ucap.cloud.business.formserver.data.model.OptionModel;
import com.ucap.cloud.business.formserver.validate.ValidataLoader;
//import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;
/**
 * @ClassName CssUntilGetAttributeImpl
 * @Description TODO 解析idf文件中的控件的属性
 * @author pzg
 * @date 2012-8-31
 */
public class CssUntilGetAttributeImpl implements CssUntilGetAttribute {

	public CssUntilGetAttributeImpl(){
	}
	/**
	 * @Title: init
	 * @Description: TODO
	 *               <p>
	 *               类加载的时候执行的方法
	 *               </p>
	 * @param    
	 * @return void   
	 * @throws
	 */
	public void init() {
		
	}
	/**
	 * 	/**
	 * 处理控件的属性
	 * @param controlsson 节点
	 * @return  input控件模型
	 */
	public InputModel getinput(Element controlsson,ValidataLoader vl){
		
		String namepath = "";
		if (null != controlsson.attributeValue("namepath")) {
			namepath = controlsson.attributeValue("namepath");
			if(namepath.startsWith("/ucapform")){
				namepath = namepath.substring(9);//截取namepath不要/ucapform
			}
		}
		if (null != namepath) {
			InputModel in = new InputModel(controlsson);
			EventsModel ev = new EventsModel();
			// 提取验证信息
			vl.loaderValidate(controlsson);
			// 提取验证信息完成
			String name = controlsson.attributeValue("name");
			//读取控件的类型
			String contype = controlsson.getName();
			in.setControlType(contype);
			// 如果是静态图片
			if(controlsson.getName().equals("graphic")){
				in.setSrc(this.getgraphic(controlsson));
			}
			//如果是动态图片
			if(contype.equals("movimg")){
				String picName=controlsson.attributeValue("name");
			}
			/**
			 * add by sunjq
			 */
			// 专门处理DropList的模型
			DropListModel drom = null;
			if (controlsson.getName().equals("dropList")
					|| controlsson.getName().equals("list")) {
				drom = new DropListModel(controlsson);
				// 获取所有选项
				List<Element> items = controlsson.elements("items");
				// 循环处理选项将选项值放入模型中
				for (Element el : items) {
					List<Element> ee = el.elements("item");
					for (Element et : ee) {
						OptionModel om = new OptionModel(et);
						drom.setOptions(om);
					}
				}
			}
			// 将解析出来的值放入对应的模型中
			ev.setId(name);
			in.setDroplm(drom);
			in.setName(name);
			in.setNamepath(namepath);
			// end 
			// 获取input节点下的format节点
			Element formate = controlsson.element("format");
			// 判断是否存在formate节点
			if (null != formate) {
				     if(this.getFormate(formate)!=null){
				    	 in.setAttribute(this.getFormate(formate));
				     }
			}
			// 获取events节点
			Element eventEl = controlsson.element("events");
			// 判断是否存在events节点
			if (null != eventEl) {
				   if(this.getEventEl(controlsson)!=null){
					   ev.setEventC(this.getEventEl(controlsson));
				   }
			}
			in.setEv(ev);
			return in;
		}else{
			return null;
		}
		
		
	}
	 /**
     * 
     * @param controlsson  要处理的节点 此处是js的事件
     * @return 返回类型和内容
     */
    public Map<String,String> getEventEl(Element controlsson){
		String conname = controlsson.getName();
		Map<String, String> map = new HashMap<String, String>();
//		SPRINGCONTEXT.getBean("eventloader");
		//获得事件模型
			EventsModel evmo = this.devl.getEvns().get(conname);
			if (null != evmo) {
				//所有事件类型
				Set<String> set = evmo.getEventC().keySet();
				for (String k : set) {
					if (null != controlsson.element("events").element(k)
							.element("JScript").getText()
							&& !"".equals(controlsson.element("events")
									.element(k).element("JScript")
									.getText())) {
						//将事件类型（如onclick或者onchange）和js内容放入map中
						map.put(k, controlsson.element("events")
								.element(k).element("JScript").getText());
					}
				}
		}
		return map;
    }
	/**
	 * 
	 * @param e  需要处理的控件节点 此处是 formate
	 * @return   返回类型和内容
	 */
    public Map<String,String> getFormate(Element formate){
    	Map<String,String> map = new HashMap<String, String>();
		String datatype = formate.attributeValue("dataType");
		//根据数据类型获得对应的model
			DataModelProp dmp = this.dp.getProp().get(datatype);
			if (formate.elements().size() > 0) {
				Element textdate = formate.elements().get(0);// 获取可输入项节点
				if (null != dmp) {
					// 类型的总和
					Set<String> set = dmp.getProps().keySet();
					for (String k : set) {
						map.put(k, textdate.attributeValue(k));
					}
					map.put("dataType", datatype);
					// 获取指定属性完成
				}
				return map;
		}
		return map;
    }
    
    public String getgraphic(Element controlsson){
    	String path = "";    	
    	String picName = controlsson.attributeValue(
		"imageFile");
    	picName = picName.hashCode()+"";
		StringBuilder sb = new StringBuilder();
		sb.append(controlsson.element("base64BinaryData").getText());

		URL url = getClass().getProtectionDomain().getCodeSource()
		.getLocation();
	     path = url.getPath().split("WEB-INF")[0]
		                                                 + "datafile/images/" + picName;
		File file = new File(path);
		try {
			FileOutputStream fw = new FileOutputStream(file);
			byte[] temp = (new sun.misc.BASE64Decoder()).decodeBuffer(sb
					.toString());
			fw.write(temp);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
    	
	/**
	 * 提取验证数据信息
	 */
	private ValidataLoader vl ;
	/**
	 * 需要进行解析的属性名列表
	 */
	private DataModelProLoader dp;
	/**
	 * 
	 */
	private DataEventLoader devl;
	

	
	public DataModelProLoader getDp() {
		return dp;
	}
	public void setDp(DataModelProLoader dp) {
		this.dp = dp;
	}
	public DataEventLoader getDevl() {
		return devl;
	}
	public void setDevl(DataEventLoader devl) {
		this.devl = devl;
	}
	public ValidataLoader getVl() {
		return vl;
	}
	public void setVl(ValidataLoader vl) {
		this.vl = vl;
	}
	
}

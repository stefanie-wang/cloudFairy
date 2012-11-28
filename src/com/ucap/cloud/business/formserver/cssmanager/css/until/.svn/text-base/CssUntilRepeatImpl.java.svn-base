package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate.GetCssFileDateGetRepeatUnitModel;
import com.ucap.cloud.business.formserver.data.model.BlockControTypeModel;
import com.ucap.cloud.business.formserver.data.model.ControlBlockModel;
import com.ucap.cloud.business.formserver.data.model.DataEventLoader;
import com.ucap.cloud.business.formserver.data.model.EventsModel;
import com.ucap.cloud.business.formserver.data.model.RepeatBlockModel;

/**
 * @ClassName CssUntilRepeatImpl
 * @Description TODO 解析idf文件中的重复块片段
 * @author pzg
 * @date 2012-8-31
 */
public class CssUntilRepeatImpl implements CssUntilRepeat,CssUntilGetModel {

	public CssUntilRepeatImpl(){
		
	}
	public Map<String, CssUntilGetAllModel> getRepeatmap() {
		return repeatmap;
	}
	public void setRepeatmap(Map<String, CssUntilGetAllModel> repeatmap) {
		this.repeatmap = repeatmap;
	}
	/**
	 * 获取所有需要进行解析的具体类对象
	 */
	private Map<String, CssUntilGetAllModel> repeatmap ;
	
	private GetCssFileDateGetRepeatUnitModel repeatUnitModel;
	public GetCssFileDateGetRepeatUnitModel getRepeatUnitModel() {
		return repeatUnitModel;
	}
	public void setRepeatUnitModel(GetCssFileDateGetRepeatUnitModel repeatUnitModel) {
		this.repeatUnitModel = repeatUnitModel;
	}
	@Override
	public List<String> getBigControls(Element controlsson,CssUntilParseXML parsexml) throws Exception {
		List<String> list = new ArrayList<String>();
		// 重复块
		List<String> listre = this.repeatUnitModel.getStringCss(controlsson);
		for (String ss : listre) {
			list.add(ss);
		}
		// 重复块结束
		List<Element> listrepeatUnit = controlsson.elements();
		RepeatBlockModel rbm = new RepeatBlockModel();
		String st = controlsson.attributeValue("showTitle");
		String sn = controlsson.attributeValue("showSeq");
		rbm.setShowNumber(sn);
		rbm.setShowTitle(st);
		String repeatName = controlsson.attributeValue("name");
		String namepath = controlsson.attributeValue("namepath");
		if(namepath.startsWith("/ucapform")){
			namepath = namepath.substring(9);//截取namepath不要/ucapform
		}
		rbm.setNamepath(namepath);
		ControlBlockModel cbm = new ControlBlockModel();
		for (int re = 0; re < listrepeatUnit.size(); re++) {
			Element repeatAreas = listrepeatUnit.get(re);
			// repeatAreas节点
			if (repeatAreas.getName().equals("repeatAreas")) {
				List<Element> listrepeatAreasson = repeatAreas
				.elements();
				for (int s = 0; s < listrepeatAreasson.size(); s++) {
					Element es = listrepeatAreasson.get(s);
					if (es.getName().equals("repeatArea")) {
						List<Element> listrepeatArea = es
						.elements();
						for (int sj = 0; sj < listrepeatArea.size(); sj++) {
							Element esd = listrepeatArea.get(sj);
							/**
							 * 重复块下面的controls
							 */
							if (esd.getName().equals("controls")) {
								List<Element> listrepeatUnitcontrols = esd
								.elements();
								for (int controlsre = 0; controlsre < listrepeatUnitcontrols
								.size(); controlsre++) {
									Element controlsreele = listrepeatUnitcontrols
									.get(controlsre);
									// 重复块下面的controls 下面的控件
									String repacearea = controlsreele
									.getName();
									
									String conname = "";

									if (null != this.repeatmap
											.get(repacearea) ||repacearea.equals("movimg")
											||repacearea.equals("graphic")) {
										// 关联数据
										// 例如：namepath="/ucapform/cpy_21"
										conname = controlsreele.attributeValue("name");
										if(!repacearea.equals("button")){
											rbm.setControllist(conname);
										}
										parsexml
										.getinput(controlsreele);
										if(repacearea.equals("movimg")){
											
										}else if(repacearea.equals("graphic")){
											
										}
										else{
											list
											.add(this.repeatmap
													.get(
															repacearea)
															.getStringCss(
																	controlsreele));
										}
										
									}
									
								    String value = parsexml.getDm().getInputs().get(conname).getValue();//从DM中获取该控件的初始值
								    String type =  parsexml.getDm().getInputs().get(conname).getControlType();//从DM中获取该控件的类型
//								    List<String> arr = new ArrayList<String>();
//								    arr.add(type);
//								    arr.add(value);
								    BlockControTypeModel bc = new BlockControTypeModel();//保存重复块里面控件的类型和值
								    bc.setType(type);
								    bc.setValue(value);
								    //cbm.setInsideCon(conname, arr);
									cbm.setInsideControl(conname, bc);//将该控件放入重复表内部控件中
									
								}
							}

						}
					}

				}
			}
		}
		rbm.setPageControl("0", cbm);
		//处理重复块的自定义事件
		String conname = controlsson.getName();
		Map<String, String> map = new HashMap<String, String>();
		DataEventLoader devl = (DataEventLoader)SPRINGCONTEXT.getBean("eventloader");
		//获得事件模型
			EventsModel evmo = devl.getEvns().get(conname);
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
				evmo.setId(controlsson.attributeValue("name"));
				evmo.setEventC(map);
		}
		parsexml.getDm().setEvents(evmo);
		parsexml.getDm().setRepeatBlock(repeatName, rbm);
		return list;
	}

}

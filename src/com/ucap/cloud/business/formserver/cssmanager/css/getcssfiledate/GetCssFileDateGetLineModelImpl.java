/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetLineModelImpl.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelControlsType;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelLineModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetLineModelImpl
 * @Description TODO <P>解析idf中所有的line控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetLineModelImpl implements CssUntilGetAllModel {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateGetLineModelImpl() {

	}
	/**
	 *  判断参数是否为空
	 */
    private Ifboolean iftrue ;
	public Ifboolean getIftrue() {
		return iftrue;
	}

	public void setIftrue(Ifboolean iftrue) {
		this.iftrue = iftrue;
	}
	public CssModelGetCssModel getGb() {
		return gb;
	}

	public void setGb(CssModelGetCssModel gb) {
		this.gb = gb;
	}
      /**
       *  css样式模型
       */
	private CssModelGetCssModel gb = new CssModelGetCssModel();

	/**
	 * 获取单个控件中的Css样式的所有属性值
	 * 
	 * @param e
	 *            要处理的节点
	 * @return Map模型
	 * @throws Exception
	 */
	public Map<String, Object> getModel(Element e) throws Exception {

		Map<String, Object> mapkongjian = new HashMap<String, Object>();
		if(iftrue.getobj(e)){
			return mapkongjian;
		}
		// 控件类型名称 如 input button
		String controlsname = e.getName();
		String typenme = e.attributeValue("name");
		CssModelControlsType ct = new CssModelControlsType();
		ct.setType(controlsname); // 控件类型名称 input
		ct.setTypename(typenme); // 属性名称 如input 中name属性 也是ID
		mapkongjian.put("controlstype", ct);
		List<Element> aelement = e.elements();
		CssModelLineModel li = gb.getLine(e);
		mapkongjian.put("line", li);
		for (int i = 0; i < aelement.size(); i++) {
			Element css = aelement.get(i);
			// 控件的样式
			if (css.getName().equals("sizeAndPosition")) {
				CssModelSizeAndPosition si = gb.getsizeandposition(css);
				mapkongjian.put("sizeAndPosition", si);
			}
		}
		return mapkongjian;
	}

	/**
	 * 生成css样式的字符串
	 * 
	 * @param e
	 *            要处理的某一节点
	 * @return 单个控件的Css样式
	 * @throws Exception
	 */
	public String getStringCss(Element e) throws Exception {

		StringBuilder s = new StringBuilder("");
		if(iftrue.getobj(e)){
			return s.toString();
		}
		Map<String, Object> map = this.getModel(e);
		CssModelControlsType ct = (CssModelControlsType) map
				.get("controlstype");
		@SuppressWarnings("unused")
		CssModelLineModel li = (CssModelLineModel) map.get("line");
		// log.info(li.getThickness());
		s.append(" #" + ct.getTypename());
		s.append(" {  z-index: 5;");
		// 控件坐标 此控件样式解决
		/*
		 * SizeAndPosition si = (SizeAndPosition) map.get("sizeAndPosition");
		 * s.append("left:").append(si.getLeft()).append(";");
		 * s.append("top:").append(si.getTop()).append(";");
		 * s.append("border-color:").append(li.getForeColor());
		 * s.append(" ; font-weight:").append(li.getThickness()).append("pt ;");
		 */
		// 最后结尾
		s.append("}");
		// StringBuffer formto = new StringBuffer();
		Map<String, String> mapform = new HashMap<String, String>();
		this.vlineList.add(mapform);
		// log.info(s.toString());
		return s.toString();
	}

	// 控件ID与v:line其中的值 Map<String,String>
	private List<Map<String, String>> vlineList = new ArrayList<Map<String, String>>();

	public List<Map<String, String>> getVlineList() {
		return vlineList;
	}

	public void setVlineList(List<Map<String, String>> vlineList) {
		this.vlineList = vlineList;
	}

	/**
	 * 处理重复表的控件
	 * 
	 * @param e
	 *            处理节点
	 * @param i
	 *            重复表的行数
	 * @param tableName
	 *            重复表名称
	 * @return css样式
	 * @throws Exception
	 *             异常
	 */
	public String getStringCss(Element e, int i, String tableName)
			throws Exception {
		// TODO Auto-generated method stub
		if(iftrue.gettwoObj(e, tableName)){
			return "";
		}
		Map<String, Object> map = this.getModel(e);
		// 此类包括了控件的类型，类型名称以及判断
		CssModelControlsType ct = (CssModelControlsType) map
				.get("controlstype");
		// 控件原本名称
		StringBuilder sb = new StringBuilder();
		String s = this.getStringCss(e);
		String sname[] = s.split("\\{");
		// #table_Table1_row_2_col_EditBox4
		sb.append("#table").append("_");
		sb.append(tableName);
		sb.append("_row_").append(i).append("_col_").append(ct.getTypename())
				.append("{");
		sb.append(sname[1]);
		return sb.toString();
	}
}

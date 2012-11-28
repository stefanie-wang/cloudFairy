/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetGridModelImpl.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelAutorseGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBackGround;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBacklashGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBottomGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelControlsType;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelFone;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelLeftGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelRightFridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSlashGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTextAlign;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTopGridCell;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetGridModelImpl
 * @Description TODO <P>解析idf中所有的grid控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetGridModelImpl implements CssUntilGetAllModel {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateGetGridModelImpl() {

	}

	public CssModelGetCssModel getGb() {
		return gb;
	}

	public void setGb(CssModelGetCssModel gb) {
		this.gb = gb;
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
    /**
     *  获取css模型
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
		if (aelement != null && aelement.size() > 0) {
			for (int i = 0; i < aelement.size(); i++) {
				Element ee = aelement.get(i);
				// 控件的样式
				if (aelement.size() > 0) {
					Element css = ee;

					if (css.getName().equals("backGround")) {
						CssModelBackGround bc = gb.getCss(css);
						mapkongjian.put("backGround", bc);

					} else if (css.getName().equals("font")) {
						CssModelFone fo = gb.getfonecss(css);
						mapkongjian.put("font", fo);
					} else if (css.getName().equals("sizeAndPosition")) {
						CssModelSizeAndPosition si = gb.getsizeandposition(css);
						mapkongjian.put("sizeAndPosition", si);
					} else if (css.getName().equals("textAlign")) {
						CssModelTextAlign ts = gb.gettextalign(css);
						mapkongjian.put("textAlign", ts);
					} else if (css.getName().equals("cellBorders")) {
						List<Element> listcell = css.elements();
						for (Element cell : listcell) {
							if (cell.getName().equals("backlash")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelBacklashGridCell ba = new CssModelBacklashGridCell();
								ba.setBorderSize(borderSize);
								ba.setBorderColor(borderColor);
								ba.setBorderwidth(borderwidth);
								mapkongjian.put("BacklashGridCell", ba);
							} else if (cell.getName().equals("autorse")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelAutorseGridCell au = new CssModelAutorseGridCell();
								au.setBorderSize(borderSize);
								au.setBorderColor(borderColor);
								au.setBorderwidth(borderwidth);
								mapkongjian.put("AutorseGridCell", au);
							} else if (cell.getName().equals("bottom")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelBottomGridCell bo = new CssModelBottomGridCell();
								bo.setBorderSize(borderSize);
								bo.setBorderColor(borderColor);
								bo.setBorderwidth(borderwidth);
								mapkongjian.put("BottomGridCell", bo);
							} else if (cell.getName().equals("left")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelLeftGridCell le = new CssModelLeftGridCell();
								le.setBorderSize(borderSize);
								le.setBorderColor(borderColor);
								le.setBorderwidth(borderwidth);
								mapkongjian.put("LeftGridCell", le);
							} else if (cell.getName().equals("right")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelRightFridCell ri = new CssModelRightFridCell();
								ri.setBorderSize(borderSize);
								ri.setBorderColor(borderColor);
								ri.setBorderwidth(borderwidth);
								mapkongjian.put("RightFridCell", ri);
							} else if (cell.getName().equals("slash")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelSlashGridCell sl = new CssModelSlashGridCell();
								sl.setBorderSize(borderSize);
								sl.setBorderColor(borderColor);
								sl.setBorderwidth(borderwidth);
								mapkongjian.put("SlashGridCell", sl);
							} else if (cell.getName().equals("top")) {
								String borderSize = cell
										.attributeValue("borderSize");
								String borderColor = cell
										.attributeValue("borderColor");
								String borderwidth = cell
										.attributeValue("borderwidth");
								CssModelTopGridCell top = new CssModelTopGridCell();
								top.setBorderSize(borderSize);
								top.setBorderColor(borderColor);
								top.setBorderwidth(borderwidth);
								mapkongjian.put("TopGridCell", top);
							}
						}
					}
				}

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
		Map<String, List<String>> mapvlin = new HashMap<String, List<String>>();
		if(iftrue.getobj(e)){
			return s.toString();
		}
		Map<String, Object> map = this.getModel(e);
		CssModelControlsType ct = (CssModelControlsType) map
				.get("controlstype");
		String sname = ct.getTypename();
		sname = sname.replace("*", "_");
		s.append(" #" + sname);
		s.append(" { overflow: hidden; position: absolute;");
		// 控件背景色
		CssModelBackGround bc = (CssModelBackGround) map.get("backGround");
		if (bc.getFillColor() != null && bc.getFillColor().equals("#ffffff")) {
			s.append(gb.getMap().get("background-color:")).append("none;");
		} else {
			s.append(gb.getMap().get("background-color:")).append(
					bc.getFillColor()).append(";"); // 颜色
		}
		// 控件坐标 此控件样式解决
		CssModelSizeAndPosition si = (CssModelSizeAndPosition) map
				.get("sizeAndPosition");
		s.append(gb.getMap().get("border-style: solid;"));
		s.append(gb.getMap().get("border-width:")).append("");
		CssModelTopGridCell top = (CssModelTopGridCell) map.get("TopGridCell");
		if (Integer.valueOf(top.getBorderSize()) == 1) {
			s.append(top.getBorderwidth() + " ");
		} else {
			s.append("0 ");
		}
		CssModelRightFridCell ri = (CssModelRightFridCell) map
				.get("RightFridCell");
		if (Integer.valueOf(ri.getBorderSize()) == 1) {
			s.append(ri.getBorderwidth() + " ");
		} else {
			s.append("0 ");
		}
		CssModelBottomGridCell bo = (CssModelBottomGridCell) map
				.get("BottomGridCell");
		if (Integer.valueOf(bo.getBorderSize()) == 1) {
			s.append(bo.getBorderwidth() + " ");
		} else {
			s.append("0 ");
		}
		CssModelLeftGridCell le = (CssModelLeftGridCell) map
				.get("LeftGridCell");
		if (Integer.valueOf(le.getBorderSize()) == 1) {
			s.append(le.getBorderwidth() + "px;");
		} else {
			s.append("0").append("px ;");
		}
		// s.append(gb.getMap().get("z-index:-1px;"));
		s.append("}");
		List<String> listv = new ArrayList<String>();
		// 右上反斜线
		CssModelBacklashGridCell ba = (CssModelBacklashGridCell) map
				.get("BacklashGridCell");
		// v:line 的样式
		StringBuffer strvline = new StringBuffer();
		if (Integer.valueOf(ba.getBorderSize()) > 0) {

			strvline.append("v:line style=\"position:relative;\"");
			strvline.append(" form=\"");
			if (Integer.valueOf(ri.getBorderSize()) == 1) {
				int formi = 0 - Integer.valueOf(ri.getBorderwidth());
				strvline.append(formi);
			} else {
				strvline.append("0");
			}
			strvline.append(",");
			if (Integer.valueOf(top.getBorderSize()) == 1) {
				int formi = 0 - Integer.valueOf(top.getBorderwidth());
				strvline.append(formi);
			} else {
				strvline.append("0");
			}
			strvline.append("\"" + " ");
			strvline.append("to=\"");
			if (Integer.valueOf(ri.getBorderSize()) == 1) {
				int toi = Integer.valueOf(si.getWidth())
						- Integer.valueOf(ri.getBorderwidth());
				strvline.append(toi);
			} else {
				strvline.append(si.getWidth());
			}
			strvline.append(",");
			if (Integer.valueOf(top.getBorderSize()) == 1) {
				int toi = Integer.valueOf(si.getHeight())
						- Integer.valueOf(top.getBorderwidth());
				strvline.append(toi);
			} else {
				strvline.append(si.getHeight());
			}
			strvline.append("\"" + " ");
			strvline.append("strokeweight=\"");
			strvline.append(ba.getBorderSize());
			strvline.append("\" ");
			strvline.append("strokecolor=\"");
			strvline.append(ba.getBorderColor());
			strvline.append("\" ");

			listv.add(strvline.toString());
		}
		// 左上斜线
		StringBuffer ss = new StringBuffer();
		CssModelSlashGridCell sl = (CssModelSlashGridCell) map
				.get("SlashGridCell");
		if (Integer.valueOf(sl.getBorderSize()) > 0) {
			ss.append("v:line style=\"position:relative;\"");
			ss.append(" form=\"");
			if (Integer.valueOf(ri.getBorderSize()) == 1) {
				int formi = 0 - Integer.valueOf(ri.getBorderwidth());
				ss.append(formi);
			} else {
				ss.append("0");
			}
			ss.append(",");
			if (Integer.valueOf(top.getBorderSize()) == 1) {
				int formi = Integer.valueOf(si.getHeight())
						- Integer.valueOf(top.getBorderwidth());
				ss.append(formi);
			} else {
				ss.append(si.getHeight());
			}
			ss.append("\"" + " ");
			ss.append("to=\"");
			if (Integer.valueOf(ri.getBorderSize()) == 1) {
				int toi = Integer.valueOf(si.getWidth())
						- Integer.valueOf(ri.getBorderwidth());
				ss.append(toi);
			} else {
				ss.append(si.getWidth());
			}
			ss.append(",");
			if (Integer.valueOf(top.getBorderSize()) == 1) {
				int toi = 0 - Integer.valueOf(top.getBorderwidth());
				ss.append(toi);
			} else {
				ss.append(0);
			}
			ss.append("\"" + " ");
			ss.append("strokeweight=\"");
			ss.append(ba.getBorderSize());
			ss.append("\" ");
			ss.append("strokecolor=\"");
			ss.append(ba.getBorderColor());
			ss.append("\" ");
			listv.add(ss.toString());
		}
		if (listv != null && listv.size() > 0) {
			mapvlin.put(ct.getTypename(), listv);
			vlineListbge.add(mapvlin);
		}

		// log.info(s.toString());
		return s.toString();
	}

	public List<Map<String, List<String>>> getVlineListbge() {
		return vlineListbge;
	}

	public void setVlineListbge(List<Map<String, List<String>>> vlineListbge) {
		this.vlineListbge = vlineListbge;
	}

	/**
	 * 表格中v：line的集合 左上斜线或者右上斜线的集合
	 */
	private List<Map<String, List<String>>> vlineListbge = new ArrayList<Map<String, List<String>>>();

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

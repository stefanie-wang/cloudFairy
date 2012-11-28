/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetDropListModelImpl.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBackGround;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBorders;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelComBoxModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelFone;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelHints;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTextAlign;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetDropListModelImpl
 * @Description TODO <P>解析idf中所有的droploist控件并生成css样式</P>
 * @author pzg
 * @date 2012-8-10
 */
public class GetCssFileDateGetDropListModelImpl implements CssUntilGetAllModel {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateGetDropListModelImpl() {

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

	/*
	 * (non-Javadoc) <p>Title: getModel</p> <p>Description: </p>
	 * 
	 * @param e 要处理的节点
	 * 
	 * @return 装有解析值的模型
	 * 
	 * @see
	 * com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel
	 * #getModel(org.dom4j.Element)
	 */
	public Map<String, Object> getModel(Element e) {
		Map<String, Object> mapkongjian = new HashMap<String, Object>();
		if(iftrue.getobj(e)){
			return mapkongjian;
		}
		// 控件类型 如input button
		String controlsname = e.getName();
		// 控件ID
		String typenme = e.attributeValue("name");
		String readOnly = e.attributeValue("readOnly");
		mapkongjian.put("readOnly", readOnly);
		String hidden = e.attributeValue("hidden");
		mapkongjian.put("hidden", hidden);
		CssModelComBoxModel cb = new CssModelComBoxModel();
		cb.setContname(typenme);
		cb.setTypename(controlsname);
		List<Element> aelement = e.elements();
		if (aelement != null && aelement.size() > 0) {
			for (int i = 0; i < aelement.size(); i++) {
				Element ee = aelement.get(i);
				if (ee.getName().equals("items")) {
					String itemType = ee.attributeValue("itemType"); // <items
					// itemType="inputData"
					// srcName=""/>
					String srcName = ee.attributeValue("srcName");
					cb.setItemType(itemType);
					cb.setSreName(srcName);
					GetCssFileDateResControsType rct = new GetCssFileDateResControsType();
					Map<String, List<List<Map<String, String>>>> map = rct
							.getdropList(typenme, ee);
					cb.setMap(map);
					mapkongjian.put("ComBoxModel", cb);
				}
				if (ee.getName().equals("appearance")) {
					List<Element> applist = ee.elements();
					if (applist.size() > 0) {
						for (int k = 0; k < applist.size(); k++) {
							Element css = applist.get(k);
							if (css.getName().equals("backGround")) {
								CssModelBackGround bc = gb.getCss(css);
								mapkongjian.put("backGround", bc);

							} else if (css.getName().equals("borders")) {
								CssModelBorders bo = gb.getborderscss(css);
								mapkongjian.put("borders", bo);
							} else if (css.getName().equals("font")) {
								CssModelFone fo = gb.getfonecss(css);
								mapkongjian.put("font", fo);
							} else if (css.getName().equals("sizeAndPosition")) {
								CssModelSizeAndPosition si = gb
										.getsizeandposition(css);
								mapkongjian.put("sizeAndPosition", si);
							} else if (css.getName().equals("textAlign")) {
								CssModelTextAlign ts = gb.gettextalign(css);
								mapkongjian.put("textAlign", ts);
							} else if (css.getName().equals("hints")) {
								CssModelHints hi = gb.gethintscss(css);
								mapkongjian.put("hints", hi);
							}
						}
					}
				}
			}
		}
		return mapkongjian;
	}

	/**
	 * 
	 * @param e
	 *            控件节点
	 * @return 生成css文件字符串
	 */
	public String getStringCss(Element e) throws Exception {

		StringBuilder s = new StringBuilder("");
		if(iftrue.getobj(e)){
			return s.toString();
		}
		Map<String, Object> map = this.getModel(e);
		CssModelComBoxModel ct = (CssModelComBoxModel) map.get("ComBoxModel");
		s.append(" #" + ct.getContname());
		s.append(" {");
		// <backGround imageFile="" transparent="" fillStyle=""
		// fillColor="#ffffff" lineColor="#000000"/>
		String hidden = (String) map.get("hidden");
		if (hidden != null && hidden.equals("-1")) {
			s.append("display:none;");
		}
		String readOnly = (String) map.get("readOnly");
		if (readOnly != null && readOnly.equals("-1")) {
			s.append("readonly:readonly;");
		}
		@SuppressWarnings("unused")
		CssModelBackGround bc = (CssModelBackGround) map.get("backGround");
		/* s.append(gb.getMap().get("background-color:"))
		 .append(bc.getFillColor()).append(";");
		 CssModelBorders br = (CssModelBorders) map.get("borders");
		 s.append(gb.getMap().get(br.getBorderStyle()));
		 s.append(gb.getMap().get("border-color:")).append(br.getBorderColor())
		 .append(";");
		 if (br.getTop() != null && br.getTop().length() > 0) {
		 if (Integer.valueOf(br.getTop()) != 0) {
		 s.append(gb.getMap().get("border-width:")).append(
		 br.getBorderSize());
		 } else {
		 s.append(gb.getMap().get("border-width:")).append("0");
		 }
		 }
		 if (br.getRight() != null && br.getRight().length() > 0) {
		 if (Integer.valueOf(br.getRight()) != 0) {
		 s.append(" ").append(br.getBorderSize());
		 } else {
		 s.append(" 0");
		 }
		 }
		 if (br.getBottom() != null && br.getBottom().length() > 0) {
		 if (Integer.valueOf(br.getBottom()) != 0) {
		 s.append(" ").append(br.getBorderSize());
		 } else {
		 s.append(" 0");
		 }
		 }
		 if (br.getLeft().length() > 0 && br.getLeft() != null) {
		 if (Integer.valueOf(br.getLeft()) != 0) {
		 s.append(" ").append(br.getBorderSize()).append(" ;");
		 } else {
		 s.append(" 0 ;");
		 }
		 }*/
		CssModelFone fo = (CssModelFone) map.get("font");
		s.append(gb.getMap().get("font-family:")).append(fo.getFontFamily())
				.append(";");
		s.append(gb.getMap().get("color:")).append(fo.getFontColor()).append(
				";");
		s.append(gb.getMap().get("font-size:")).append(fo.getFontSize())
				.append("pt;");
		if (Integer.valueOf(fo.getBold()) != 0) {
			s.append(gb.getMap().get("font-weight:bold;"));
		}
		if (Integer.valueOf(fo.getItalic()) != 0) {
			s.append(gb.getMap().get("font-style: italic;"));
		}
		if (Integer.valueOf(fo.getUnderline()) != 0) {
			s.append(gb.getMap().get("text-decoration:underline;"));
		}
		if (Integer.valueOf(fo.getStrikeout()) == 0) {
			s.append(gb.getMap().get("text-decoration:none;"));
		}
		CssModelTextAlign ctl = (CssModelTextAlign) map.get("textAlign");
		if (ctl != null) {
			s.append("text-align:").append(ctl.getAlign()).append(";");
		}
		CssModelBorders bor = (	CssModelBorders)map.get("borders");
		if(bor!=null){
			if(null!=bor.getBorderStyle()){
				if(bor.getBorderStyle().equals("sunken")){
					s.append("border-style:").append("inset").append(";");
				}
				if(bor.getBorderStyle().equals("rised")){
					s.append("border-style:").append("outset").append(";");
				}
			}
		}
		// SizeAndPosition si = (SizeAndPosition) map.get("sizeAndPosition");
		// s.append("left:").append(si.getLeft()).append(";");
		// s.append("width:").append(si.getWidth()).append(";");
		// s.append("height:").append(si.getHeight()).append(";");
		// s.append("top:").append(si.getTop()).append(";");
		// s.append("line-height:").append(si.getHeight()).append("pt;");
		// CssModelTextAlign te = (CssModelTextAlign) map.get("textAlign");
		// s.append(gb.getMap().get("text-align:")).append(te.getAlign()).append(
		// ";");
		s.append("}");
		// log.info(s.toString());
		return s.toString();
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
		CssModelComBoxModel ct = (CssModelComBoxModel) map.get("ComBoxModel");
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

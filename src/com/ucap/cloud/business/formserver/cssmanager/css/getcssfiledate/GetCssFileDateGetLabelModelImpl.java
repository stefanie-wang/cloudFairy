/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetLabelModelImpl.java
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
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelControlsType;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelFone;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelHints;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTextAlign;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetLabelModelImpl
 * @Description TODO <P>解析idf中所有的lable控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetLabelModelImpl implements CssUntilGetAllModel {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateGetLabelModelImpl() {

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
	 *  通过控件类型调用对应的方法
	 */
	private GetCssFileDateReflexMoth rm = new GetCssFileDateReflexMoth();

	public GetCssFileDateReflexMoth getRm() {
		return rm;
	}

	public void setRm(GetCssFileDateReflexMoth rm) {
		this.rm = rm;
	}
    /**
     *  控件验证信息
     */
	private GetCssFileDateResControsType rc = new GetCssFileDateResControsType();

	public GetCssFileDateResControsType getRc() {
		return rc;
	}

	public void setRc(GetCssFileDateResControsType rc) {
		this.rc = rc;
	}
    /**
     *   css样式模型
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
		List<Element> aelement = e.elements();
		if (aelement != null && aelement.size() > 0) {
			for (int i = 0; i < aelement.size(); i++) {
				Element ee = aelement.get(i);
				// label中的类型 text
				if (ee.getName().equals("text")) {
					// 控件的验证类型 如input 文本类型（TextData）验证
					String dataType = ee.attributeValue("dataType");
					ct.setDatetype(dataType);
					// 控件的验证信息 typenme(控件的name属性 类似ID 唯一的)与类型中验证信息
					Map<String, List<Map<String, String>>> map = rm.getMethod(
							typenme, controlsname, rc, ee);
					ct.setProve(map);
					mapkongjian.put("controlstype", ct);
				}
				// 控件的样式
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
	 * 生成css样式的字符串
	 * 
	 * @param e
	 *            要处理的某一节点
	 * @return 单个控件的Css样式
	 * @throws Exception
	 */
	public String getStringCss(Element e) throws Exception {
		StringBuilder s = new StringBuilder();
		if(iftrue.getobj(e)){
			return s.toString();
		}
		Map<String, Object> map = this.getModel(e);
		// 此类包括了控件的类型，类型名称以及判断
		CssModelControlsType ct = (CssModelControlsType) map
				.get("controlstype");
		s.append(" #" + "label_" + ct.getTypename()); // 控件属性名称 input中name属性的值
														// 也是ID属性
		s.append(" { ");
		// 页面背景属性
		/* CssModelBackGround bc = (CssModelBackGround) map.get("backGround");
		 s.append(gb.getMap().get("background-color:")).append(bc.getFillColor()).append(";");*/
	    // 颜色
		// s.append("background-image:").append(bc.getImageFile()).append(";");
		// //背景图片
		// 设置边框样式 此控件全部解析
		CssModelBorders br = (CssModelBorders) map.get("borders");
		// s.append(br.getBorderStyle());
		if (gb.getMap().get(br.getBorderSize()) != null) {
			s.append(gb.getMap().get(br.getBorderSize()));
		}
		s.append("border-color:").append(br.getBorderColor()).append(";");
		if (Integer.valueOf(br.getTop()) != 0) {
			s.append(gb.getMap().get("border-width:")).append(
					br.getBorderSize()).append("");
		} else {
			s.append(gb.getMap().get("border-width:")).append("0");
		}
		if (Integer.valueOf(br.getRight()) != 0) {
			s.append(" ").append(br.getBorderSize());
		} else {
			s.append(" 0");
		}
		if (Integer.valueOf(br.getBottom()) != 0) {
			s.append(" ").append(br.getBorderSize());
		} else {
			s.append(" 0");
		}
		if (Integer.valueOf(br.getLeft()) != 0) {
			s.append(" ").append(br.getBorderSize()).append("px ;");
		} else {
			s.append(" 0px ;");
		}
		// 文本字体的
		CssModelFone fo = (CssModelFone) map.get("font");
		s.append(gb.getMap().get("font-family:")).append(fo.getFontFamily())
				.append(";");
		s.append(gb.getMap().get("color:")).append(fo.getFontColor()).append(
				";");
		s.append(gb.getMap().get("font-size:")).append(fo.getFontSize())
				.append("pt").append(";");
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
		// 控件坐标 此控件样式解决
		/* SizeAndPosition si = (SizeAndPosition) map.get("sizeAndPosition");
		 s.append("left:").append(si.getLeft()).append(";");
		 s.append("width:").append(si.getWidth()).append(";");
		 s.append("height:").append(si.getHeight()).append(";");
		 s.append("top:").append(si.getTop()).append(";");
		 s.append("line-height:").append(si.getHeight()).append("pt;");*/
		// 文本段落
		CssModelTextAlign te = (CssModelTextAlign) map.get("textAlign");
		s.append(gb.getMap().get("text-align:")).append(te.getAlign()).append(
				";");
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

/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetListModelImpl.java
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
 * @ClassName GetCssFileDateGetListModelImpl
 * @Description TODO <P>解析idf中所有的list控件并生成css样式</P>
 * @author  piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetListModelImpl implements CssUntilGetAllModel {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateGetListModelImpl() {

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
     *   css样式模型
     *  
     */
	private CssModelGetCssModel gb = new CssModelGetCssModel();

	/**
	 * 获取单个控件中的Css样式的所有属性值
	 * 
	 * @param e
	 *            要是处理的某一节点
	 * @return map模型
	 */
	public Map<String, Object> getModel(Element e) {

		Map<String, Object> mapkongjian = new HashMap<String, Object>();
		if(iftrue.getobj(e)){
			return mapkongjian;
		}
		// 控件类型名称 如 input button
		String controlsname = e.getName();
		String typenme = e.attributeValue("name");
		CssModelComBoxModel cb = new CssModelComBoxModel();
		cb.setContname(typenme);// //属性名称 如input 中name属性 也是ID
		cb.setTypename(controlsname);// //控件类型名称 input
		List<Element> aelement = e.elements();
		if (aelement != null && aelement.size() > 0) {
			for (int i = 0; i < aelement.size(); i++) {
				Element ee = aelement.get(i);
				// label中的类型 text
				if (ee.getName().equals("items")) {
					// 控件的验证类型 如input 文本类型（TextData）验证
					String itemType = ee.attributeValue("itemType"); // <items
					// itemType="inputData"
					// srcName=""/>
					String srcName = ee.attributeValue("srcName");
					cb.setItemType(itemType);
					cb.setSreName(srcName);
					// 控件的验证信息 typenme(控件的name属性 类似ID 唯一的)与类型中验证信息
					GetCssFileDateResControsType rct = new GetCssFileDateResControsType();
					// 下拉框的选项值
					Map<String, List<List<Map<String, String>>>> map = rct
							.getlist(typenme, ee);
					cb.setMap(map);
					mapkongjian.put("ComBoxModel", cb);
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
		StringBuilder s = new StringBuilder("");
		if(iftrue.getobj(e)){
			return s.toString();
		}
		Map<String, Object> map = this.getModel(e);
		// 此类包括了控件的类型，类型名称以及判断
		CssModelComBoxModel ct = (CssModelComBoxModel) map.get("ComBoxModel");
		s.append(" #" + ct.getContname()); // 控件属性名称 input中name属性的值 也是ID属性
		s.append(" {");
		// 页面背景属性
		/* <backGround imageFile="" transparent="" fillStyle=""
		 fillColor="#ffffff" lineColor="#000000"/>
		 CssModelBackGround bc = (CssModelBackGround) map.get("backGround");
		 s.append(gb.getMap().get("background-color:")).append(bc.getFillColor()).append(";");
		 // 颜色
		 文本字体的
		 <font fontFamily="宋体" fontSize="12.001" bold="0" italic="0"
		 underline="0" strikeout="0" fontColor="#000000"/>*/
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
		// 控件坐标 此控件样式解决
	/*	 SizeAndPosition si = (SizeAndPosition) map.get("sizeAndPosition");
		 s.append("left:").append(si.getLeft()).append(";");
		 s.append("width:").append(si.getWidth()).append(";");
		 s.append("height:").append(si.getHeight()).append(";");
		 s.append("top:").append(si.getTop()).append(";");
		 s.append("line-height:").append(si.getHeight()).append("pt;");*/
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

/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelGetCssModel.java
 * @Description TODO 解析控件的整体模型
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.ucap.cloud.builder.model.ModelRoot;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilfinelPath;

/**
 * @ClassName ${CssModelGetCssModel}
 * @Description TODO
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelGetCssModel implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	public CssModelGetCssModel() {

	}
	/**
	 * <p>将xml中的文件保存到model中</p>
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 背景颜色model
	 */
	public CssModelBackGround getCss(Element css) {
		CssModelBackGround bc = new CssModelBackGround();
		if(css!=null){
			String imageFile = css.attributeValue("imageFile");
			String transparent = css.attributeValue("transparent");
			String fillStyle = css.attributeValue("fillStyle");
			String fillColor = css.attributeValue("fillColor");
			String lineColor = css.attributeValue("lineColor");
			bc.setFillColor(fillColor);
			bc.setImageFile(imageFile);
			bc.setTransparent(transparent);
			bc.setFillStyle(fillStyle);
			bc.setLineColor(lineColor);
			return bc;
		}else{
			return null;
		}
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 边界model
	 */
	public CssModelBorders getborderscss(Element css) {
		CssModelBorders bo = new CssModelBorders();
		if(css!=null){
			String borderSize = css.attributeValue("borderSize");
			String borderStyle = css.attributeValue("borderStyle");
			String borderColor = css.attributeValue("borderColor");
			String top = css.attributeValue("top");
			String right = css.attributeValue("right");
			String bottom = css.attributeValue("bottom");
			String left = css.attributeValue("left");
			bo.setBorderSize(borderSize);
			bo.setBorderStyle(borderStyle);
			bo.setBorderColor(borderColor);
			bo.setTop(top);
			bo.setRight(right);
			bo.setBottom(bottom);
			bo.setLeft(left);
			return bo;
		}else{
			return null;
		}
	
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 字体model
	 */
	public CssModelFone getfonecss(Element css) {
		CssModelFone fo = new CssModelFone();
		if(css!=null){
			String fontFamily = css.attributeValue("fontFamily");
			String fontSize = css.attributeValue("fontSize");
			String bold = css.attributeValue("bold");
			String italic = css.attributeValue("italic");
			String underline = css.attributeValue("underline");
			String strikeout = css.attributeValue("strikeout");
			String fontColor = css.attributeValue("fontColor");
			fo.setFontFamily(fontFamily);
			fo.setFontSize(fontSize);
			fo.setBold(bold);
			fo.setItalic(italic);
			fo.setUnderline(underline);
			fo.setStrikeout(strikeout);
			fo.setFontColor(fontColor);
			return fo;
		}else{
			return null;
		}
		
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 帮助model
	 */
	public CssModelHints gethintscss(Element css) {
		CssModelHints hi = new CssModelHints();
		if(css!=null ){
			String tips = css.attributeValue("tips");
			String display = css.attributeValue("display");
			String helpMessage = css.attributeValue("helpMessage");
			hi.setDisplay(display);
			hi.setHelpMessage(helpMessage);
			hi.setTips(tips);
			return hi;
		}else{
			return null;
		}
		
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 布局model
	 */
	public CssModelSizeAndPosition getsizeandposition(Element css) {
		CssModelSizeAndPosition si = new CssModelSizeAndPosition();
		if(css!=null){
			String left = css.attributeValue("left");
			String top = css.attributeValue("top");
			String width = css.attributeValue("width");
			String height = css.attributeValue("height");
			si.setLeft(left);
			si.setHeight(height);
			si.setTop(top);
			si.setWidth(width);
			return si;
		}else{
			return null;
		}
		
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 段落布局model
	 */
	public CssModelTextAlign gettextalign(Element css) {
		CssModelTextAlign ts = new CssModelTextAlign();
		if(css!=null){
			String align = css.attributeValue("align");
			String valign = css.attributeValue("valign");
			ts.setAlign(align);
			ts.setValign(valign);
			return ts;
		}else{
			return null;
		}
		
	}

	/**
	 * 将xml中的文件保存到model中
	 * 
	 * @param css
	 *            要处理的节点
	 * @return 直线model
	 */
	public CssModelLineModel getLine(Element css) {
		CssModelLineModel lm = new CssModelLineModel();
		if(css!=null){
			lm.setForeColor(css.attributeValue("foreColor"));
			lm.setLineDirection(css.attributeValue("LineDirection"));
			lm.setLineStyle(css.attributeValue("lineStyle"));
			lm.setPrintable(css.attributeValue("printable"));
			lm.setThickness(css.attributeValue("thickness"));
			return lm;
		}else{
			return null;
		}
		
	}

	/**
	 * 解析xml css样式对应值
	 * 
	 * @return css样式
	 * @throws Exception
	 *             异常
	 */
	public Map<String, String> getMap() throws Exception {
		SAXReader reader = new SAXReader();
		reader
				.setFeature(
						"http://apache.org/xml/features/nonvalidating/load-external-dtd",
						false);
		String filepath = CssUntilfinelPath.CSSPATH;
		Document doc = reader.read(new File(filepath));
		Element e = doc.getRootElement();
		Map<String, String> map = new HashMap<String, String>();
		List<Element> list = e.elements();
		for (int i = 0; i < list.size(); i++) {
			Element el = list.get(i);
			String key = el.attributeValue("key");
			String value = el.attributeValue("value");
			map.put(key, value);
		}
		return map;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetTableModle.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelFone;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTableColumnsModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelTableModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetTableModle
 * @Description TODO <P>解析idf中所有的Table控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetTableModle {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
    
	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public GetCssFileDateGetTableModle() {

	}
	/**
	 * 
	 * @param e
	 *            要处理的节点
	 * @return 返回table模型
	 */
	public CssModelTableModel getModel(Element e) {

		CssModelTableModel tb = new CssModelTableModel();
		if(e!=null){
			List<Element> listtablecon = e.elements();
			for (Element ee : listtablecon) {
				if (ee.getName().equals("name")) {
					tb.setName(ee.getText());
				} else if (ee.getName().equals("groupId")) {
					tb.setGroupId(ee.getText());
				} else if (ee.getName().equals("colsNum")) {
					tb.setColsNum(Integer.valueOf(ee.getText()));
				} else if (ee.getName().equals("rowsNum")) {
					tb.setRowsNum(Integer.valueOf(ee.getText()));
				} else if (ee.getName().equals("displayTitle")) {
					tb.setDisplayTitle(ee.getText());
				} else if (ee.getName().equals("rowHeight")) {
					tb.setRowHeight(ee.getText());
				} else if (ee.getName().equals("oddRowBgcolor")) {
					tb.setOddRowBgcolor(ee.getText());
				} else if (ee.getName().equals("titleRowBgcolor")) {
					tb.setTitleRowBgcolor(ee.getText());
				} else if (ee.getName().equals("evenRowBgcolor")) {
					tb.setEvenRowBgcolor(ee.getText());
				} else if (ee.getName().equals("borderColor")) {
					tb.setBorderColor(ee.getText());
				} else if (ee.getName().equals("borderSize")) {
					tb.setBorderSize(ee.getText());
				} else if (ee.getName().equals("cellPadding")) {
					tb.setCellPadding(ee.getText());
				} else if (ee.getName().equals("cellSpace")) {
					tb.setCellSpace(ee.getText());
				} else if (ee.getName().equals("titleHeigth")) {
					tb.setTitleHeigth(ee.getText());
				} else if (ee.getName().equals("appearance")) {
					List<Element> appear = ee.elements();
					CssModelSizeAndPosition si = new CssModelSizeAndPosition();
					si.setHeight(appear.get(0).attributeValue("height"));
					si.setLeft(appear.get(0).attributeValue("left"));
					si.setTop(appear.get(0).attributeValue("top"));
					si.setWidth(appear.get(0).attributeValue("width"));
					tb.setSizeAndPos(si);
				} else if (ee.getName().equals("columns")) {
					// table下面行的集合
					List<CssModelTableColumnsModel> listcolumn = new ArrayList<CssModelTableColumnsModel>();
					List<Element> listcolums = ee.elements();
					// 循环列的次数
					for (Element ecel : listcolums) {
						CssModelTableColumnsModel tablecol = new CssModelTableColumnsModel();
						// String columleft = ecel.attributeValue("left");
						List<Element> listcolum = ecel.elements(); // column下面的节点
						for (Element ecom : listcolum) {
							if (ecom.getName().equals("colName")) {
								tablecol.setColName(ecom.getText());
							} else if (ecom.getName().equals("title")) {
								tablecol.setTitle(ecom.getText());
							} else if (ecom.getName().equals("colWidth")) {
								tablecol.setColWidth(ecom.getText());
							} else if (ecom.getName().equals("bgcolor")) {
								tablecol.setBgcolor(ecom.getText());
							} else if (ecom.getName().equals("lncolor")) {
								tablecol.setLncolor(ecom.getText());
							} else if (ecom.getName().equals("align")) {
								tablecol.setAlign(ecom.getText());
							} else if (ecom.getName().equals("valign")) {
								tablecol.setValign(ecom.getText());
							} else if (ecom.getName().equals("fullFill")) {
								tablecol.setFullFill(ecom.getText());
							} else if (ecom.getName().equals("font")) {
								CssModelFone fon = new CssModelFone();
								fon.setBold(ecom.attributeValue("fontFamily"));
								fon.setFontColor(ecom.attributeValue("fontColor"));
								fon.setFontSize(ecom.attributeValue("fontSize"));
								fon.setBold(ecom.attributeValue("bold"));
								fon.setItalic(ecom.attributeValue("italic"));
								fon.setUnderline(ecom.attributeValue("underline"));
								fon.setStrikeout(ecom.attributeValue("strikeout"));
								tablecol.setFone(fon);
							}
						}
						listcolumn.add(tablecol);
						tb.setTcemolist(listcolumn);
					}
				}
			}
			return tb;
		}else{
			return tb;
		}
	}

	/**
	 * 
	 * @param e
	 *            要处理的节点
	 * @return 将table模型的css拆分成多个css样式
	 */
	public List<String> getStringCss(Element e) {
		List<String> list = new ArrayList<String>();
		StringBuilder s = new StringBuilder();
		if(e!=null){
			CssModelTableModel tb = this.getModel(e); // 单个table
			// List<TableColumnsModel> tclist = tb.getTcemolist(); //每个table的列数
			s.append(" #").append(tb.getName()).append(" { ");
			s.append("position:absolute;");
			// SizeAndPosition si = tb.getSizeAndPos();
			// s.append("left:").append(si.getLeft()).append(";");
			// s.append("width:").append(si.getWidth()).append(";");
			// s.append("height:").append(si.getHeight()).append(";");
			// s.append("top:").append(si.getTop()).append(";");
			s.append("border-collapse:collapse;");
			s.append("}");
			list.add(s.toString());
			List<CssModelTableColumnsModel> coulist = tb.getTcemolist();
			// table的第一行
			for (int k = 0; k < coulist.size(); k++) {
				CssModelTableColumnsModel tm = coulist.get(k);
				StringBuilder s1 = new StringBuilder();
				s1.append(" #").append(tb.getName()).append("_td").append(k)
						.append(" {");
				s1.append("height:").append(
						Integer.valueOf(tb.getRowHeight())
								- Integer.valueOf(tb.getBorderSize())).append(";");
				s1.append("width:").append(tm.getColWidth()).append(";");
				s1.append("}");
				list.add(s1.toString());
			}
			// log.info(s.toString());
			return list;
		}else{
			return list;
		}
		
	}
}

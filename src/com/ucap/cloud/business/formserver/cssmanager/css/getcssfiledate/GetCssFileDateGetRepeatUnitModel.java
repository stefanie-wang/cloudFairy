/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetRepeatUnitModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBackGround;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelBorders;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelFone;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelRepeatAreaModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelRepeatTitleModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelRepeatUnitModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetRepeatUnitModel
 * @Description TODO <P>解析idf中所以有的repeatUnit控件并生成css样式</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetRepeatUnitModel {

	public GetCssFileDateGetRepeatUnitModel() {

	}
	/**
	 *  判断参数是否为空
	 */
    private Ifboolean iftrue = new Ifboolean();
	public Ifboolean getIftrue() {
		return iftrue;
	}

	public void setIftrue(Ifboolean iftrue) {
		this.iftrue = iftrue;
	}
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
	/**
	 * 获取css样式model类
	 */
	private CssModelGetCssModel gb = new CssModelGetCssModel();

	public CssModelGetCssModel getGb() {
		return gb;
	}

	public void setGb(CssModelGetCssModel gb) {
		this.gb = gb;
	}

	/**
	 * @Title: getMode
	 * @Description: TODO
	 * @param ee
	 *            要处理的某一节点
	 * @return CssModelRepeatUnitModel  返回重复表的模型
	 * @throws
	 */
	public CssModelRepeatUnitModel getMode(Element ee) {

		CssModelRepeatUnitModel repeatmodel = new CssModelRepeatUnitModel(); // 每个重复快模型
		if(iftrue.getobj(ee)){
			return repeatmodel;
		}
		//给重复块设置属性值
		repeatmodel.setName(ee.attributeValue("name"));
		repeatmodel.setFixHeight(ee.attributeValue("fixHeight"));
		repeatmodel.setGroupId(ee.attributeValue("groupId"));
		repeatmodel.setPrintable(ee.attributeValue("printable"));
		repeatmodel.setShowTitle(ee.attributeValue("showTitle"));
		repeatmodel.setTitleHeight(ee.attributeValue("titleHeight"));
		repeatmodel.setDescribe(ee.attributeValue("describe"));
		repeatmodel.setHidden(ee.attributeValue("hidden"));
		repeatmodel.setSeqAreaWidth(ee.attributeValue("seqAreaWidth"));
		repeatmodel.setShowSeq(ee.attributeValue("showSeq"));
		repeatmodel.setTabIndex(ee.attributeValue("tabIndex"));
		repeatmodel.setRefHeader(ee.attributeValue("refHeader"));
		repeatmodel.setDisable(ee.attributeValue("disable"));
		repeatmodel.setFixRowNum(ee.attributeValue("fixRowNum"));
		repeatmodel.setMaxRowsCount(ee.attributeValue("maxRowsCount"));
		repeatmodel.setAllowPageBreaks(ee.attributeValue("allowPageBreaks"));
		repeatmodel
				.setAllowHeaderRepeat(ee.attributeValue("allowHeaderRepeat"));
		repeatmodel.setDelBlankLine(ee.attributeValue("DelBlankLine"));
		repeatmodel.setRowNum(ee.attributeValue("rowNum"));
		List<CssModelRepeatAreaModel> listarea = new ArrayList<CssModelRepeatAreaModel>();// 每个重复快中的重复域集合
		List<CssModelRepeatTitleModel> listtitle = new ArrayList<CssModelRepeatTitleModel>();
		List<Element> elemenlist = ee.elements();// 每个重复块下面的所有空间
		for (int i = 0; i < elemenlist.size(); i++) {
			Element ename = elemenlist.get(i);// 重复块下面的控件
			if (ename.getName().equals("sizeAndPosition")) {
				CssModelSizeAndPosition si = gb.getsizeandposition(ename);
				repeatmodel.setSizwand(si);
			}
			if (ename.getName().equals("repeatAreas")) {
				List<Element> repeatAreaslist = ename.elements();// repeatAreas下面的repeatArea集合
				for (Element re : repeatAreaslist) {
					CssModelRepeatAreaModel reareamodel = new CssModelRepeatAreaModel();
					if (re.getName().equals("repeatArea")) {
						List<Element> applist = re.elements();
						Element earea = applist.get(0);// appearance节点
						List<Element> listee = earea.elements();
						for (int j = 0; j < listee.size(); j++) {
							Element css = listee.get(j);
							if (css.getName().equals("sizeAndPosition")) {
								CssModelSizeAndPosition si = gb
										.getsizeandposition(css);
								reareamodel.setSize(si);
							} else if (css.getName().equals("backGround")) {
								CssModelBackGround bc = gb.getCss(css);
								reareamodel.setBcakg(bc);
							} else if (css.getName().equals("borders")) {
								CssModelBorders bo = gb.getborderscss(css);
								reareamodel.setBor(bo);
							}
						}
						listarea.add(reareamodel);
					}
				}
				repeatmodel.setRemodellist(listarea);
			} else if (ename.getName().equals("repeatTitles")) {
				List<Element> tielist = ename.elements();// 每个重复快下面title的集合
				for (Element elist : tielist) {
					CssModelRepeatTitleModel rm = new CssModelRepeatTitleModel();
					if (elist.getName().equals("repeatTitle")) {
						List<Element> listere = elist.elements(); // repeatTitle下面的控件集合
						Element e1 = listere.get(0);// repeatTitle下面只有一个appearance
						List<Element> liste2 = e1.elements();// appearance下面的样式
						for (int kk = 0; kk < liste2.size(); kk++) {
							Element css = liste2.get(kk);
							if (css.getName().equals("sizeAndPosition")) {
								CssModelSizeAndPosition si = gb
										.getsizeandposition(css);
								rm.setSize(si);
							} else if (css.getName().equals("backGround")) {
								CssModelBackGround bc = gb.getCss(css);
								rm.setBcakg(bc);
							} else if (css.getName().equals("borders")) {
								CssModelBorders bo = gb.getborderscss(css);
								rm.setBor(bo);
							} else if (css.getName().equals("font")) {
								CssModelFone bo = gb.getfonecss(css);
								rm.setFone(bo);
							}
						}
					}
					listtitle.add(rm);
				}
			}
			repeatmodel.setTitleList(listtitle);
		}
		return repeatmodel;
	}

	/**
	 * 总数
	 * 
	 * @param e
	 * @return List 返回所有重复表控件总数
	 */
	public List<String> getStringCss(Element e) {

		List<String> list = new ArrayList<String>();
		if(iftrue.getobj(e)){
			return list;
		}
		CssModelRepeatUnitModel repeatunit = this.getMode(e);// 每一页的重复块的总和
		StringBuilder s = new StringBuilder();
		// 重复快的大table
		s.append("#").append(repeatunit.getName()).append("_table { ");
		s
				.append("overflow:hidden;position:absolute;table-layout:fixed; border-collapse:collapse;border-style: none;}");
	/*	 s.append("top:").append(repeatunit.getSizwand().getTop()).append(";");
		 s.append("left:").append(repeatunit.getSizwand().getLeft()).append(";");
		 s.append("width:").append(Integer.valueOf(repeatunit.getSizwand().getWidth())+1).append(";");
		 s.append("height:").append(repeatunit.getSizwand().getHeight()).append(";").append("}");*/
		list.add(s.toString());
		// 第一行第一列
		StringBuilder s1 = new StringBuilder();
		s1.append("#").append(repeatunit.getName()).append("_table_td1{ ");
		s1.append("height:").append(
				Integer.valueOf(repeatunit.getTitleHeight())
						- Integer.valueOf(repeatunit.getTitleList().get(0)
								.getBor().getBorderSize())).append("px ;");
		s1.append("width:").append(
				Integer.valueOf(repeatunit.getSeqAreaWidth())
						- Integer.valueOf(repeatunit.getTitleList().get(0)
								.getBor().getBorderSize())).append("px ;");
		s1.append("}");
		list.add(s1.toString());
		// 第二行第一列
		StringBuilder s2 = new StringBuilder();
		s2.append("#").append(repeatunit.getName()).append("_table_td2{ ");
		s2.append("height:").append(
				Integer.valueOf(Integer.valueOf(repeatunit.getRemodellist()
						.get(0).getSize().getHeight()))
						- Integer.valueOf(repeatunit.getTitleList().get(0)
								.getBor().getBorderSize())).append("px ;");
		s2.append("width:").append(
				Integer.valueOf(repeatunit.getSeqAreaWidth())
						- Integer.valueOf(repeatunit.getTitleList().get(0)
								.getBor().getBorderSize())).append("px ;");
		s2.append("}");
		list.add(s2.toString());
		// 开始处理title
		List<CssModelRepeatTitleModel> listtile = repeatunit.getTitleList();
		if (listtile.size() > 1) { // 当有多个title的时候，用table表示
			StringBuilder s3 = new StringBuilder();
			s3.append("#").append(repeatunit.getName()).append(
					"_table_title { ");
			s3
					.append("overflow:hidden;position:absolute;table-layout:fixed; border-collapse:collapse;border-style: none; }");
			list.add(s3.toString());
			for (int k = 0; k < listtile.size(); k++) {
				// table 中的td
				if (k == listtile.size() - 1) {
					StringBuilder s4 = new StringBuilder();
					s4.append("#").append(repeatunit.getName()).append(
							"_table_title_td").append(k).append("{ }");
				/*	 s4.append("left:").append(Integer.valueOf(repeatunit.getTitleList().get(k).getSize().getLeft())+1).append("px ;");
					 s4.append("top:").append("0 px ;");
					 s4.append("width:").append(Integer.valueOf(Integer.valueOf(repeatunit.getTitleList().get(k).getSize().getWidth()))).append("px ;");
					 s4.append("height:").append(repeatunit.getTitleList().get(k).getSize().getHeight()).append("px ; }");*/
					list.add(s4.toString());
				} else {
					StringBuilder s5 = new StringBuilder();
					s5.append("#").append(repeatunit.getName()).append(
							"_table_title_td").append(k).append("{ }");
				/*	 s5.append("left:").append(repeatunit.getTitleList().get(k).getSize().getLeft()).append("px ;");
					 s5.append("top:").append("0 px ;");
					 s5.append("width:").append(Integer.valueOf(Integer.valueOf(repeatunit.getTitleList().get(k).getSize().getWidth())+1)).append("px ;");
					 s5.append("height:").append(repeatunit.getTitleList().get(k).getSize().getHeight()).append("px ; }");*/
					list.add(s5.toString());
				}
			}
		} else {
		}
		// title结束
		// 重复块 area
		List<CssModelRepeatAreaModel> listmodel = repeatunit.getRemodellist();
		if (listmodel.size() > 1) {
			StringBuilder s6 = new StringBuilder();
			s6.append("#").append(repeatunit.getName())
					.append("_table_area { ");
			s6
					.append("overflow:hidden;position:absolute;table-layout:fixed; border-collapse:collapse;border-style: none; }");
			list.add(s6.toString());
			for (int k = 0; k < listmodel.size(); k++) {
				if (k == listtile.size() - 1) {
					StringBuilder s7 = new StringBuilder();
					s7.append("#").append(repeatunit.getName()).append(
							"_table_area_td").append(k).append("{ }");
					/* s7.append("left:").append(Integer.valueOf(repeatunit.getRemodellist().get(k).getSize().getLeft())+1).append("px ;");
					 s7.append("top:").append("0 px ;");
					 s7.append("width:").append(Integer.valueOf(Integer.valueOf(repeatunit.getRemodellist().get(k).getSize().getWidth()))).append("px ;");
					 s7.append("height:").append(repeatunit.getRemodellist().get(k).getSize().getHeight()).append("px ; }");*/
					list.add(s7.toString());
				} else {
					StringBuilder s8 = new StringBuilder();
					s8.append("#").append(repeatunit.getName()).append(
							"_table_area_td").append(k).append("{ }");
				/*	 s8.append("left:").append(repeatunit.getRemodellist().get(k).getSize().getLeft()).append("px ;");
					 s8.append("top:").append("0 px ;");
					 s8.append("width:").append(Integer.valueOf(Integer.valueOf(repeatunit.getRemodellist().get(k).getSize().getWidth())+1)).append("px ;");
					 s8.append("height:").append(repeatunit.getRemodellist().get(k).getSize().getHeight()).append("px ; }");*/
					list.add(s8.toString());
				}
			}
		}
		// log.info(s.toString());
		return list;
	}
}

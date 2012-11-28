package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

/**
 * @ClassName CssUntilGetGridImpl
 * @Description TODO 解析idf文件中的表格片段
 * @author pzg
 * @date 2012-8-31
 */
public class CssUntilGetGridImpl implements CssUntilGetGrid,CssUntilGetModel {

	public CssUntilGetGridImpl(){
	}
	/**
	 * 获取所有需要进行解析的具体类对象
	 */
	private Map<String, CssUntilGetAllModel> gridmap ;
	public Map<String, CssUntilGetAllModel> getGridmap() {
		return gridmap;
	}
	public void setGridmap(Map<String, CssUntilGetAllModel> gridmap) {
		this.gridmap = gridmap;
	}
	/**
	 * 
	 * @param e 表格节点
	 * @return  返回所以表格内的控件的css内容
	 * @throws Exception 
	 */
	@Override
	public List<String> getBigControls(Element controlsson,CssUntilParseXML parsexml) throws Exception {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		List<Element> listgrid = controlsson.elements();
		for (int jj = 0; jj < listgrid.size();jj ++) {
			if (listgrid.get(jj).getName().equals("cells")) {
				List<Element> listgridCell = listgrid.get(jj)
				.elements();
				for (int k = 0; k < listgridCell.size(); k++) {
					Element elegridCell = listgridCell.get(k);
					if (elegridCell.getName().equals("gridCell")) {
						list.add(this.gridmap
								.get(elegridCell.getName())
								.getStringCss(elegridCell));
						List<Element> listgriCessson = elegridCell
						.elements();
						for (int jk = 0; jk < listgriCessson.size(); jk++) {
							Element ee = listgriCessson.get(jk);
							/**
							 * 表格下面的controls
							 */
							if (ee.getName().equals("controls")) {
								List<Element> listgridcontrols = ee
								.elements();
								for (int gridc = 0; gridc < listgridcontrols
								.size(); gridc++) {
									Element elegridson = listgridcontrols
									.get(gridc);
									String gridkey = elegridson
									.getName();
									parsexml.getinput(elegridson);
									if (null != this.gridmap
											.get(gridkey)) {
										// 关联数据
										list
										.add(this.gridmap
												.get(
														gridkey)
														.getStringCss(
																elegridson));
									}
								}
							}
						}
					}
				}
			}
		}
		return list;
	}

}

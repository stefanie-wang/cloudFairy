/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetSortCss.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSameCssModel;

/**
 * @ClassName GetCssFileDateGetSortCss
 * @Description TODO <P>将idf解析后的内容生成css样式，并将单个css样式内容相同的划分到一类中</P>
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateGetSortCss {


	private static  Logger log = Logger.getLogger(GetCssFileDateGetSortCss.class);

	/** 
	* <p>Title: </p> 
	* <p>Description: </p>  
	*/
	public GetCssFileDateGetSortCss() {

	}

	/**
	 * @param list
	 *            所有控件的集合
	 * @return 返回分类后的集合
	 */
	@SuppressWarnings("unchecked")
	public List<String> getsotrcss(List<String> list) {

		List<String> bileList = new ArrayList<String>();
		Map<CssModelSameCssModel, String> map = new HashMap<CssModelSameCssModel, String>();
		for (int i = 0; i < list.size(); i++) {
			String s[] = list.get(i).split("\\{");
			CssModelSameCssModel scm = new CssModelSameCssModel();
			if(s.length>2){
				scm.setValue(s[1].trim());
			}
			
			scm.setCssID(s[0].trim());
			StringBuffer sb = new StringBuffer();
			sb.append(map.get(scm)).append(",");
			sb.append(s[0]);
			if (map.containsKey(scm)) {
				map.put(scm, sb.toString());
			} else {
				map.put(scm, s[0]);
			}
		}
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			StringBuffer css = new StringBuffer();
			Map.Entry entry = (Map.Entry) it.next();
			CssModelSameCssModel key = (CssModelSameCssModel) entry.getKey();
			String str = map.get(key).trim();
			String ss[] = str.split(",");
			if (ss.length > 1) {
				css.append("#");
				for (int j = 0; j < ss.length; j++) {
					if(ss[j].split("#").length>2){


						String cssname = ss[j].split("#")[1];
						if (j == ss.length - 1) {
							css.append("#" + cssname);
						} else {
							css.append("#" + cssname).append(",");
						}
					}
				}
			} else {
				css.append(str);
			}
			css.append("{").append(key.getValue()).append("");

			bileList.add(css.toString());
		}
		log.info(map);
		return bileList;
	}
}

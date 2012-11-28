/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateGetRectangleModelImpl.java
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
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelGetCssModel;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.CssModelSizeAndPosition;
import com.ucap.cloud.business.formserver.cssmanager.css.until.CssUntilGetAllModel;
import com.ucap.cloud.business.formserver.cssmanager.css.until.Ifboolean;

/**
 * @ClassName GetCssFileDateGetRectangleModelImpl
 * @Description TODO <P>解析idf中所有的rectang控件并生成css样式</P>
 * @author pzg
 * @date 2012-8-10
 */
public class GetCssFileDateGetRectangleModelImpl implements CssUntilGetAllModel {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());
    /**
     *   css样式模型
     */
	private CssModelGetCssModel gb = new CssModelGetCssModel();
	/**
	 * 判断参数是否为空
	 */
    private Ifboolean iftrue;
	public Ifboolean getIftrue() {
		return iftrue;
	}

	public void setIftrue(Ifboolean iftrue) {
		this.iftrue = iftrue;
	}

	/**
	 * 
	 * @param e
	 *            要操作的节点
	 * @return 返回map模型
	 */
	public Map<String, Object> getModel(Element e) {
		Map<String, Object> mapkongjian = new HashMap<String, Object>();
		if(iftrue.getobj(e)){
			return mapkongjian;
		}
		if (e.getName().equals("rectangle")) {
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
								} else if (css.getName().equals(
										"sizeAndPosition")) {
									CssModelSizeAndPosition si = gb
											.getsizeandposition(css);
									mapkongjian.put("sizeAndPosition", si);
								}
							}
						}
					}
				}
			}
		}
		return mapkongjian;
	}

	public String getStringCss(Element e) {

		return "";
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
		return "";
	}

	public GetCssFileDateGetRectangleModelImpl() {

	}

	public CssModelGetCssModel getGb() {
		return gb;
	}

	public void setGb(CssModelGetCssModel gb) {
		this.gb = gb;
	}

	private GetCssFileDateReflexMoth rm = new GetCssFileDateReflexMoth();

	public GetCssFileDateReflexMoth getRm() {
		return rm;
	}

	public void setRm(GetCssFileDateReflexMoth rm) {
		this.rm = rm;
	}

	private GetCssFileDateResControsType rc = new GetCssFileDateResControsType();

	public GetCssFileDateResControsType getRc() {
		return rc;
	}

	public void setRc(GetCssFileDateResControsType rc) {
		this.rc = rc;
	}
}

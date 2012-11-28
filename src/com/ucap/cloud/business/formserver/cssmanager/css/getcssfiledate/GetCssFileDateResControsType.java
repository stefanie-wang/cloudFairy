/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: GetCssFileDateResControsType.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate
 */
package com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;
import org.hibernate.proxy.map.MapLazyInitializer;

/**
 * @ClassName GetCssFileDateResControsType
 * @Description TODO 解析控件的验证信息
 * @author piaozg
 * @date 2012-8-10
 */
public class GetCssFileDateResControsType {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public GetCssFileDateResControsType() {

	}

	/**
	 * input框
	 * 
	 * @param datatype
	 * @param ele
	 * @return //类型与验证信息箱对应 此处类型表示TextData（文本） NumbericData（数字类型）
	 */
	public Map<String, List<Map<String, String>>> getinput(String datatype,
			Element ele) {
		// 类型与验证信息箱对应 此处类型表示TextData（文本） NumbericData（数字类型）
		Map<String, List<Map<String, String>>> mapprov = new HashMap<String, List<Map<String, String>>>();
		// 用map保存控件下面的验证信息，多个验证信息选项保存在一个list中
		List<Map<String, String>> maplist = new ArrayList<Map<String, String>>();
		if(ele!=null){
			List<Element> list = ele.elements();
			for (int i = 0; i < list.size(); i++) {
				Element e = list.get(i);
				// 文本类型
				if (datatype != null) {
					// 文本类型
					if (datatype.equals("TextData")) {
						// 类型key与value
						Map<String, String> map = new HashMap<String, String>();
						String allowCharacters = e
								.attributeValue("allowCharacters");
						String caseConversion = e.attributeValue("caseConversion");
						String multiLine = e.attributeValue("multiLine");
						String password = e.attributeValue("password");
						String minLength = e.attributeValue("minLength");
						String maxLength = e.attributeValue("maxLength");
						String autoTrim = e.attributeValue("autoTrim");
						String lineHeight = e.attributeValue("lineHeight");
						map.put("allowCharacters", allowCharacters);
						map.put("caseConversion", caseConversion);
						map.put("multiLine", multiLine);
						map.put("password", password);
						map.put("minLength", minLength);
						map.put("maxLength", maxLength);
						map.put("autoTrim", autoTrim);
						map.put("lineHeight", lineHeight);
						maplist.add(map);
						mapprov.put(datatype, maplist);
					}
					// 数字类型
					else if (datatype.equals("NumbericData")) {
						Map<String, String> map = new HashMap<String, String>();
						String currencySymbol = e.attributeValue("currencySymbol");
						String separatorAndDecimalStyle = e
								.attributeValue("separatorAndDecimalStyle");
						String appendMode = e.attributeValue("appendMode");
						String decimalPlaces = e.attributeValue("decimalPlaces");
						String minValue = e.attributeValue("minValue");
						String minInclude = e.attributeValue("minInclude");
						String maxValue = e.attributeValue("maxValue");
						String maxInclude = e.attributeValue("maxInclude");
						String isCalculate = e.attributeValue("isCalculate");
						map.put("currencySymbol", currencySymbol);
						map.put("separatorAndDecimalStyle",
								separatorAndDecimalStyle);
						map.put("appendMode", appendMode);
						map.put("decimalPlaces", decimalPlaces);
						map.put("minValue", minValue);
						map.put("minInclude", minInclude);
						map.put("maxValue", maxValue);
						map.put("isCalculate", isCalculate);
						map.put("maxInclude", maxInclude);
						maplist.add(map);
						mapprov.put(datatype, maplist);
					}
					// 日期类型
					else if (datatype.equals("DateData")) {
						Map<String, String> map = new HashMap<String, String>();
						String format = e.attributeValue("format");
						String beAfter = e.attributeValue("beAfter");
						String beBefore = e.attributeValue("beBefore");
						map.put("format", format);
						map.put("beAfter", beAfter);
						map.put("beBefore", beBefore);
						maplist.add(map);
						mapprov.put(datatype, maplist);
					} else if (datatype.equals("TimeData")) {
						Map<String, String> map = new HashMap<String, String>();
						String format = e.attributeValue("format");
						String beAfter = e.attributeValue("beAfter");
						String beBefore = e.attributeValue("beBefore");
						map.put("format", format);
						map.put("beAfter", beAfter);
						map.put("beBefore", beBefore);
						maplist.add(map);
						mapprov.put(datatype, maplist);
					} else if (datatype.equals("PatternData")) {

						Map<String, String> map = new HashMap<String, String>();
						String format = e.attributeValue("format");
						String hintMsg = e.attributeValue("hintMsg");
						map.put("format", format);
						map.put("hintMsg", hintMsg);
						maplist.add(map);
						mapprov.put(datatype, maplist);
					}
				}
			}
			return mapprov;
		}else{
			return mapprov;
		}
	
	}

	/**
	 * 标签
	 * 
	 * @param datatype
	 * @param ele
	 * @return //<text></text>value的集合
	 */
	public Map<String, List<Map<String, String>>> getlabel(String datatype,
			Element ele) {
		Map<String, List<Map<String, String>>> maplist = new HashMap<String, List<Map<String, String>>>();
		if(ele!=null){
			String value = ele.getText();
			// <text></text>value的集合 只有一个元素
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			// 控件名称（即控件ID）---集合对应
			Map<String, String> map = new HashMap<String, String>();
			// 将<text></text>的值 放入map中
			map.put("text", value);
			// list 中只有一个元素
			list.add(map);
			maplist.put(datatype, list);
			return maplist;
		}else{
			return maplist;
		}
		
	}

	/**
	 * \
	 * 
	 * @param controID
	 *            下拉框
	 * @param el
	 * @return 下拉框ID 与下拉框中的值对应
	 */
	public Map<String, List<List<Map<String, String>>>> getdropList(
			String controID, Element el) {
		/**
		 * 下拉框ID 与下拉框中的值对应
		 */
		Map<String, List<List<Map<String, String>>>> map = new HashMap<String, List<List<Map<String, String>>>>();
		if(el!=null){
			List<Element> liste = el.elements();
			// 单个下拉框中所有值
			List<List<Map<String, String>>> listmaplist = new ArrayList<List<Map<String, String>>>();
			// 下拉框中单个选项的key-value
			List<Map<String, String>> listmap = new ArrayList<Map<String, String>>();
			for (Element e : liste) {
				Map<String, String> mapele = new HashMap<String, String>();
				String text = e.attributeValue("text");
				mapele.put("text", text);
				String value = e.attributeValue("value");
				mapele.put("value", value);
				String selected = e.attributeValue("selected"); // -1时为有默认值
				mapele.put("selected", selected);
				listmap.add(mapele);
				listmaplist.add(listmap);
			}
			map.put(controID, listmaplist);
			return map;
		}else{
			return map;
		}
		
	}

	/**
	 * 列表框
	 * 
	 * @param controID
	 * @param el
	 * @return // 下拉框ID 与下拉框中的值对应
	 */
	public Map<String, List<List<Map<String, String>>>> getlist(
			String controID, Element el) {
		// 下拉框ID 与下拉框中的值对应
		Map<String, List<List<Map<String, String>>>> map = new HashMap<String, List<List<Map<String, String>>>>();
		if(el!=null){
			List<Element> liste = el.elements();
			// 单个下拉框中所有值
			List<List<Map<String, String>>> listmaplist = new ArrayList<List<Map<String, String>>>();
			// 下拉框中单个选项的key-value
			List<Map<String, String>> listmap = new ArrayList<Map<String, String>>();
			for (Element e : liste) {
				Map<String, String> mapele = new HashMap<String, String>();
				String text = e.attributeValue("text");
				mapele.put("text", text);
				String value = e.attributeValue("value");
				mapele.put("value", value);
				String selected = e.attributeValue("selected"); // -1时为有默认值
				mapele.put("selected", selected);
				listmap.add(mapele);
				listmaplist.add(listmap);
			}
			map.put(controID, listmaplist);
			return map;
		}else{
			return map;
		}
		
	}

	public Map<String, List<Map<String, String>>> getbutton(String datatype,
			Element ele) {
		Map<String, List<Map<String, String>>> mapprov = new HashMap<String, List<Map<String, String>>>();
		@SuppressWarnings("unused")
		List<Map<String, String>> maplist = new ArrayList<Map<String, String>>();
		return mapprov;
	}
}

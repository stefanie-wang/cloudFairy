package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.List;

import org.dom4j.Element;

import com.ucap.cloud.business.formserver.data.model.RepeatCalculateModel;
import com.ucap.cloud.business.formserver.data.model.RepeateTable;

public interface CssUntiltable  {

//	/**
//	 * 处理重复表
//	 * @param controlsson idf重复表节点
//	 * @param pxl    解析idf类 
//	 * @return     返回重复表本身以及控件的css样式
//	 * @throws Exception
//	 */
//	public List<String> getTable(Element controlsson,CssUntilParseXML pxl) throws Exception;
	
	/**
	 * 解析重复表中的计算公式
	 * @param columns idf节点
	 * @return  计算公式模型
	 */
	public RepeatCalculateModel getbinds(Element columns);
	/**
	 *   解析重复表本身的属性
	 * @param repeatt 重复表模型
	 * @param columns idf重复表节点
	 * @return        模型
	 */
	public RepeateTable getTableAtrr(RepeateTable repeatt,Element columns);
	/**
	 * 解析重复表内的控件并生成String
	 * @param columns  重复表节点
	 * @param pxl      idf解析类
	 * @param repeatt  重复表模型
	 * @param tablerowcount  总行数
	 * @param tablename   重复表名称
	 * @return           重复表内的控件的css样式集合
	 * @throws Exception
	 */
	public List<String> getTableControls(Element columns,CssUntilParseXML pxl,RepeateTable repeatt,int tablerowcount,String tablename) throws Exception;
	
}

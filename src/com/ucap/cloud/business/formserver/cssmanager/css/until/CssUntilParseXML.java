/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssUntilParseXML.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 */

package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Element;

import com.ucap.cloud.business.formserver.compute.ComputerImpl;
import com.ucap.cloud.business.formserver.compute.ComputerLoader;
import com.ucap.cloud.business.formserver.cssmanager.css.getcssfiledate.GetCssFileDateGetSortCss;
import com.ucap.cloud.business.formserver.data.model.BarCodeModel;
import com.ucap.cloud.business.formserver.data.model.DataEventLoader;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.DataModelProLoader;
import com.ucap.cloud.business.formserver.data.model.InputModel;
import com.ucap.cloud.business.formserver.data.model.RoleModel;
import com.ucap.cloud.business.formserver.validate.ValidataLoader;

/**
 * @ClassName CssUntilParseXML
 * @Description TODO 解析idf文件
 * @author pzg
 * @date 2012-8-10
 */
public class CssUntilParseXML implements CssUntilCreateCss {
	
	/** 
	* @Fields roles : 保存表单的角色信息，key为角色的ID
	*/
	private Map<String,RoleModel> roles = new HashMap<String, RoleModel>();
	public Map<String, RoleModel> getRoles() {
		return roles;
	}



	public void setRoles(Map<String, RoleModel> roles) {
		this.roles = roles;
	}
	public void setRoles(String key, RoleModel role) {
		this.roles.put(key, role);
	}
	
	private String idfname = "";
	 
    public String getIdfname() {
		return idfname;
	}

	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}

	private String xmlpath ="";
	
	private String xslt ="";
	
	private String path ="";
	
	/** 
	* @Fields tablexslt : 处理重复表弹出页面的xslt
	*/
	private String tablexslt = "";

	/** 
	* @Fields blockxslt : 处理重复块弹出页面的xslt
	*/
	private String blockxslt = "";
	
	
	
	public String getBlockxslt() {
		return blockxslt;
	}

	public void setBlockxslt(String blockxslt) {
		this.blockxslt = blockxslt;
	}

	public String getTablexslt() {
		return tablexslt;
	}

	public void setTablexslt(String tablexslt) {
		this.tablexslt = tablexslt;
	}

	public String getXmlpath() {
		return xmlpath;
	}

	public void setXmlpath(String xmlpath) {
		this.xmlpath = xmlpath;
	}

	public String getXslt() {
		return xslt;
	}

	public void setXslt(String xslt) {
		this.xslt = xslt;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 *  IDF中的所有重复表或者是重复块或者是表格 map 是 重复块或者重复表的节点  --类型名称（如table）
	 */
	private List<Map<String,Element>> listtableorrepat = new ArrayList<Map<String,Element>>() ;
	


	static private Logger log = Logger.getLogger(CssUntilParseXML.class);
	/**
	 * 保存重复快内的控件
	 */
	private List<String> listorther = new ArrayList<String>();
	public List<Map<String, Element>> getListtableorrepat() {
		return listtableorrepat;
	}

	public void setListtableorrepat(List<Map<String, Element>> listtableorrepat) {
		this.listtableorrepat = listtableorrepat;
	}

	/**
	 * 控件属性
	 */
	private CssUntilGetAttributeImpl cuntilattribute ;
	/**
	 *  处理表格
	 */
	private CssUntilGetGridImpl grid;
	/**
	 * 处理重复快
	 */
	private CssUntilRepeatImpl repeatim ;
	/**
	 * 处理重表
	 */
	private  CssUntiltableImpl  chongftable;
	public CssUntiltableImpl getChongftable() {
		return chongftable;
	}

	public void setChongftable(CssUntiltableImpl chongftable) {
		this.chongftable = chongftable;
	}

	public CssUntilRepeatImpl getRepeatim() {
		return repeatim;
	}

	public void setRepeatim(CssUntilRepeatImpl repeatim) {
		this.repeatim = repeatim;
	}

	public CssUntilGetGridImpl getGrid() {
		return grid;
	}

	public void setGrid(CssUntilGetGridImpl grid) {
		this.grid = grid;
	}

	public CssUntilGetAttributeImpl getCuntilattribute() {
		return cuntilattribute;
	}

	public void setCuntilattribute(CssUntilGetAttributeImpl cuntilattribute) {
		this.cuntilattribute = cuntilattribute;
	}

	/** 
	* @Fields tablejsppath : TODO
	* 保存重复表新页的路径
	*/
	private String tablejsppath = "";
	/**
	 * 保存重复表的控件
	 */
	@SuppressWarnings("unused")
	private List<String> listcfb = new ArrayList<String>();

	/**
	 * 提取所有的可输入信息,验证信息，计算公式信息
	 */
	private DataModel dm = new DataModel();
	/**
	 * 
	 */
	private DataEventLoader devl;

	/**
	 * 提取验证数据信息
	 */
	private ValidataLoader vl;
	/**
	 * 计算公式提取
	 */
	private ComputerLoader cloader;

	/**
	 * 进行后台计算
	 */
	private ComputerImpl computer;

	public ComputerImpl getComputer() {
		return computer;
	}

	public void setComputer(ComputerImpl computer) {
		this.computer = computer;

	}

	/**
	 * @Title: init
	 * @Description: TODO
	 *               <p>
	 *               类加载的时候执行的方法
	 *               </p>
	 * @param    
	 * @return void   
	 * @throws
	 */
	public void init() {
		this.dm = new DataModel();
		this.vl = new ValidataLoader(this.dm);
		this.cloader = new ComputerLoader(this.dm);
		
	}

	/**
	 * 获取所有需要进行解析的具体类对象
	 */
	private Map<String, CssUntilGetAllModel> map ;

	/**
	 * 需要进行解析的属性名列表
	 */
	private DataModelProLoader dp;

	public DataModelProLoader getDp() {
		return dp;
	}

	public void setDp(DataModelProLoader dp) {
		this.dp = dp;
	}

	public DataModel getDm() {
		return dm;
	}

	private List<String> listre = new ArrayList<String>();
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	/**
	 * <p>
	 * Title:
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 */
	public CssUntilParseXML() {
		log.info("开始时间" + new Date());
	}

	/**
	 * @Title: getinput
	 * @Description: TODO
	 *               <p>
	 *               获取表单的可输入项信息
	 *               </p>
	 * @param controlsson
	 *              含有控件的节点信息 
	 * @return void   
	 * @throws
	 */
	public void getinput(Element controlsson) {
		    // 输入框的属性集合 如：readonly disable
		//if(!controlsson.getName().equals("label")){
			 InputModel in  = this.cuntilattribute.getinput(controlsson,this.vl);
			    String contype = in.getControlType();
			    if(contype.equals("checkBox")){
			    	String groupname = in.getGroupName();
			    	if(this.dm.getCheckBoxGroup().get(groupname)==null){
			    		List<String> checklist = new ArrayList<String>();
			    		checklist.add(in.getName());
			    		this.dm.setCheckBoxGroup(groupname, checklist);
			    	}else{
			    		this.dm.getCheckBoxGroup().get(groupname).add(in.getName());
			    	}
			    }
				this.dm.setXpathinput(in.getNamepath(), in);
				this.dm.setInputs(in);
				//js事件类型
				this.dm.setEvents(in.getEv());
		//}
		   
	}
	/**
	 * 获得所有的css样式 不分类 解析dom对象下面的controls节点
	 * 
	 * @param doc
	 *            默认是根节点
	 * @return 所有控件css的集合
	 * @throws Exception
	 *             异常
	 */
	@SuppressWarnings("unchecked")
	public List<String> getCssString(Element doc) throws Exception {
		log.info("开始时间" + new Date());
//		List<String> arr = new ArrayList<String>();
		//解析全局函数
		this.getOther(doc);
		List<Element> elroles = (List<Element>) doc	.selectNodes("//uformdoc/formdoc/uform/roles");
		//Element roles = doc.element("//uformdoc/formdoc/uform/roles");
		if(elroles!=null && elroles.size()>0){
			Element roleElement = elroles.get(0);
			UntilGetRoles getRoles = new UntilGetRoles();
			this.roles = getRoles.getRoles(roleElement);
		}
		//css样式总集合
		List<String> list = new ArrayList<String>();
		List<Element> listpage =new ArrayList<Element>();
		listpage = (List<Element>) doc	.selectNodes("//uformdoc/formdoc/uform/form/pages/page/controls");
		if(listpage.size()>0){
			for (int i = 0; i < listpage.size(); i++) {
				/* xml中controls节点 */
				Element controlselement = listpage.get(i);
				// controls节点下面的子节点集合
				List<Element> listcontrols = controlselement.elements();
				int n = listcontrols.size();
				for (int j = 0; j < n ; j++) {
					//map 是 重复块或者重复表的节点  --类型名称（如table）
					Map<String,Element> maptable = new HashMap<String, Element>();
					Map<String,List<String>> mapbarcode = new HashMap<String, List<String>>();//保存表单里面的条形码控件
					// 根controls节点下面的子节点(控件是正常位置的)
					Element controlsson = listcontrols.get(j);
					String key = controlsson.getName();
					if(key.equals("barcode")){
						BarCodeModel barcode = new BarCodeModel();
						String codeType = controlsson.attributeValue("barcodeType");
						String id = controlsson.attributeValue("name");
						String codevalue = controlsson.attributeValue("barcode");
						String showLabel = controlsson.attributeValue("showLabel");
						barcode.setCodeType(codeType);
						barcode.setId(id);
						barcode.setValue(codevalue);
						barcode.setShowLabel(showLabel);
						this.dm.setBarcodes(barcode);
					}
					if(key.equals("graphic")||key.equals("movimg")){
						this.getinput(controlsson);
					}
					if (null != this.map.get(key) ) {
						// //关联数据 例如：namepath="/ucapform/cpy_21"
						
						this.getinput(controlsson);
						list.add(this.map.get(key).getStringCss(controlsson));
					}
					// 表格 重复表，重复快
					else if (null!=getbigconmap.get(controlsson.getName())) {
						//主要处理重复表和重复块
						maptable.put(controlsson.getName(), controlsson);
						listtableorrepat.add(maptable);
						// end 
						this.setPath(path);
						this.setXmlpath(xmlpath);
						this.setXslt(xslt);
						this.setTablejsppath(tablejsppath);
						list.addAll(getbigconmap.get(controlsson.getName()).getBigControls(controlsson,this));
					}
				}
			}
		}
		//add by sunjq
		UntilGetTabIndex gettabIndex = new UntilGetTabIndex();
		gettabIndex.getTabIndex(listpage,this.dm);
		//end add
		log.info("解析XMl结束" + new Date());
		return list;
	}
	/**
	 * 解析IDf文件中的 全局函数，计算公式
	 * @param doc  IDF文件
	 */
    @SuppressWarnings("unchecked")
	public void getOther(Element doc){
    	// add by sunjq 解析全局函数
		List<Element> FormJavaScriptList = (List<Element>) doc
		.selectNodes("//uformdoc/formdoc/uform/form/extras/FormJavaScript");
		String FormJavaScript = "";
		if (null != FormJavaScriptList.get(0).getText()) {
			FormJavaScript = FormJavaScriptList.get(0).getText();
		}
		this.dm.setFormJavaScript(FormJavaScript);
		//计算公式
		this.cloader.loader((Element) doc
				.selectSingleNode("/uformdoc/formdoc/uform/model/binds"));
		this.computer.setDm(this.dm);
    }
	public ComputerLoader getCloader() {
		return cloader;
	}

	public void setCloader(ComputerLoader cloader) {
		this.cloader = cloader;
	}

	/**
	 * 将所有的控件集合按照一定的类型分类
	 * 
	 * @param doc
	 *            默认是根节点
	 * @return 按照某一类别分类以后的集合
	 * @throws Exception
	 */
	public List<String> getS(Element doc) throws Exception {
		GetCssFileDateGetSortCss gcc = new GetCssFileDateGetSortCss();
		return gcc.getsotrcss(this.getCssString(doc));
	}
	private Map<String,CssUntilGetModel> getbigconmap;
	
    public Map<String, CssUntilGetModel> getGetbigconmap() {
		return getbigconmap;
	}

	public void setGetbigconmap(Map<String, CssUntilGetModel> getbigconmap) {
		this.getbigconmap = getbigconmap;
	}


	public Map<String, CssUntilGetAllModel> getMap() {
		return map;
	}

	public void setMap(Map<String, CssUntilGetAllModel> map) {
		this.map = map;
	}

	public List<String> getListorther() {
		return listorther;
	}

	public void setListorther(List<String> listorther) {
		this.listorther = listorther;
	}

	public List<String> getListre() {
		return listre;
	}

	public void setListre(List<String> listre) {
		this.listre = listre;
	}

	public DataEventLoader getDevl() {
		return devl;
	}

	public void setDevl(DataEventLoader devl) {
		this.devl = devl;
	}

	public String getTablejsppath() {
		return tablejsppath;
	}

	public void setTablejsppath(String tablejsppath) {
		this.tablejsppath = tablejsppath;
	}
	
}

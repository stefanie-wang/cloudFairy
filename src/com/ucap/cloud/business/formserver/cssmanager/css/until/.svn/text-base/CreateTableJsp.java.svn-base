/**  
 * @Project: cloudFairy
 * @Title: CreateTableJsp.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 * @Description: TODO
 * @authorshenyanghong ahong2011@gmail.com
 * @date 2012-8-27 下午04:20:40
 * @Copyright: 2012 
 * @version V1.0  
 */

package com.ucap.cloud.business.formserver.cssmanager.css.until;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @ClassName CreateTableJsp
 * @Description <p>
 * 生成重复表填报时点击弹出的新页
 * </p>
 * @author sunjq
 * @date 2012-8-27
 */

public class CreateTableJsp {

	/** 
	 * <p>Title:CreateTableJsp </p>
	 * <p>Description:生成重复表填报时点击弹出的新页 </p> 
	 */

	public CreateTableJsp() {
		// TODO Auto-generated constructor stub
	}
	public CreateTableJsp(CssUntilParseXML pxl){
		this.xmlpath        = pxl.getXmlpath();
		this.xslt           = pxl.getXslt();
		this.tablejspsrc    = pxl.getTablejsppath();
		this.idfname        = pxl.getIdfname();
	}
	private String idfname ="";
	public String getIdfname() {
		return idfname;
	}
	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}
	/** 
	 * @Fields tablejspsrc : 生成重复表新弹出页面的路径
	 */
	private String tablejspsrc = "";

	/** 
	 * @Fields tablename : 重复表控件的ID
	 */
	private String tablename = "";
	
	/** 
	* @Fields xmlpath : 发布的idf文件的路径
	*/
	private String xmlpath ="";

	/** 
	* @Fields xslt : 工程中xslt的路径（重复表单独的xslt）
	*/
	private String xslt ="";

	/** 
	* @Fields path : 生成JSP的路径
	*/
	private String path ="";

	@SuppressWarnings("unchecked")
	public String ceeatetablejsp(){
		SAXReader reader = new SAXReader();
		String jsp1  ="";
		try {
			reader
			.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);
			Document doc = reader.read(new File(xmlpath));

			// 总文件
			List<Element> listpage = (List<Element>) doc
			.selectNodes("//uformdoc/formdoc/uform/form/pages/page/controls/table");
			for (int i = 0; i < listpage.size(); i++) {				
				// page 节点
				Element e1 = listpage.get(i);
				if(e1.element("name").getText().equals(tablename)){
					StringBuilder start = new StringBuilder();
					start.append( CssUntilfinelPath.TABLEXMLSTART);
					start.append(e1.asXML());
					start.append(CssUntilfinelPath.TABLEXMLEND);
					jsp1 = CssUntilJSPCreate.creattableJsp(xslt,
							start.toString(), "");
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//			logger.info(e.getMessage());
		}
		String idfurl = idfname.hashCode()+"";
		File tablejsp = new File(this.tablejspsrc+"/"+idfurl+"_"+tablename+".jsp");//创建新的弹出页面
		try {
			FileOutputStream fw = new FileOutputStream(tablejsp);
			byte[] temp = jsp1.getBytes();
			fw.write(temp);//将新页面中的脚本信息写入到新页面中
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsp1;
	}
	
	public String createBlockJsp(){
		SAXReader reader = new SAXReader();
		String jsp1  ="";
		try {
			reader
			.setFeature(
					"http://apache.org/xml/features/nonvalidating/load-external-dtd",
					false);
			Document doc = reader.read(new File(xmlpath));

			// 总文件
			List<Element> listpage = (List<Element>) doc
			.selectNodes("//uformdoc/formdoc/uform/form/pages/page/controls/repeatUnit");
			for (int i = 0; i < listpage.size(); i++) {				
				// page 节点
				Element e1 = listpage.get(i);
				if(e1.element("name").getText().equals(tablename)){
					StringBuilder start = new StringBuilder();
					start.append( CssUntilfinelPath.TABLEXMLSTART);
					start.append(e1.asXML());
					start.append(CssUntilfinelPath.TABLEXMLEND);
					jsp1 = CssUntilJSPCreate.creattableJsp(xslt,
							start.toString(), "");
				}
			}
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//			logger.info(e.getMessage());
		}
		String idfurl = idfname.hashCode()+"";
		File tablejsp = new File(this.tablejspsrc+"/"+idfurl+"_"+tablename+".jsp");//创建新的弹出页面
		try {
			FileOutputStream fw = new FileOutputStream(tablejsp);
			byte[] temp = jsp1.getBytes();
			fw.write(temp);//将新页面中的脚本信息写入到新页面中
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsp1;
	}

	public void createjsp(){	

	}


	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTablejspsrc() {
		return tablejspsrc;
	}
	public void setTablejspsrc(String tablejspsrc) {
		this.tablejspsrc = tablejspsrc;
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




}

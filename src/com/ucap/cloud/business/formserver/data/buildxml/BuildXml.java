/**
 * <br>
 * BuildXml<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: BuildXml.java
 * @Package com.ucap.cloud.business.formserver.data.buildxml
 */
package com.ucap.cloud.business.formserver.data.buildxml;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import net.sf.ehcache.Cache;
import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.NiMingIdfModel;
import com.ucap.cloud.business.formserver.data.model.UserDataModel;


/**
 * @ClassName BuildXml
 * @Description TODO 根据前端Json构建XmL
 * @author sunjq
 * @date 2012-8-10
 */
public class BuildXml {

	/**
	 * <p>
	 * Title:BuildXml
	 * </p>
	 * <p>
	 * Description:根据前端Json构建XmL
	 * </p>
	 */
	public BuildXml() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @Fields idfType : 表单的类型
	 */
	private String idfType ="";
	/** 
	 * @Fields dm : 前端传来的DM对象
	 */
	private DataModel dm;
	/** 
	 * @Fields userid : 用户ID
	 */
	private String userid;
	/** 
	 * @Fields idfname : DM对象对应的idfname
	 */
	private String idfname;

	/** 
	 * @Fields filepath : 保存上传数据文件的路径
	 */
	private String filepath;

	/** 
	 * @Fields idfpath : 保存上传idf文件的路径
	 */
	private String idfpath;

	/** 
	 * @Fields xmlpath : 保存生成xml文件的路径
	 */
	private String xmlpath;

	/** 
	 * @Title: build 
	 * @Description: 依据DM对象中每个控件的NamePath生成XML文件
	 * @param      
	 * @return void     
	 * @throws 
	 */
	@SuppressWarnings("unchecked")
	public void build() {

		CreateCaches cc = (CreateCaches) SPRINGCONTEXT.getBean("ucapcache");
		// 获得缓存datacache
		Cache datacache = cc.getCache("datacache");

		SAXReader reader = new SAXReader();
		// 如果可以从缓存中取到绑定的信息，说明有初始化数据文件，此时就拿初始化数据文件作为数据交换的XML文件
		if (null != datacache.get(userid + idfname)) {

			// 获得绑定的用户数据信息
			UserDataModel userdm = (UserDataModel) datacache.get(
					userid + idfname).getValue();
			// 获得绑定的数据文件的路径
			String filename = userdm.getDatafile();

			// 解析数据文件，根据DM完成赋值
			try {
				// 解析数据文件
				if (idfname.contains(".idf")) {
					idfname = idfname.substring(0,idfname.lastIndexOf("."));
				}
				File files = new File(filepath + "/" + filename);
				Document doc = reader.read(files);

				// 根据DM完成赋值
				getPath(doc);
				//将节点信息转换为字符串信息
				String rrr = doc.asXML();
				//获取当前系统时间
				Date date = new Date();
				DateFormat df = DateFormat.getDateInstance();
				//依据系统时间和用户ID，idf名称生成XML文件
				FileOutputStream output = new FileOutputStream(new File(xmlpath
						+ "\\" + userid + "_" + idfname + "_" + df.format(date)
						+ ".xml"));
				//将节点信息写入到XML文件中
				output.write(rrr.getBytes("GBK"));
				output.close();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 如果取不到，就截取原始IDF文件的节点作为DOM对象用于数据的交换
		} else {
			try {
				// 解析IDF文件
				if (idfname.contains(".idf")) {
					idfname = idfname.substring(0,idfname.lastIndexOf("."));
				}
				File files = new File(idfpath + "\\" + idfname + ".idf");
				Document doc = reader.read(files);
				// 在IDF文件中找到model_instance节点下的内容
				int p = 0;
				List list = doc
				.selectNodes("/uformdoc/formdoc/uform/model/dataModel/model_instance/ucapform");
				if(list.size()== 0){ //如果找不到ucapform节点，就取下面的model_instance节点
					list = doc
					.selectNodes("/uformdoc/formdoc/uform/model/dataModel/model_instance");
					p=1;
				}

				Iterator it = list.iterator();

				while (it.hasNext()) {
					Element ee = (Element) it.next();

					StringBuilder sb = new StringBuilder();
					// 将model_instance节点生成字符串
					String re = ee.asXML();
					if(p==1){
						re = re.replaceAll("<model_instance>", "");
						re = re.replaceAll("</model_instance>", "");
					}else{
						re = re.replaceAll("<ucapform>", "");
						re = re.replaceAll("</ucapform>", "");
					}
					// 将model_instance节点去掉，生成规范的DOM信息

					// 添加data节点，生成正确的字符串
					sb.append("<?xml version='1.0' encoding='UTF-8'?>");
					sb.append("<data>");
					sb.append(re);
					sb.append("</data>");

					String strxml = sb.toString();
					// 根据Dom结构的字符串生成document对象
					Document document = DocumentHelper.parseText(strxml);

					// 完成赋值
					getPath(document);

					String rr = document.asXML();
					try {
						//获取当前系统时间
						Date date = new Date();
						DateFormat df = DateFormat.getDateInstance();
						if(idfType.equals("niming")){
							NiMingIdfModel nm = (NiMingIdfModel) cc.getVluae(idfname);
							File filedir = new File(xmlpath + "/"+idfname+"/" 
									+ idfname +nm.getDataList().size()+""+".xml");
							if (!filedir.getParentFile().exists()) {
								filedir.getParentFile().mkdirs();
							}
							FileOutputStream output = new FileOutputStream(filedir);
							//将节点信息写入XML文件
							output.write(rr.getBytes("UTF-8"));
							output.close();

						}else{
							FileOutputStream output = new FileOutputStream(
									new File(xmlpath + "\\" + userid + "_"
											+ idfname + "_" + df.format(date)
											+ ".xml"));
							//将节点信息写入XML文件
							output.write(rr.getBytes("UTF-8"));
							output.close();
						}
						//依据用户ID，idf文件名称和系统时间生成交换数据的文件


					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Element cloneElement(Element e){

		return null;
	}

	/** 
	 * @Title: getPath 
	 * @Description: TODO 根据DM为数据文件赋值
	 * @param  doc  数据文件dom   
	 * @return void     
	 * @throws 
	 */
	
	public void getPath(Document doc) {
		BuildRepeatTableXml buildRepTab = new BuildRepeatTableXml();//处理DM中的重复表信息
		buildRepTab.build(doc, dm);
		BuildInputsXml buildinputs = new BuildInputsXml();//处理DM中的基础控件
		buildinputs.build(doc, dm);
		BuildRepeatBlockXml buildRepBlock = new BuildRepeatBlockXml();//处理DM中的重复块信息
		buildRepBlock.build(doc, dm);

		System.out.println("生成XMl完成………………");

	}

	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getIdfname() {
		return idfname;
	}

	public void setIdfname(String idfname) {
		this.idfname = idfname;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getIdfpath() {
		return idfpath;
	}

	public void setIdfpath(String idfpath) {
		this.idfpath = idfpath;
	}

	public String getXmlpath() {
		return xmlpath;
	}

	public void setXmlpath(String xmlpath) {
		this.xmlpath = xmlpath;
	}

	public String getIdfType() {
		return idfType;
	}

	public void setIdfType(String idfType) {
		this.idfType = idfType;
	}

}

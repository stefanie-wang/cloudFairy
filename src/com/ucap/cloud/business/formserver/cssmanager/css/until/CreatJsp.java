/**
 * <br>
 * CSS Greate<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CreatJsp.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.until
 */

package com.ucap.cloud.business.formserver.cssmanager.css.until;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.apache.log4j.Logger;

import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.business.formserver.idf.model.UserModel;

/**
 * @ClassName CreatJsp
 * @Description TODO 根据上传的idf文件生成jsp页面
 * @author piaozg
 * @date 2012-8-10
 */
public class CreatJsp extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** 
	* @Fields idfType : 表示IDF文件的类型
	*/
	private String idfType = "";
	
	/** 
	* @Fields zdusers : 保存指定的用户列表
	*/
	private List<String> zdusers = new ArrayList<String>();
	
	

	public List<String> getZdusers() {
		return zdusers;
	}

	public void setZdusers(List<String> zdusers) {
		this.zdusers = zdusers;
	}

	public String getIdfType() {
		return idfType;
	}

	public void setIdfType(String idfType) {
		this.idfType = idfType;
	}

	// private static Logger logger = Logger.getLogger(CreatJsp.class);
	/**
	 * 将表单生成JSP
	 */
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		JspCreate_util create = (JspCreate_util) SPRINGCONTEXT
				.getBean("createJsp");
		// String xmlpaths[] = req.getParameterValues("checkbox");
		// 获取发布的表单名称
		String xmlpath = (String) req.getAttribute("filename");
		/*// 判断是否为压缩格式
		if (xmlpath.indexOf("zip") != -1) {
			xmlpath = xmlpath.substring(0, xmlpath.lastIndexOf("."));
		}*/
		UserModel um = (UserModel) req.getSession().getAttribute("userid");
		String userid = um.getUsername();// 在session内拿到用户信息// 在session内拿到用户信息
		create.setUserid(userid);
		create.setZdusers(zdusers);
		create.setIdfType(idfType);
		List<String> useridf = new ArrayList<String>();
		@SuppressWarnings("unused")
		CreateCaches cache = create.getCache();
		String filename1 = this.getFiname(xmlpath);
		String filename = filename1.substring(filename1.lastIndexOf("\\") + 1);
		useridf.add(filename);
		String xslt = (String) req.getAttribute("realpath")
				+ "/formxslt/ucap_form.xsl";//主页面的xslt
		String xslt1 = (String) req.getAttribute("realpath")
		+ "/formxslt/ucap_table.xsl";//重复表弹出页面的xslt
		String blockxslt = (String) req.getAttribute("realpath")
		+ "/formxslt/ucap_block.xsl";//重复块弹出页面的xslt

		String tablepath = (String) req.getAttribute("realpath")+"/formjsp/tablejsp";
		req.setAttribute("idfname", filename);
		create.setTablepath(tablepath);
		create.setBlockxslt(blockxslt);
		create.setFilename(filename);
		create.setXslt(xslt);
		create.setXslt1(xslt1);
		create.setXmlpath(xmlpath);
		create.setPath((String) req.getAttribute("realpath"));
		create.doit();
		// 获取已发布的idf文件
		Map<String, List<String>> mm = new HashMap<String, List<String>>();
		mm.put(userid, useridf);
		req.getRequestDispatcher("/listIdf.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

	/**
	 * @Title: getFiname
	 * @Description: TODO
	 * @param s
	 *            文件路径
	 * @return String  文件名带后缀的 
	 * @throws
	 */
	private String getFiname(String s) {
		String ss = s.substring(s.lastIndexOf("/") + 1, s.lastIndexOf("."));
		//ss.substring(s.lastIndexOf("\\") + 1, s.lastIndexOf("."));
		return ss;
	}

	/**
	 * 遍历文件夹
	 * 
	 * @param strPath
	 *            文件夹位置
	 * @return 包含文件全路径的集合
	 */
	public List<String> refreshFileList(String strPath) {
		List<String> list = new ArrayList<String>();
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		if (files == null)
			return list;
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				refreshFileList(files[i].getAbsolutePath());
			} else {
				// String strFileName =
				// files[i].getAbsolutePath().toLowerCase();
				list.add(files[i].getAbsolutePath());
			}
		}
		return list;
	}

}

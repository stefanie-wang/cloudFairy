/**
 * 
 */
package com.ucap.cloud.builder.loader;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipException;

import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfUserModel;
import com.ucap.cloud.business.formserver.data.model.AllNiMingIdfModel;

/**
 * @ClassName FoundIdf
 * @Description TODO
 *              <P>
 *              处理遍历文件的工具
 *              </P>
 * @author sunjq
 * @date 2012-8-10
 */
@SuppressWarnings("unchecked")
public class FoundIdf {

	/**
	 * 遍历一个文件下的所有IDF文件
	 */
	public FoundIdf() {
		// TODO Auto-generated constructor stub
	}

	ArrayList filelist = new ArrayList();
	String strFileName;
	List<String> filesName = new ArrayList();
	List<File> refiles = new ArrayList<File>();
	private String userid;

	public List<File> found(String strPath) throws ZipException, IOException {

		CreateCaches cc = (CreateCaches) SPRINGCONTEXT.getBean("ucapcache");

		Set<String> listready = new HashSet<String>();
		if (null != cc.getVluae(userid)) {
			IdfUserModel user = (IdfUserModel) cc.getVluae(userid);

			listready = user.getIdfmessage().keySet();
		}
		File dir = new File(strPath);
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].isDirectory()) {
				found(files[i].getAbsolutePath());
			} else {
				strFileName = files[i].getAbsolutePath();
				if (strFileName.endsWith("idf")) {
					String strfilenameidf = strFileName.substring(strFileName
							.lastIndexOf("\\") + 1);

					int z = 0;
					for (String s : listready) {
						if (strfilenameidf.equals(s + ".idf")) {
							z = 1;
						}
					}
					if (z == 0) {
						filesName.add(strFileName);
						refiles.add(files[i]);
					}

				}
			}
		}
		return refiles;
	}

	// 获取已发布的IDF
	public List<String> founalready() {
		CreateCaches cc = (CreateCaches) SPRINGCONTEXT.getBean("ucapcache");

		List<String> listready = new ArrayList<String>();
		if (null != cc.getVluae(userid)) {
			IdfUserModel user = (IdfUserModel) cc.getVluae(userid);
			Set<String> set = new HashSet<String>();
			set = user.getIdfmessage().keySet();
			for (String s : set) {
				listready.add(s);
			}

		}
		return listready;
	}
	// 获取所有匿名发布的idf文件
	public List<String> foundNiMing() {
		CreateCaches cc = (CreateCaches) SPRINGCONTEXT.getBean("ucapcache");

		List<String> listnm = new ArrayList<String>();
		if (null != cc.getVluae("allNiMingIdf")) {
			AllNiMingIdfModel allnm = (AllNiMingIdfModel) cc.getVluae("allNiMingIdf");
			Set<String> set = allnm.getAllIdf().keySet();			
			for (String s : set) {
				listnm.add(s);
			}
		}
		return listnm;
	}
	
	
	
	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}

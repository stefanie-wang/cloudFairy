/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: LoderUserData.java
 * @Package com.ucap.cloud.business.formserver.data.initdata
 */
package com.ucap.cloud.business.formserver.data.initdata;

import static com.ucap.cloud.builder.servlet.UCAPDispathcherServlet.SPRINGCONTEXT;

import java.io.File;

import net.sf.ehcache.Cache;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import com.ucap.cloud.builder.cache.util.CreateCaches;


import com.ucap.cloud.business.formserver.data.model.DataModel;
import com.ucap.cloud.business.formserver.data.model.UserDataModel;

/**
 * @ClassName LoderUserData
 * @Description TODO  解析数据文件，绑定的idf文件并赋值
 * @author sunjq
 * @date 2012-8-10
 */
public class LoderUserData extends Thread{
	/** 
	* <p>Title:LoderUserData </p> 
	* <p>Description:解析数据文件，绑定的idf文件并赋值 </p>  
	*/
	public LoderUserData() {
		// TODO Auto-generated constructor stub
	}

	/** 
	* @Fields userid : 用户的ID
	*/
	private String userid;
	
	/** 
	* @Fields idfname :绑定的IDF名字
	*/
	private String idfname;
	
	/** 
	* @Fields filepath : 保存数据文件的路径
	*/
	private String filepath;
	
	/** 
	* @Fields dm : TODO
	* idf文件的数据信息
	*/
	private DataModel dm;
	
	public void run(){
		
		this.loard();
	}
	/** 
	* @Title: loard 
	* @Description: TODO 加载数据文件并完成赋值
	* @return     
	* @return DataModel 返回赋值后的数据信息    
	* @throws 
	*/
	public DataModel loard() {
		// 获取缓存读取工具
		CreateCaches ucapcache = (CreateCaches) SPRINGCONTEXT
				.getBean("ucapcache");
		//获取datacache，保存用户绑定初始化信息的缓存
		Cache datacache = ucapcache.getCache("datacache");
		//如果通过userid和idfname不为空
		if (null != datacache.get(userid + idfname)) {

			// 根据用户名和idf名从DATAcache缓存中获取绑定好的模型
			UserDataModel userdm = (UserDataModel) datacache.get(
					userid + idfname).getValue();

			// 根据用户ID和idf名字获取数据文件
			String datafilename = userdm.getDatafile();
				
			SAXReader reader = new SAXReader();
			/**
			 *解析数据文件，并完成赋值
			 */
			try {
				//解析XML文件
				File file = new File(filepath + "/" + datafilename);
				Document doc = reader.read(file);				
				// 将从缓存中拿到的DM对象赋值给要初始化的公式
				InitUserData dd = new InitUserData(dm);
				// 完成赋值
				dd.initdm(doc);
				// 初始化完成后，将缓存的绑定信息删除
				//datacache.remove(userid + idfname);

			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return dm;
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

	public DataModel getDm() {
		return dm;
	}

	public void setDm(DataModel dm) {
		this.dm = dm;
	}

	
}

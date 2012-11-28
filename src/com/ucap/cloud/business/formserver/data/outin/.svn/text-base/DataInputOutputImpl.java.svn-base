/**
 * <br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: DataInputOutputImpl.java
 * @Package com.ucap.cloud.business.formserver.data.outin
 */
package com.ucap.cloud.business.formserver.data.outin;

import static com.ucap.cloud.builder.servlet.Filter.UCAPFilter_encoder.alreadyuser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Set;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.cache.util.CreateCaches;
import com.ucap.cloud.business.formserver.cssmanager.css.cssmodel.IdfUserModel;
import com.ucap.cloud.business.formserver.data.model.AllNiMingIdfModel;
import com.ucap.cloud.business.formserver.data.model.NiMingIdfModel;

/**
 * @ClassName DataInputOutputImpl
 * @Description TODO 序列化实现类
 * @author zhanglj
 * @date 2012-7-26
 */
public class DataInputOutputImpl implements IDataInputOutput {

	private static Logger log = Logger.getLogger(DataInputOutputImpl.class);

	/**
	 * 
	 */
	public DataInputOutputImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 获取缓存的工具类
	 */
	private CreateCaches ccache;
	/**
	 * 文件写出路径
	 */
	private String path;

	public CreateCaches getCcache() {
		return ccache;
	}

	public void setCcache(CreateCaches ccache) {
		this.ccache = ccache;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @Title: getUrl
	 * @Description:获取项目根路径
	 * @param @return   
	 * @return String   返回项目根路径
	 * @throws
	 */
	private String getUrl() {
		String webpath = "";
		URL url = getClass().getProtectionDomain().getCodeSource()
				.getLocation();
		webpath = url.getPath().split("WEB-INF")[0];

		return webpath;
	}

	/*
	 * (non-Javadoc) <p>Title: readerObject</p> <p>Description: </p>
	 * 
	 * 
	 * @return 返回读出的Cache对象
	 * 
	 * @see
	 * com.ucap.cloud.business.formserver.data.outin.IDataInputOutput#readerObject
	 * (java.lang.String)
	 */
	public void readerObject() {

		// 得到缓存
		// CreateCaches cc = (CreateCaches)SPRINGCONTEXT.getBean("ucapcache");报空
		// Cache cache=ccache.getCache("ucapcache");
		ObjectInputStream ois = null;
		String filePath = this.getUrl() + this.path;
		//add by sunjq
		String nmfilePath = this.getUrl() + this.path+"niming.txt";//记录匿名表单序列化文件的地址
		File nmfile = new File(nmfilePath);
		if (nmfile.getParentFile().exists()) {
			try {
				ois = new ObjectInputStream(
						new FileInputStream(nmfile));

				// 得到IdfUserModel对象，该对象存的是一个用户发布的所有idf文件信息
				AllNiMingIdfModel allnm = (AllNiMingIdfModel)ois.readObject();
				// 放入当前缓存
				this.ccache.putElement("allNiMingIdf", allnm);
				// 关闭输入流
				ois.close();
			} catch (Exception e) {
				log.info("cache is null!");
			}
		}
		//end add

		File file = new File(filePath);
		File[] userFiles = file.listFiles();
		// 遍历D:\apache-tomcat-6.0.33\webapps\cloudFairy\datafile下的所有文件
		// 一个i值为一个用户
		// 文件结构为D:\\apache-tomcat-6.0.33\\webapps\\cloudFairy\\datafile\\用户名\\useridf\\userid.txt

		for (int i = 0; i < userFiles.length; i++) {
			if (userFiles[i].isDirectory()) {
				File[] f = userFiles[i].listFiles();
				for (int j = 0; j < f.length; j++) {
					if ("useridf".equals(f[j].getName())) {
						File[] sf = f[j].listFiles();
						for (int t = 0; t < sf.length; t++) {
							if (!sf[t].isDirectory()) {
								try {
									ois = new ObjectInputStream(
											new FileInputStream(this.getUrl()
													+ this.path
													+ userFiles[i].getName()
													+ "/useridf/"
													+ sf[t].getName()));

									// 得到IdfUserModel对象，该对象存的是一个用户发布的所有idf文件信息
									IdfUserModel idf = (IdfUserModel) ois
											.readObject();

									String userid = idf.getUserid();
									// 放入当前缓存
									this.ccache.putElement(userid, idf);
									// 关闭输入流
									ois.close();
								} catch (Exception e) {
									log.info("cache is null!");
								}
							}
						}
					}
				}

			}
		}
	}

	/*
	 * (non-Javadoc) <p>Title: writeObject</p> <p>Description: 将缓存写入本地</p>
	 * 
	 * 
	 * 
	 * @see
	 * com.ucap.cloud.business.formserver.data.outin.IDataInputOutput#writeObject
	 * (java.lang.Object)
	 */
	public void writeObject() {
		// 1.得到当前的用户名
		// 2.根据用户名得到IdfUserModel对象
		// 3.将IdfUserModel对象写入缓存
		// 4.序列化发布的匿名表单
		ObjectOutputStream out;
		//add by sunjq
		try {
			AllNiMingIdfModel allnm = (AllNiMingIdfModel) this.ccache.getVluae("allNiMingIdf");//依据idfname获取匿名表单
			File file = new File(this.getUrl() + this.path + "niming.txt");
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}

			out = new ObjectOutputStream(new FileOutputStream(file));
			// 写入的是IdfUserModel对象
			out.writeObject(allnm);
			// 清空流
			out.flush();
			// 关闭流
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//end add
		Set<String> userMap = alreadyuser.keySet();
		for (String userid : userMap) {
			IdfUserModel user = (IdfUserModel) this.ccache.getVluae(userid);
			if (null == user) {
				return;
			}
			
			try {
				File file = new File(this.getUrl() + this.path + userid + "/"
						+ "useridf/" + (userid + ".txt"));
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}

				out = new ObjectOutputStream(new FileOutputStream(file));
				// 写入的是IdfUserModel对象
				out.writeObject(user);
				// 清空流
				out.flush();
				// 关闭流
				out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
